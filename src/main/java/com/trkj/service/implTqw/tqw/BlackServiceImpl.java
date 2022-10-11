package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.BlackMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.entity.tqw.Black;
import com.trkj.entity.tqw.Member;
import com.trkj.service.implTqw.BlackService;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


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
     *通过电话查询黑名单
     *
     */
    public MemberAndBlackQueryVo findblackMemberByPhone(String memberPhone){
        return baseMapper.findMemberByPhone(memberPhone);
    }

}
