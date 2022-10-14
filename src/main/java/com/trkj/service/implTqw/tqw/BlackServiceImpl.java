package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.ouyang.DisburseMapper;
import com.trkj.dao.tqw.BlackMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.ouyang.Disburse;
import com.trkj.entity.tqw.Black;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.service.implTqw.BlackService;
import com.trkj.vo.queryTqw.BlackMemberMealQueryVo;
import com.trkj.vo.queryTqw.DisburseAndMemberQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/*
*
*黑名单serviceimpl
*
*/
@Service
@Transactional
public class BlackServiceImpl extends ServiceImpl<BlackMapper,Black> implements BlackService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberMealMapper memberMealMapper;
    @Autowired
    private DisburseMapper disburseMapper;
    /*
     *
     *加入黑名单(新增)
     *
     */
    public boolean goUpdMemberState(long memberId,String why){
        System.out.println(memberId);
        System.out.println(why);
        //修改会员状态
        UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.set("member_state", 1);
        int a = memberMapper.update(null, wrapper);
        //添加黑名单表记录
        Black black=new Black();
        black.setMemberId(memberId);
        black.setCreateTime(new Date());
        black.setWhy(why);
        System.out.println(black);
        int b = baseMapper.insert(black);
        //判断
        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    /*
    *
    *查询会员表（黑名单）
    *
    */
    public IPage<MemberAndBlackQueryVo> findBlackMember(MemberAndBlackQueryVo memberAndBlackQueryVo){
        Page<MemberAndBlackQueryVo> page=new Page<>(memberAndBlackQueryVo.getPageNo(),memberAndBlackQueryVo.getPageSize());
        IPage<MemberAndBlackQueryVo> memberAll = baseMapper.findBlackMemberAll(page,memberAndBlackQueryVo);
        return memberAll;
    }
    /*
     *
     *移出黑名单
     *
     */
    public boolean outUpdMemberState(long memberId,String why){
        //修改会员状态
        UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.set("member_state", 0);
        int a = memberMapper.update(null, wrapper);
        //删除黑名单表记录
        QueryWrapper<Black> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId);
        int b = baseMapper.delete(wrapper1);
        //判断
        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    /*
    *
    *查询黑名单会员下的套餐
    *
    */
    @Override
    public List<BlackMemberMealQueryVo> findBlackMemberMeal(Long memberId) {
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id",memberId);
        List<MemberMeal> list=memberMealMapper.selectList(wrapper);
        List<Long> list1 = new LinkedList<>();
        List<Long> list2 = new LinkedList<>();
        List<Long> list3 = new LinkedList<>();
        //套餐类型分类
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMealType().equals("普通")){
                list1.add(list.get(i).getMealId());
            }else if(list.get(i).getMealType().equals("私教")){
                list2.add(list.get(i).getMealId());
            }else if(list.get(i).getMealType().equals("团操")){
                list3.add(list.get(i).getMealId());
            }
        }
        //查询三种套餐信息
        List<BlackMemberMealQueryVo> list4 = new ArrayList<>();
        list4.addAll(baseMapper.selectCommon(list1,memberId));
        list4.addAll(baseMapper.selectPt(list2,memberId));
        list4.addAll(baseMapper.selectTeam(list3,memberId));
        return list4;
    }

    //退费
    @Override
    public boolean delMemberAllMeal(DisburseAndMemberQueryVo disburseAndMemberQueryVo) {
        //添加支出记录
        Disburse disburse=new Disburse();
        disburse.setDisburseType("退费");
        disburse.setDisburseTime(new Date());
        disburse.setDisbursePrice(disburseAndMemberQueryVo.getDisbursePrice());
        disburse.setBeizhu(disburseAndMemberQueryVo.getBeizhu());
        disburseMapper.insert(disburse);
        //查询会员套餐
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id",disburseAndMemberQueryVo.getMemberId());
        List<MemberMeal> list = memberMealMapper.selectList(wrapper);
        //删除会员套餐数据
        memberMealMapper.delete(wrapper);
        //删除会员项目数据
        if(baseMapper.deleteMemberMeal(list)>0){
            return true;
        }
        return false;
    }

//    /*
//     *
//     *通过电话查询黑名单
//     *
//     */
//    public MemberAndBlackQueryVo findblackMemberByPhone(String memberPhone){
//        return baseMapper.findMemberByPhone(memberPhone);
//    }

}
