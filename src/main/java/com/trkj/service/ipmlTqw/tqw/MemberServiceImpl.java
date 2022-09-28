package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ChooseprojectnameMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.*;
import com.trkj.service.ipmlTqw.CommonMealService;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.PtMealService;
import com.trkj.service.ipmlTqw.TeamMealService;
import com.trkj.utils.DateUtil;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Resource
    private MemberMealMapper memberMealMapper;
    @Resource
    private CommonMealService commonMealService;
    @Resource
    private PtMealService ptMealService;
    @Resource
    private ChooseprojectnameMapper chooseprojectnameMapper;
    @Resource
    private TeamMealService teamMealService;
    /*
     *
     *通过电话查询会员信息OK
     *
     */
    public Member findMemberByMemberPhone(String memberPhone){
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",memberPhone);
        return baseMapper.selectOne(wrapper);
    }

    /*
    *
    *新增会员ok
    *
    */
    @Override
    public boolean addMember(Member member) {
        //通过电话查询会员是否存在
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",member.getMemberPhone());
        if(baseMapper.selectOne(wrapper) == null){
            member.setMemberState(0);
            member.setMemberType(0);
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());
            baseMapper.insert(member);
            return true;
        }
        return false;
    }

    //通过会员id删除会员ok
    @Override
    public boolean delMemberByMemberId(long memberId){
        QueryWrapper<Member> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId);
        //根据会员编号查询会员办理套餐表信息《list》
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id",memberId);
        List<MemberMeal> list=memberMealMapper.selectList(wrapper);
        if(list.size()==0){
            //会员办理套餐无信息
            int a=baseMapper.delete(wrapper1);
            if(a>0){
                return true;
            }
        }else {
            //套餐是否为普通套餐
            for(int i=0;i<list.size();i++){
                if(list.get(i).getMealType().equals("普通")){
                    //删套餐
                    QueryWrapper<MemberMeal> wrapper2=new QueryWrapper<>();
                    wrapper2.eq("mm_id",list.get(i).getMmId());
                    memberMealMapper.delete(wrapper2);
                }else {
                    //删项目
                    QueryWrapper<ChooseProject> wrapper3=new QueryWrapper<>();
                    wrapper3.eq("mm_id",list.get(i).getMmId());
                    chooseprojectnameMapper.delete(wrapper3);
                    //删套餐
                    QueryWrapper<MemberMeal> wrapper2=new QueryWrapper<>();
                    wrapper2.eq("mm_id",list.get(i).getMmId());
                    memberMealMapper.delete(wrapper2);
                }
            }
            int a=baseMapper.delete(wrapper1);
            if(a>0){
                return true;
            }
        }
        System.out.println(list);
        return false;
    }




    /*
     *
     *根据电话修改会员
     *
     */
    @Override
    public boolean updataMemberByMemberPhone(Member member) {
        UpdateWrapper<Member> wrapper=new UpdateWrapper<>();
        wrapper.eq("member_phone",member.getMemberPhone());
        if(baseMapper.update(member,wrapper)>0){
            return true;
        }
        return false;
    }
    /*******************普通会员**********************/
    /*
     *
     *通过套餐类型查询普通会员套餐
     *
     */
    @Override
    public List<MemberQueryVo> findCommentMember(String memberType) {
        return baseMapper.findMemberByPhoneOrMealTypeOrMealId(memberType,null,null);
    }


    /*
    *
    *通过套餐类型，电话查询会员套餐
    *
    */
    @Override
    public List<MemberQueryVo> findCommentMemberByPhone(String mealType,String memberPhone) {
        return baseMapper.findMemberByPhoneOrMealTypeOrMealId(mealType,memberPhone,null);
    }

    /*
    *
    *新增普通会员
    *
    */
    @Override
    public int addCommonMember(MemberQueryVo memberQueryVo) {
        //通过电话查询会员
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",memberQueryVo.getMemberPhone());
        Member member = baseMapper.selectOne(wrapper);
        //修改会员类型为正式会员
        memberQueryVo.setMemberType(0);
        //查询普通套餐，获取id为memberQueryVo.getMealId()的普通套餐数据
        CommonMeal commonMeal = commonMealService.selectCommonMealByMealId(memberQueryVo.getMealId());
        MemberMeal memberMeal=new MemberMeal();
        if(member == null){
            //无会员
            //先添加会员
            Member member1=new Member();
            member1.setMemberName(memberQueryVo.getMemberName());
            member1.setMemberSex(memberQueryVo.getMemberSex());
            member1.setMemberDate(memberQueryVo.getMemberDate());
            member1.setMemberPhone(memberQueryVo.getMemberPhone());
            member1.setMemberAge(memberQueryVo.getMemberAge());
            member1.setMemberAddress(memberQueryVo.getMemberAddress());
            member1.setMemberType(memberQueryVo.getMemberType());
            member1.setCreateTime(new Date());
            member1.setUpdateTime(new Date());
            int a=baseMapper.insert(member1);
            //添加会员套餐
            memberMeal.setMemberId(member1.getMemberId());
            memberMeal.setMealId(memberQueryVo.getMealId());
            memberMeal.setMealType(memberQueryVo.getMealType());
            memberMeal.setMmTime(new Date());
            //获取套餐到期时间
            try {
                DateUtil dateUtil=new DateUtil();
                Date date=dateUtil.time(commonMeal.getCmTime(),memberMeal.getMmTime());
                memberMeal.setMmDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int b=memberMealMapper.insert(memberMeal);
            if(a>0 && b>0){
                return 1;
            }
        }else{
            //有会员
            //通过电话，套餐类型,套餐id查询会员套餐(单条数据)
            MemberQueryVo memberQueryVo1 = baseMapper.findMemberByPhoneAndMealTypeAndMealId(memberQueryVo.getMealType(),
                    memberQueryVo.getMemberPhone(),memberQueryVo.getMealId());
            //判断套餐是否办理
            System.out.println(memberQueryVo1);
            if(memberQueryVo1 != null){
                //有套餐
                //获取套餐到期时间
                Date date=new Date();
                //after 前面时间在后面时间为true
                if(memberQueryVo1.getMmDate().after(date)){
                    //到期时间大于现在(未过期)
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(commonMeal.getCmTime(),memberQueryVo1.getMmDate());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 2;
                }else {
                    //到期时间小于现在(已过期)
                    System.out.println("ccccc");
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(commonMeal.getCmTime(),new Date());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 3;
                }
            }else {
                //无套餐
                //添加会员套餐办理表
                memberMeal.setMemberId(member.getMemberId());
                memberMeal.setMealId(memberQueryVo.getMealId());
                memberMeal.setMealType(memberQueryVo.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                try {
                    DateUtil dateUtil=new DateUtil();
                    Date date=dateUtil.time(commonMeal.getCmTime(),memberMeal.getMmTime());
                    memberMeal.setMmDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int b=memberMealMapper.insert(memberMeal);
                if(b>0){
                    return 2;
                }
            }
        }
        return 0;
    }



    //删除普通会员
    @Override
    public boolean delCommonMemberById(long mmId){
        int a=memberMealMapper.deleteById(mmId);
        if(a>0){
            return true;
        }
        return false;
    }


/***************************私教************************************/
    /*
     *
     *通过套餐类型查询私教会员
     *
     */
    @Override
    public List<MemberQueryVo> findPtMember(String memberType) {
        return baseMapper.findPtMemberByPhoneOrMealTypeOrMealId(memberType,null,null);
    }

    /**
     * 通过电话,套餐类型查询私教，团操会员套餐
     *
     */
    @Override
    public List<MemberQueryVo> findPtMemberByPhone(String mealType, String memberPhone) {
        return baseMapper.findPtMemberByPhoneOrMealTypeOrMealId(mealType,memberPhone,null);
    }


    /*
     *
     *新增私教会员
     *
     */
    @Override
    public int addPtMember(MemberQueryVo memberQueryVo) {
        //通过电话查询会员
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",memberQueryVo.getMemberPhone());
        Member member = baseMapper.selectOne(wrapper);
        //修改会员类型为正式会员
        memberQueryVo.setMemberType(1);
        //查询私教套餐，获取id为memberQueryVo.getMealId()的私教套餐数据
        PtMeal ptMeal = ptMealService.selectPtMealByMealId(memberQueryVo.getMealId());

        MemberMeal memberMeal=new MemberMeal();
        if(member == null){
            //无会员
            //先添加会员
            Member member1=new Member();
            member1.setMemberName(memberQueryVo.getMemberName());
            member1.setMemberSex(memberQueryVo.getMemberSex());
            member1.setMemberDate(memberQueryVo.getMemberDate());
            member1.setMemberPhone(memberQueryVo.getMemberPhone());
            member1.setMemberAge(memberQueryVo.getMemberAge());
            member1.setMemberAddress(memberQueryVo.getMemberAddress());
            member1.setMemberType(memberQueryVo.getMemberType());
            member1.setCreateTime(new Date());
            member1.setUpdateTime(new Date());
            int a=baseMapper.insert(member1);
            //添加会员套餐
            memberMeal.setMemberId(member1.getMemberId());
            memberMeal.setMealId(memberQueryVo.getMealId());
            memberMeal.setMealType(memberQueryVo.getMealType());
            memberMeal.setMmTime(new Date());
            //获取套餐到期时间
            try {
                DateUtil dateUtil=new DateUtil();
                Date date=dateUtil.time(ptMeal.getPtTime(),memberMeal.getMmTime());
                memberMeal.setMmDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int b=memberMealMapper.insert(memberMeal);
            //添加所选项目表  项目编号，教练编号，套餐编号
            ChooseProject chooseProject=new ChooseProject();
            chooseProject.setMmId(memberMeal.getMmId());
            chooseProject.setPtpId(memberQueryVo.getProjectId());
            chooseProject.setEmpId(memberQueryVo.getEmpId());
            chooseProject.setChooseId(memberQueryVo.getMealId());
            int c = chooseprojectnameMapper.insert(chooseProject);

            if(a>0 && b>0 && c>0){
                return 1;
            }
        }else{
            //有会员
            //判断套餐是否办理
            //新增套餐记录
            //通过会员电话,套餐id,套餐类型,项目id,教练id查询（唯一一条）

            MemberQueryVo memberQueryVo1 = baseMapper.findMemberByPtAll(memberQueryVo.getMealType(),
                    memberQueryVo.getMemberPhone(),memberQueryVo.getMealId(),memberQueryVo.getProjectId(),
                    memberQueryVo.getEmpId());

            if(memberQueryVo1==null){
                //无套餐
                System.out.println("++++++++++++++++++++++++++++++++++++++++++=");
                memberMeal.setMemberId(member.getMemberId());
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
                int b=memberMealMapper.insert(memberMeal);
                //添加所选项目表  项目编号，教练编号，套餐编号
                ChooseProject chooseProject=new ChooseProject();
                chooseProject.setMmId(memberMeal.getMmId());
                chooseProject.setPtpId(memberQueryVo.getProjectId());
                chooseProject.setEmpId(memberQueryVo.getEmpId());
                chooseProject.setChooseId(memberQueryVo.getMealId());
                int c = chooseprojectnameMapper.insert(chooseProject);
                if(b>0 && c>0){
                    return 2;
                }
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
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 2;
                }else {
                    //到期时间小于现在(已过期)
                    System.out.println("ccccc");
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(ptMeal.getPtTime(),new Date());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 3;
                }
            }
        }
        return 0;
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
        return baseMapper.selectPtMealAndEmpByMmId(mmId);
    }


/************************团操*************************/
    /*
     *
     *通过套餐类型查询团操会员
     *
     */
    @Override
    public List<MemberQueryVo> findTeamMember(String memberType){
        return baseMapper.findTeamMemberByPhoneOrMealTypeOrMealId(memberType,null,null);
    }
    /**
     * 通过电话,套餐类型查询团操
     *
     */
    @Override
    public List<MemberQueryVo> findTeamMemberByPhone(String mealType,String memberPhone){
        return baseMapper.findTeamMemberByPhoneOrMealTypeOrMealId(mealType,memberPhone,null);
    }
    /*
     *
     *新增团操会员
     *
     */
    public int addTeamMember(MemberQueryVo memberQueryVo){
        System.out.println("xxxxxxxxxxxxxxxxxx"+memberQueryVo);
        //通过电话查询会员
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",memberQueryVo.getMemberPhone());
        Member member = baseMapper.selectOne(wrapper);
        //修改会员类型为正式会员
        memberQueryVo.setMemberType(1);
        //查询团操套餐，获取id为memberQueryVo.getMealId()的团操套餐数据
        TeamMeal teamMeal = teamMealService.selectTeamMealByMealId(memberQueryVo.getMealId());
        System.out.println("aaaaa"+teamMeal);
        MemberMeal memberMeal=new MemberMeal();
        if(member == null){
            //无会员
            //先添加会员
            Member member1=new Member();
            member1.setMemberName(memberQueryVo.getMemberName());
            member1.setMemberSex(memberQueryVo.getMemberSex());
            member1.setMemberDate(memberQueryVo.getMemberDate());
            member1.setMemberPhone(memberQueryVo.getMemberPhone());
            member1.setMemberAge(memberQueryVo.getMemberAge());
            member1.setMemberAddress(memberQueryVo.getMemberAddress());
            member1.setMemberType(memberQueryVo.getMemberType());
            member1.setCreateTime(new Date());
            member1.setUpdateTime(new Date());
            int a=baseMapper.insert(member1);
            //添加会员套餐
            System.out.println("a:"+a);
            System.out.println("memberId:"+memberQueryVo.getMealId());
            System.out.println("memberId:"+memberQueryVo.getMealType());
            memberMeal.setMemberId(member1.getMemberId());
            memberMeal.setMealId(memberQueryVo.getMealId());
            memberMeal.setMealType(memberQueryVo.getMealType());

            memberMeal.setMmTime(new Date());
            //获取套餐到期时间
            try {
                DateUtil dateUtil=new DateUtil();

                Date date=dateUtil.time(teamMeal.getTeamTime(),memberMeal.getMmTime());
                System.out.println(date);
                memberMeal.setMmDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int b=memberMealMapper.insert(memberMeal);
            //添加所选项目表  项目编号，教练编号，套餐编号
            ChooseProject chooseProject=new ChooseProject();
            chooseProject.setMmId(memberMeal.getMmId());
            chooseProject.setPtpId(memberQueryVo.getProjectId());
            chooseProject.setEmpId(memberQueryVo.getEmpId());
            chooseProject.setChooseId(memberQueryVo.getMealId());
            int c = chooseprojectnameMapper.insert(chooseProject);

            if(a>0 && b>0 && c>0){
                return 1;
            }
        }else{
            //有会员
            //判断套餐是否办理
            //新增套餐记录
            //通过会员电话,套餐id,套餐类型,项目id,教练id查询（唯一一条）

            MemberQueryVo memberQueryVo1 = baseMapper.findMemberByTeamAll(memberQueryVo.getMealType(),
                    memberQueryVo.getMemberPhone(),memberQueryVo.getMealId(),memberQueryVo.getProjectId(),
                    memberQueryVo.getEmpId());

            if(memberQueryVo1==null){
                //无套餐
                System.out.println("++++++++++++++++++++++++++++++++++++++++++=");
                memberMeal.setMemberId(member.getMemberId());
                memberMeal.setMealId(memberQueryVo.getMealId());
                memberMeal.setMealType(memberQueryVo.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                try {
                    DateUtil dateUtil=new DateUtil();
                    Date date=dateUtil.time(teamMeal.getTeamTime(),new Date());
                    memberMeal.setMmDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int b=memberMealMapper.insert(memberMeal);
                //添加所选项目表  项目编号，教练编号，套餐编号
                ChooseProject chooseProject=new ChooseProject();
                chooseProject.setMmId(memberMeal.getMmId());
                chooseProject.setPtpId(memberQueryVo.getProjectId());
                chooseProject.setEmpId(memberQueryVo.getEmpId());
                chooseProject.setChooseId(memberQueryVo.getMealId());
                int c = chooseprojectnameMapper.insert(chooseProject);
                if(b>0 && c>0){
                    return 2;
                }
            }else{
                //有套餐
                Date date=new Date();
                //after 前面时间在后面时间为true
                System.out.println(memberQueryVo1.getMmDate());
                if(memberQueryVo1.getMmDate().after(date)){
                    //到期时间大于现在(未过期)
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(teamMeal.getTeamTime(),memberQueryVo1.getMmDate());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 2;
                }else {
                    //到期时间小于现在(已过期)
                    System.out.println("ccccc");
                    try {
                        DateUtil dateUtil=new DateUtil();
                        Date date1=dateUtil.time(teamMeal.getTeamTime(),new Date());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper1=new UpdateWrapper<>();
                        wrapper1.eq("mm_id",memberQueryVo1.getMmId());
                        wrapper1.set("mm_date",date1);
                        memberMealMapper.update(null,wrapper1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 3;
                }
            }
        }
        return 0;
    }
    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息（团操）
     *
     */
    @Override
    public PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId){
        return baseMapper.selectTeamMealAndEmpByMmId(mmId);
    }
}
