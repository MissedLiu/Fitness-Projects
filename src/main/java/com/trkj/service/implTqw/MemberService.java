package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;

import java.util.List;

/*
*
*会员类
*
*/
public interface MemberService extends IService<Member> {
    /*
    *
    *查询会员列表无分页
    *
    */
    List<Member> listAllNoPage(Member member);
    /*
     *
     *查询会员信息列表
     *
     */
    IPage<Member> findAllMemberByState(MemberQueryVo memberQueryVo);
    /*
     *
     *新增会员ok
     *
     */
    boolean addMember(Member member);


    /*
     *
     *查询会员状态为0的信息
     *
     */
    List<Member> findMemberByState(long memberstate);

    /*
     *
     *通过电话删除会员ok
     *
     */
    boolean delMemberByMemberId(long memberId);

    /*
     *
     *根据电话修改会员
     *
     */
    int updataMemberByMemberPhone(Member member);


}
