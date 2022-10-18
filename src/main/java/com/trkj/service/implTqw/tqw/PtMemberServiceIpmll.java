package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.ouyang.ProceedsMapper;
import com.trkj.dao.tqw.*;
import com.trkj.entity.liucz2.Proceeds;
import com.trkj.entity.tqw.*;
import com.trkj.service.implTqw.PtMealService;
import com.trkj.service.implTqw.PtMemberService;
import com.trkj.utils.DateUtil;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo2;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PtMemberServiceIpmll implements PtMemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private PtMealService ptMealService;
    @Resource
    private MemberMealMapper memberMealMapper;
    @Resource
    private ChooseProjectNameMapper chooseprojectnameMapper;
    @Resource
    private PtMemberMapper ptMemberMapper;
    @Resource
    private ComsuneMapper comsuneMapper;
    @Resource
    private PtProjectnameMapper ptProjectnameMapper;
    @Resource
    private ProceedsMapper proceedsMapper;

    /**
     * @title:  查询私教会员列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:19
    */
    @Override
    public IPage<Member> findPtMember(MemberQueryVo memberQueryVo) {
        Page<Member> pageStr=new Page<>(memberQueryVo.getPageNo(),memberQueryVo.getPageSize());
        IPage<Member> Page = ptMemberMapper.findPtMember( pageStr,memberQueryVo);
        return Page;
    }

    /**
     * @title:  新增私教会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:22
    */
    @Override
    @Transactional
    public int addPtMember(MemberQueryVo2 memberQueryVo2) {
        //套餐类型
        memberQueryVo2.setMealType("私教");
        //通过id查询私教套餐
        PtMeall ptMeal = ptMealService.selectPtMealByMealId(memberQueryVo2.getMealId());
        //通过id查询私教项目
        PtProjectname ptProjectname=ptProjectnameMapper.selectById(memberQueryVo2.getProjectId());
        //通过电话和姓名查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_phone", memberQueryVo2.getMemberPhone());
        wrapper1.eq("member_name", memberQueryVo2.getMemberName());
        Member member1 = memberMapper.selectOne(wrapper1);
        //判断是否黑名单
        if(member1 != null){
            if(member1.getMemberState()==1){
                return 4;
            }
        }else if(member1==null){
            return 1;
        }
        //通过电话查会员
        QueryWrapper<Member> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("member_phone", memberQueryVo2.getMemberPhone());
        Member member2 = memberMapper.selectOne(wrapper2);
        //通过名字查电话
        QueryWrapper<Member> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("member_name", memberQueryVo2.getMemberName());
        List<Member> member3 = memberMapper.selectList(wrapper3);
        if (member1 != null) {
            //会员存在
            //判断是否为体验会员
            if(member1.getMemberType()==0){
                //体验会员
                //判断是否办理过套餐（体验会员只能体验一种套餐）
                QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
                wrapper.eq("meal_type", memberQueryVo2.getMealType());
                wrapper.eq("member_id",member1.getMemberId());
                if(memberMealMapper.selectList(wrapper).size()>0){
                    return 6;
                }
                //直接办理套餐
                MemberMeal memberMeal=new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo2.getMealId());
                memberMeal.setMealType(memberQueryVo2.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                Calendar rightNow = Calendar.getInstance();
                rightNow.setTime(new Date());
                rightNow.add(Calendar.DATE ,1);
                memberMeal.setMmDate(rightNow.getTime());
                memberMealMapper.insert(memberMeal);
                //添加所选项目表  项目编号，教练编号，套餐编号
                ChooseProjectName chooseProjectName =new ChooseProjectName();
                chooseProjectName.setMmId(memberMeal.getMmId());
                chooseProjectName.setPtpId(memberQueryVo2.getProjectId());
                chooseProjectName.setEmpId(memberQueryVo2.getEmpId());
                chooseProjectName.setChooseId(memberQueryVo2.getMealId());
                chooseprojectnameMapper.insert(chooseProjectName);
                return 0;
                //无需生成消费记录
            }
            //套餐办理
            //通过会员电话,套餐id,套餐类型,项目id,教练id查询私教套餐办理记录（唯一一条）
            MemberQueryVo memberQueryVo1 = ptMemberMapper.findMemberByPtAll(memberQueryVo2.getMealType(),
                    memberQueryVo2.getMemberPhone(), memberQueryVo2.getMealId(), memberQueryVo2.getProjectId(),
                    memberQueryVo2.getEmpId());
            //判断套餐是否办理
            if(memberQueryVo1==null){
                //无套餐
                MemberMeal memberMeal=new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo2.getMealId());
                memberMeal.setMealType(memberQueryVo2.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                try {
                    DateUtil dateUtil=new DateUtil();
                    Date date=dateUtil.time(ptMeal.getPtTime(),new Date());
                    memberMeal.setMmDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                memberMealMapper.insert(memberMeal);
                //添加所选项目表  项目编号，教练编号，套餐编号
                ChooseProjectName chooseProjectName =new ChooseProjectName();
                chooseProjectName.setMmId(memberMeal.getMmId());
                chooseProjectName.setPtpId(memberQueryVo2.getProjectId());
                chooseProjectName.setEmpId(memberQueryVo2.getEmpId());
                chooseProjectName.setChooseId(memberQueryVo2.getMealId());
                chooseprojectnameMapper.insert(chooseProjectName);
                //添加消费记录
                addComsune(member1.getMemberId(),ptMeal,ptProjectname);
                //添加收入记录
                addProceeds(ptMeal,ptProjectname);
                return 0;
            }else{
                //有套餐
                Date date=new Date();
                //after 前面时间在后面时间为true
                if(memberQueryVo1.getMmDate().after(date)){
                    //到期时间大于现在(未过期)
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(ptMeal.getPtTime(),memberQueryVo1.getMmDate());
                        //修改会员套餐表中到期时间
                        UpdateWrapper<MemberMeal> wrapper4=new UpdateWrapper<>();
                        wrapper4.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper4.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper4);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(),ptMeal,ptProjectname);
                    //添加收入记录
                    addProceeds(ptMeal,ptProjectname);
                    return 5;
                }else {
                    //到期时间小于现在(已过期)
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(ptMeal.getPtTime(),new Date());
                        //修改会员套餐表中到期时间
                        UpdateWrapper<MemberMeal> wrapper5=new UpdateWrapper<>();
                        wrapper5.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper5.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper5);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(),ptMeal,ptProjectname);
                    //添加收入记录
                    addProceeds(ptMeal,ptProjectname);
                    return 5;
                }
            }
        }
        if (member2 == null && member3.size() == 0) {
            //会员不存在
            return 1;
        }else if(member2 != null && member3.size() !=0){
            //会员不存在
            return 1;
        }else if(member2 == null) {
            //电话不存在
            return 2;
        }else if (member3.size() == 0) {
            //姓名不存在
            return 3;
        }
        return 5;
    }

    /**
     * @title:  添加充值记录方法
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:22
    */
    public void addComsune(Long ptMemberId, PtMeall ptMeal, PtProjectname ptProjectname){
        Comsune comsune=new Comsune();
        comsune.setMemberId(ptMemberId);
        comsune.setMealId((long) ptMeal.getPtId());
        comsune.setMealName(ptMeal.getPtName());
        comsune.setPtpId(ptProjectname.getPtpId());
        comsune.setPtpName(ptProjectname.getPtpName());
        comsune.setMealType("私教");
        comsune.setComsunePrice(ptMeal.getPtPrice());
        comsune.setComsuneDate(new Date());
        comsuneMapper.insert(comsune);
    }

    public void addProceeds(PtMeall ptMeal, PtProjectname ptProjectname){
        Proceeds proceeds=new Proceeds();
        proceeds.setProceedsTime(new Date());
        proceeds.setMealType("私教");
        proceeds.setMealName(ptMeal.getPtName());
        proceeds.setProceedsPrice(ptMeal.getPtPrice());
        proceeds.setPName(ptProjectname.getPtpName());
        proceedsMapper.insert(proceeds);
    }

    /**
     * @title:  续费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:22
    */
    @Override
    @Transactional
    public int renewPtMember(MemberQueryVo memberQueryVo) {
        //通过套餐办理编号查询办理的套餐信息
        MemberMeal memberMeal=memberMealMapper.selectById(memberQueryVo.getMmId());
        //通过id查询普通套餐
        PtMeall ptMeall = ptMealService.selectPtMealByMealId(memberQueryVo.getMealId());
        //通过id查询私教项目
        PtProjectname ptProjectname=ptProjectnameMapper.selectById(memberQueryVo.getProjectId());

        //通过id查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_id", memberQueryVo.getMemberId());
        Member member1 = memberMapper.selectOne(wrapper1);
        //判断是否黑名单
        if(member1 != null){
            if(member1.getMemberState()==1){
                return 1;
            }
        }else if(member1==null){
            return 2;
        }
        //体验会员续费修改会员状态为正式会员
        if(member1.getMemberType()==0){
            UpdateWrapper<Member> wrapper=new UpdateWrapper<>();
            wrapper.set("member_type",1).eq("member_id",member1.getMemberId());
            memberMapper.update(null,wrapper);
        }
        //获取当前到期时间
        Date date = new Date();
        //after 前面时间在后面时间为true
        if (memberMeal.getMmDate().after(date)) {
            //到期时间大于现在(未过期)
            try {
                DateUtil dateUtil = new DateUtil();
                Date date1 = dateUtil.time(ptMeall.getPtTime(), memberMeal.getMmDate());
                //修改会员套餐表中到期时间
                UpdateWrapper<MemberMeal> wrapper4 = new UpdateWrapper<>();
                wrapper4.eq("mm_id", memberMeal.getMmId());
                wrapper4.set("mm_date", date1);
                memberMealMapper.update(null, wrapper4);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(member1.getMemberId(),ptMeall,ptProjectname);
            return 0;
        } else {
            //到期时间小于现在(已过期)
            try {
                DateUtil dateUtil = new DateUtil();
                Date date1 = dateUtil.time(ptMeall.getPtTime(), new Date());
                //修改会员套餐表中到期时间
                UpdateWrapper<MemberMeal> wrapper5 = new UpdateWrapper<>();
                wrapper5.eq("mm_id", memberMeal.getMmId());
                wrapper5.set("mm_date", date1);
                memberMealMapper.update(null, wrapper5);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(member1.getMemberId(),ptMeall,ptProjectname);
            return 0;
        }
    }

    /**
     * @title:  通过会员id查询办理的私教套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:23
    */
    @Override
    public List<MemberQueryVo> findPtByMemberId(Long memberId) {
        return ptMemberMapper.findPtByMemberId(memberId);
    }

    /**
     * @title:  通过套餐办理编号删除私教会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:23
    */
    @Override
    @Transactional
    public boolean delPtMemberById(long mmId){
        int a=memberMealMapper.deleteById(mmId);
        QueryWrapper<ChooseProjectName> wrapper=new QueryWrapper<>();
        wrapper.eq("mm_id",mmId);
        int b = chooseprojectnameMapper.delete(wrapper);
        //同时还要删除所项目表中的数据
        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  根据所选项目表套餐办理编号查询教练，套餐信息
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:23
    */
    @Override
    public PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId){
        return ptMemberMapper.selectPtMealAndEmpByMmId(mmId);
    }



}
