package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.ouyang.ProceedsMapper;
import com.trkj.dao.tqw.*;
import com.trkj.entity.liucz2.Proceeds;
import com.trkj.entity.tqw.CommonMeall;
import com.trkj.entity.tqw.Comsune;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.service.implTqw.CommonMealService;
import com.trkj.service.implTqw.CommonMemberService;
import com.trkj.utils.DateUtil;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommonMemberServiceImpll implements CommonMemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberMealMapper memberMealMapper;
    @Autowired
    private CommonMealService commonMealService;
    @Autowired
    private CommonMemberMapper commonMemberMapper;
    @Autowired
    private ComsuneMapper comsuneMapper;
    @Autowired
    private ProceedsMapper proceedsMapper;

    /*
     *
     *通过套餐类型查询会员套餐列表(普通)
     *
     */
    @Override
    public IPage<MemberQueryVo> findCommentMember(MemberQueryVo memberQueryVo) {
        Page<MemberQueryVo> pageStr = new Page<>(memberQueryVo.getPageNo(), memberQueryVo.getPageSize());
        IPage<MemberQueryVo> Page = commonMemberMapper.findCommonMemberAll(pageStr, memberQueryVo);
        return Page;
    }

    /*
     *
     *新增普通会员
     *
     */
    @Override
    public int addCommonMember(MemberQueryVo memberQueryVo) {
        //套餐类型
        memberQueryVo.setMealType("普通");
        //通过id查询普通套餐
        CommonMeall commonMeal = commonMealService.selectCommonMealByMealId(memberQueryVo.getMealId());
        //通过电话和姓名查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_phone", memberQueryVo.getMemberPhone());
        wrapper1.eq("member_name", memberQueryVo.getMemberName());
        Member member1 = memberMapper.selectOne(wrapper1);
        //判断是否黑名单
        if (member1 != null) {
            if (member1.getMemberState() == 1) {
                return 4;
            }
        } else if (member1 == null) {
            return 1;
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
            //判断是否为体验会员
            if (member1.getMemberType() == 0) {
                //体验会员
                //直接办理套餐
                MemberMeal memberMeal = new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo.getMealId());
                memberMeal.setMealType(memberQueryVo.getMealType());
                memberMeal.setMmTime(new Date());
                Calendar rightNow = Calendar.getInstance();
                rightNow.setTime(new Date());
                rightNow.add(Calendar.DATE, 1);
                memberMeal.setMmDate(rightNow.getTime());
                memberMealMapper.insert(memberMeal);
                return 0;
                //无需生成消费记录
            }

            //套餐办理
            //通过电话，套餐类型,套餐id查询会员套餐(单条数据)
            MemberQueryVo memberQueryVo1 = commonMemberMapper.findMemberByPhoneAndMealTypeAndMealId(memberQueryVo.getMealType(),
                    memberQueryVo.getMemberPhone(), memberQueryVo.getMealId());
            //判断套餐是否办理
            if (memberQueryVo1 != null) {
                //有套餐
                //获取套餐到期时间
                Date date = new Date();
                //after 前面时间在后面时间为true
                if (memberQueryVo1.getMmDate().after(date)) {
                    //到期时间大于现在(未过期)
                    try {
                        DateUtil dateUtil = new DateUtil();
                        Date date1 = dateUtil.time(commonMeal.getCmTime(), memberQueryVo1.getMmDate());
                        //修改会员套餐表中到期时间
                        UpdateWrapper<MemberMeal> wrapper4 = new UpdateWrapper<>();
                        wrapper4.eq("mm_id", memberQueryVo1.getMmId());
                        wrapper4.set("mm_date", date1);
                        memberMealMapper.update(null, wrapper4);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(), commonMeal);
                    //添加收入记录
                    addproceeds(commonMeal);
                    return 5;
                } else {
                    //到期时间小于现在(已过期)
                    try {
                        DateUtil dateUtil = new DateUtil();
                        Date date1 = dateUtil.time(commonMeal.getCmTime(), new Date());
                        //修改会员套餐表中到期时间
                        System.out.println(date1);
                        UpdateWrapper<MemberMeal> wrapper5 = new UpdateWrapper<>();
                        wrapper5.eq("mm_id", memberQueryVo1.getMmId());
                        wrapper5.set("mm_date", date1);
                        memberMealMapper.update(null, wrapper5);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //添加消费记录
                    addComsune(member1.getMemberId(), commonMeal);
                    //添加收入记录
                    addproceeds(commonMeal);
                    return 5;
                }
            } else {
                //无套餐
                //添加会员套餐办理表
                MemberMeal memberMeal = new MemberMeal();
                memberMeal.setMemberId(member1.getMemberId());
                memberMeal.setMealId(memberQueryVo.getMealId());
                memberMeal.setMealType(memberQueryVo.getMealType());
                memberMeal.setMmTime(new Date());
                //获取套餐到期时间
                try {
                    DateUtil dateUtil = new DateUtil();
                    Date date = dateUtil.time(commonMeal.getCmTime(), memberMeal.getMmTime());
                    memberMeal.setMmDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                memberMealMapper.insert(memberMeal);
                //添加消费记录
                addComsune(member1.getMemberId(), commonMeal);
                //添加收入记录
                addproceeds(commonMeal);
                return 0;
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

    //添加充值记录方法
    public void addComsune(Long memberId, CommonMeall commonMeal) {
        Comsune comsune = new Comsune();
        comsune.setMemberId(memberId);
        comsune.setMealId((long) commonMeal.getCmId());
        comsune.setMealName(commonMeal.getCmName());
        comsune.setMealType("普通");
        comsune.setComsunePrice(commonMeal.getCmPrice());
        comsune.setComsuneDate(new Date());
        comsuneMapper.insert(comsune);
    }

    public void addproceeds(CommonMeall commonMeal) {
        Proceeds proceeds = new Proceeds();
        proceeds.setProceedsTime(new Date());
        proceeds.setMealType("普通");
        proceeds.setMealName(commonMeal.getCmName());
        proceeds.setProceedsPrice(commonMeal.getCmPrice());
        proceedsMapper.insert(proceeds);
    }

    //删除普通会员套餐
    @Override
    public boolean delCommonMemberById(long mmId) {
        int a = memberMealMapper.deleteById(mmId);
        if (a > 0) {
            return true;
        }
        return false;
    }

    //续费
    @Override
    public int renewCommonMember(MemberQueryVo memberQueryVo) {
        //通过套餐办理编号查询办理的套餐信息
        MemberMeal memberMeal = memberMealMapper.selectById(memberQueryVo.getMmId());
        //通过id查询普通套餐
        CommonMeall commonMeal = commonMealService.selectCommonMealByMealId(memberQueryVo.getMealId());

        //通过电话和姓名查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_phone", memberQueryVo.getMemberPhone());
        wrapper1.eq("member_name", memberQueryVo.getMemberName());
        Member member1 = memberMapper.selectOne(wrapper1);
        //判断是否黑名单
        if (member1 != null) {
            if (member1.getMemberState() == 1) {
                return 1;
            }
        } else if (member1 == null) {
            return 2;
        }
        //体验会员续费修改会员状态为正式会员
        if (member1.getMemberType() == 0) {
            UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
            wrapper.set("member_type", 1).eq("member_id", member1.getMemberId());
            memberMapper.update(null, wrapper);
        }
        //获取当前到期时间
        Date date = new Date();
        //after 前面时间在后面时间为true
        if (memberMeal.getMmDate().after(date)) {
            //到期时间大于现在(未过期)
            try {
                DateUtil dateUtil = new DateUtil();
                Date date1 = dateUtil.time(commonMeal.getCmTime(), memberMeal.getMmDate());
                //修改会员套餐表中到期时间
                UpdateWrapper<MemberMeal> wrapper4 = new UpdateWrapper<>();
                wrapper4.eq("mm_id", memberMeal.getMmId());
                wrapper4.set("mm_date", date1);
                memberMealMapper.update(null, wrapper4);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(memberQueryVo.getMemberId(), commonMeal);
            return 0;
        } else {
            //到期时间小于现在(已过期)
            try {
                DateUtil dateUtil = new DateUtil();
                Date date1 = dateUtil.time(commonMeal.getCmTime(), new Date());
                //修改会员套餐表中到期时间
                System.out.println(date1);
                UpdateWrapper<MemberMeal> wrapper5 = new UpdateWrapper<>();
                wrapper5.eq("mm_id", memberMeal.getMmId());
                wrapper5.set("mm_date", date1);
                memberMealMapper.update(null, wrapper5);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //添加消费记录
            addComsune(memberQueryVo.getMemberId(), commonMeal);
            return 0;
        }

    }

}




