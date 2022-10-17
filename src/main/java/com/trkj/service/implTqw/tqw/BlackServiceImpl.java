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
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
*
*黑名单serviceimpl
*
*/
@Service
public class BlackServiceImpl extends ServiceImpl<BlackMapper,Black> implements BlackService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberMealMapper memberMealMapper;
    @Autowired
    private DisburseMapper disburseMapper;

    /**
     * @title:  加入黑名单
     * @param: memberId why
     * @return:  boolean
     * @author 15087
     * @date: 2022/10/14 17:18
    */
    @Override
    @Transactional
    public boolean goBlack(long memberId,String why){
        //构建修改会员条件
        UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.set("member_state", 1);
        //修改会员状态
        int member = memberMapper.update(null, wrapper);
        //添加黑名单表记录
        Black black=new Black();
        black.setMemberId(memberId);
        black.setCreateTime(new Date());
        black.setWhy(why);
        int blacks = baseMapper.insert(black);
        //判断
        if(member>0 && blacks>0){
            return true;
        }
        return false;
    }


    /**
     * @title:  查询会员表（黑名单）
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/15 14:35
    */
    public IPage<MemberAndBlackQueryVo> findBlackMember(MemberSelectQueryVo memberSelectQueryVo){
        Page<MemberAndBlackQueryVo> page=new Page<>(memberSelectQueryVo.getPageNo(), memberSelectQueryVo.getPageSize());
        IPage<MemberAndBlackQueryVo> memberAll = baseMapper.findBlackMemberAll(page, memberSelectQueryVo);
        return memberAll;
    }

    /**
     * @title:  移出黑名单
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/15 15:29
    */
    public boolean outUpdMemberState(long memberId,String why){
        //修改会员状态
        UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.set("member_state", 0);
        int memberState = memberMapper.update(null, wrapper);
        //删除黑名单表记录
        QueryWrapper<Black> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId);
        int black = baseMapper.delete(wrapper1);
        //判断
        if(memberState>0 && black>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  查询黑名单会员下的套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/15 15:32
    */
    @Override
    public List<BlackMemberMealQueryVo> findBlackMemberMeal(Long memberId) {
        //查询三种套餐信息
        List<BlackMemberMealQueryVo> list = new ArrayList<>();
        list.addAll(baseMapper.selectCommon(memberId));
        list.addAll(baseMapper.selectPt(memberId));
        list.addAll(baseMapper.selectTeam(memberId));
        return list;
    }

    /**
     * @title:  退费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/15 15:33
    */
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
}
