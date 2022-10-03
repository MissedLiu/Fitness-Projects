package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

import java.util.List;

/*
*
*会员类
*
*/
public interface MemberService extends IService<Member> {
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
     *通过电话删除会员ok
     *
     */
    boolean delMemberByMemberId(long memberId);

    /*
     *
     *根据电话修改会员
     *
     */
    boolean updataMemberByMemberPhone(Member member);

}
