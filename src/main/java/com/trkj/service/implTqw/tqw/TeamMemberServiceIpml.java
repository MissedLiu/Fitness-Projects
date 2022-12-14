package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.ouyang.ProceedsMapper;
import com.trkj.dao.tqw.*;
import com.trkj.entity.liucz2.Proceeds;
import com.trkj.entity.tqw.*;
import com.trkj.service.implTqw.TeamMealService;
import com.trkj.service.implTqw.TeamMemberService;
import com.trkj.utils.DateUtil;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo2;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TeamMemberServiceIpml implements TeamMemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private TeamMealService teamMealService;
    @Resource
    private MemberMealMapper memberMealMapper;
    @Resource
    private ChooseProjectNameMapper chooseprojectnameMapper;
    @Resource
    private TeamMemberMapper teamMemberMapper;
    @Resource
    private ComsuneMapper comsuneMapper;
    @Resource
    private TeamProjectnameMapper teamProjectnameMapper;
    @Resource
    private ProceedsMapper proceedsMapper;

    /**
     * @title:  查询团操会员(分页)
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 9:02
    */
    @Override
    public IPage<MemberQueryVo> findTeamMember(MemberQueryVo memberQueryVo) {
        Page<MemberQueryVo> page=new Page<>(memberQueryVo.getPageNo(),memberQueryVo.getPageSize());
        IPage<MemberQueryVo> iPage=teamMemberMapper.findTeamMember(page,memberQueryVo);
        return iPage;
    }

    /**
     * @title:  新增团操会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:29
    */
    @Override
    @Transactional
    public int addTeamMember(MemberQueryVo2 memberQueryVo2) {
        //套餐类型
        memberQueryVo2.setMealType("团操");
        //通过id查询团操套餐
        TeamMeall teamMeal = teamMealService.selectTeamMealByMealId(memberQueryVo2.getMealId());
        //通过id查询团操项目
        TeamProjectname teamProjectname=teamProjectnameMapper.selectById(memberQueryVo2.getProjectId());
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
                MemberMeal memberMeal = new MemberMeal();
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
                ChooseProjectName chooseProjectName = new ChooseProjectName();
                chooseProjectName.setMmId(memberMeal.getMmId());
                chooseProjectName.setPtpId(memberQueryVo2.getProjectId());
                chooseProjectName.setEmpId(memberQueryVo2.getEmpId());
                chooseProjectName.setChooseId(memberQueryVo2.getMealId());
                chooseprojectnameMapper.insert(chooseProjectName);
                return 0;
                //无需生成消费记录
            }

            //查询有无套餐
            MemberQueryVo memberQueryVo1 = teamMemberMapper.findMemberByTeamAll(memberQueryVo2.getMealType(),
                    memberQueryVo2.getMemberPhone(), memberQueryVo2.getMealId(), memberQueryVo2.getProjectId(),
                    memberQueryVo2.getEmpId());

            if (memberQueryVo1 == null) {
                //无套餐
                MemberMeal memberMeal = new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo2.getMealId());
                memberMeal.setMealType(memberQueryVo2.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                try {
                    DateUtil dateUtil = new DateUtil();
                    Date date = dateUtil.time(teamMeal.getTeamTime(), new Date());
                    memberMeal.setMmDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                memberMealMapper.insert(memberMeal);
                //添加所选项目表  项目编号，教练编号，套餐编号
                ChooseProjectName chooseProjectName = new ChooseProjectName();
                chooseProjectName.setMmId(memberMeal.getMmId());
                chooseProjectName.setPtpId(memberQueryVo2.getProjectId());
                chooseProjectName.setEmpId(memberQueryVo2.getEmpId());
                chooseProjectName.setChooseId(memberQueryVo2.getMealId());
                chooseprojectnameMapper.insert(chooseProjectName);
                //添加消费记录
                addComsune(member1.getMemberId(),teamMeal,teamProjectname);
                //添加收入报表
                addProceeds(teamMeal,teamProjectname);
                return 0;
            } else {
                //有套餐
                Date date = new Date();
                //after 前面时间在后面时间为true
                if (memberQueryVo1.getMmDate().after(date)) {
                    //到期时间大于现在(未过期)
                    try {
                        DateUtil dateUtil = new DateUtil();
                        Date date1 = dateUtil.time(teamMeal.getTeamTime(), memberQueryVo1.getMmDate());
                        //修改会员套餐表中到期时间
                        UpdateWrapper<MemberMeal> wrapper4 = new UpdateWrapper<>();
                        wrapper4.eq("mm_id", memberQueryVo1.getMmId());
                        wrapper4.set("mm_date", date1);
                        memberMealMapper.update(null, wrapper4);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(),teamMeal,teamProjectname);
                    //添加收入报表
                    addProceeds(teamMeal,teamProjectname);
                    return 5;
                } else {
                    //到期时间小于现在(已过期)
                    try {
                        DateUtil dateUtil = new DateUtil();
                        Date date1 = dateUtil.time(teamMeal.getTeamTime(), new Date());
                        //修改会员套餐表中到期时间
                        UpdateWrapper<MemberMeal> wrapper5 = new UpdateWrapper<>();
                        wrapper5.eq("mm_id", memberQueryVo1.getMmId());
                        wrapper5.set("mm_date", date1);
                        memberMealMapper.update(null, wrapper5);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(),teamMeal,teamProjectname);
                    //添加收入报表
                    addProceeds(teamMeal,teamProjectname);
                    return 5;
                }
            }
        }
        if (member2 == null && member3.size() == 0) {
            //会员不存在
            return 1;
        } else if (member2 != null && member3.size() != 0) {
            //会员不存在
            return 1;
        } else if (member2 == null) {
            //电话不存在
            return 2;
        } else if (member3.size() == 0) {
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
     * @date: 2022/10/17 19:29
    */
    public void addComsune(Long ptMemberId, TeamMeall teamMeal, TeamProjectname teamProjectname){
        Comsune comsune=new Comsune();
        comsune.setMemberId(ptMemberId);
        comsune.setMealId(teamMeal.getTeamId());
        comsune.setMealName(teamMeal.getTeamName());
        comsune.setPtpId(teamProjectname.getTpId());
        comsune.setPtpName(teamProjectname.getTpName());
        comsune.setMealType("团操");
        comsune.setComsunePrice(teamMeal.getTeamPrice());
        comsune.setComsuneDate(new Date());
        comsuneMapper.insert(comsune);
    }

    public void addProceeds(TeamMeall teamMeal, TeamProjectname teamProjectname){
        Proceeds proceeds=new Proceeds();
        proceeds.setProceedsTime(new Date());
        proceeds.setMealType("私教");
        proceeds.setMealName(teamMeal.getTeamName());
        proceeds.setProceedsPrice(teamMeal.getTeamPrice());
        proceeds.setPName(teamProjectname.getTpName());
        proceedsMapper.insert(proceeds);
    }

    /**
     * @title:  续费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:29
    */
    @Override
    @Transactional
    public int renewTeamMember(MemberQueryVo memberQueryVo) {
        //通过套餐办理编号查询办理的套餐信息
        MemberMeal memberMeal=memberMealMapper.selectById(memberQueryVo.getMmId());
        //通过id查询普通套餐
        TeamMeall teamMeall = teamMealService.selectTeamMealByMealId(memberQueryVo.getMealId());
        //通过id查询私教项目
        TeamProjectname teamProjectname=teamProjectnameMapper.selectById(memberQueryVo.getProjectId());

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
                Date date1 = dateUtil.time(teamMeall.getTeamTime(), memberMeal.getMmDate());
                //修改会员套餐表中到期时间
                UpdateWrapper<MemberMeal> wrapper4 = new UpdateWrapper<>();
                wrapper4.eq("mm_id", memberMeal.getMmId());
                wrapper4.set("mm_date", date1);
                memberMealMapper.update(null, wrapper4);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(member1.getMemberId(),teamMeall,teamProjectname);
            return 0;
        } else {
            //到期时间小于现在(已过期)
            try {
                DateUtil dateUtil = new DateUtil();
                Date date1 = dateUtil.time(teamMeall.getTeamTime(), new Date());
                //修改会员套餐表中到期时间
                UpdateWrapper<MemberMeal> wrapper5 = new UpdateWrapper<>();
                wrapper5.eq("mm_id", memberMeal.getMmId());
                wrapper5.set("mm_date", date1);
                memberMealMapper.update(null, wrapper5);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(member1.getMemberId(),teamMeall,teamProjectname);
            return 0;
        }
    }

    /**
     * @title:  通过会员id查询办理的团操套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:30
    */
    @Override
    public List<MemberQueryVo> findTeamByMemberId(Long memberId) {
        return teamMemberMapper.findTeamByMemberId(memberId);
    }

    /**
     * @title:  根据所选项目表套餐办理编号查询教练，套餐信息（团操）
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:30
    */
    @Override
    public PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId){
        return teamMemberMapper.selectTeamMealAndEmpByMmId(mmId);
    }

}
