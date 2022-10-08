package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.tqw.*;
import com.trkj.entity.tqw.*;
import com.trkj.service.ipmlTqw.PtMealService;
import com.trkj.service.ipmlTqw.PtMemberService;
import com.trkj.utils.DateUtil;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PtMemberServiceIpmll implements PtMemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PtMealService ptMealService;
    @Autowired
    private MemberMealMapper memberMealMapper;
    @Autowired
    private ChooseprojectnameMapper chooseprojectnameMapper;
    @Autowired
    private PtMemberMapper ptMemberMapper;
    @Autowired
    private ComsuneMapper comsuneMapper;
    @Autowired
    private PtProjectnameMapper ptProjectnameMapper;
    /*
     *
     *查询私教会员列表
     *
     */
    @Override
    public IPage<MemberQueryVo> findPtMember(MemberQueryVo memberQueryVo) {
        Page<MemberQueryVo> pageStr=new Page<>(memberQueryVo.getPageNo(),memberQueryVo.getPageSize());
        IPage<MemberQueryVo> Page = ptMemberMapper.findPtMember( pageStr,memberQueryVo);
        return Page;
    }


    /*
     *
     *新增私教会员
     *
     */
    @Override
    public int addPtMember(MemberQueryVo memberQueryVo) {

        //套餐类型
        memberQueryVo.setMealType("私教");
        //通过id查询私教套餐
        PtMeall ptMeal = ptMealService.selectPtMealByMealId(memberQueryVo.getMealId());
        //通过id查询私教项目
        PtProjectname ptProjectname=ptProjectnameMapper.selectById(memberQueryVo.getProjectId());
        //通过电话和姓名查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_phone", memberQueryVo.getMemberPhone());
        wrapper1.eq("member_name", memberQueryVo.getMemberName());
        Member member1 = memberMapper.selectOne(wrapper1);
        if(member1==null){
            return 1;
        }
        //修改会员类型为正式会员
        UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
        wrapper.eq("member_id", member1.getMemberId());
        wrapper.set("member_type", 1);
        memberMapper.update(null, wrapper);
        //判断是否黑名单
        if(member1 != null){
            if(member1.getMemberState()==1){
                return 4;
            }
        }
        //通过电话查会员
        QueryWrapper<Member> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("member_phone", memberQueryVo.getMemberPhone());
        Member member2 = memberMapper.selectOne(wrapper2);
        //通过名字查电话
        QueryWrapper<Member> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("member_name", memberQueryVo.getMemberName());
        List<Member> member3 = memberMapper.selectList(wrapper3);
        if (member1 != null) {
            //会员存在
            //套餐办理
            //通过会员电话,套餐id,套餐类型,项目id,教练id查询私教套餐办理记录（唯一一条）
            MemberQueryVo memberQueryVo1 = ptMemberMapper.findMemberByPtAll(memberQueryVo.getMealType(),
                    memberQueryVo.getMemberPhone(),memberQueryVo.getMealId(),memberQueryVo.getProjectId(),
                    memberQueryVo.getEmpId());
            //判断套餐是否办理
            if(memberQueryVo1==null){
                //无套餐
                MemberMeal memberMeal=new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo.getMealId());
                memberMeal.setMealType(memberQueryVo.getMealType());
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
                ChooseProject chooseProject=new ChooseProject();
                chooseProject.setMmId(memberMeal.getMmId());
                chooseProject.setPtpId(memberQueryVo.getProjectId());
                chooseProject.setEmpId(memberQueryVo.getEmpId());
                chooseProject.setChooseId(memberQueryVo.getMealId());
                chooseprojectnameMapper.insert(chooseProject);
                //添加消费记录
                addComsune(member1,ptMeal,ptProjectname);
                return 0;
            }else{
                //有套餐
                Date date=new Date();
                //after 前面时间在后面时间为true
                System.out.println(memberQueryVo1.getMmDate());
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
                    addComsune(member1,ptMeal,ptProjectname);
                    return 5;
                }else {
                    //到期时间小于现在(已过期)
                    System.out.println("ccccc");
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(ptMeal.getPtTime(),new Date());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper5=new UpdateWrapper<>();
                        wrapper5.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper5.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper5);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1,ptMeal,ptProjectname);
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

    //添加充值记录方法
    public void addComsune(Member member, PtMeall ptMeal, PtProjectname ptProjectname){
        Comsune comsune=new Comsune();
        comsune.setMemberId(member.getMemberId());
        comsune.setMealId((long) ptMeal.getPtId());
        comsune.setMealName(ptMeal.getPtName());
        comsune.setPtpId(ptProjectname.getPtpId());
        comsune.setPtpName(ptProjectname.getPtpName());
        comsune.setMealType("私教");
        comsune.setComsunePrice(ptMeal.getPtPrice());
        comsune.setComsuneDate(new Date());
        comsuneMapper.insert(comsune);
    }

    /*
     *
     *通过套餐办理编号删除私教会员
     *
     */
    @Override
    public boolean delPtMemberById(long mmId){
        int a=memberMealMapper.deleteById(mmId);
        QueryWrapper<ChooseProject> wrapper=new QueryWrapper<>();
        wrapper.eq("mm_id",mmId);
        int b = chooseprojectnameMapper.delete(wrapper);
        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息
     *
     */
    @Override
    public PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId){
        return ptMemberMapper.selectPtMealAndEmpByMmId(mmId);
    }

}
