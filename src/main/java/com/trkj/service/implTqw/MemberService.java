package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;

import java.util.List;

/*
*
*会员类
*
*/
public interface MemberService extends IService<Member> {
    //查询会员列表无分页
    List<Member> listAllNoPage(MemberSelectQueryVo memberSelectQueryVo);

    //查询会员信息列表(分页)
    IPage<Member> findAllMember(MemberSelectQueryVo memberSelectQueryVo);

    //新增会员
    boolean addMember(Member member);

    //删除会员
    boolean removeMember(long memberId);

    //修改会员
    int updataMemberByMemberPhone(Member member);

    //通过会员id查询所有套餐
    List<MemberQueryVo> findMemberMealByMemberId(Long memberId);

    /*
     *
     *查询会员状态为0的信息
     *
     */
    List<Member> findMemberByState(long memberstate);



}
