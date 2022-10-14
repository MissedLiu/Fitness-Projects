package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;

import java.util.List;

public interface CommonMemberService {
    /*
     *
     *通过套餐类型查询普通会员套餐
     *
     */
    IPage<Member> findCommentMember(MemberQueryVo memberQueryVo);

    /*
     *
     *新增普通会员
     *
     */
    int addCommonMember(MemberQueryVo memberQueryVo);


    /*
     *
     *删除普通会员套餐
     *
     */
    boolean delCommonMemberById(long mmId);

    /*
    *
    *续费
    *
    */
    int renewCommonMember(MemberQueryVo memberQueryVo);

    //通过会员id查询办理的普通套餐
    List<MemberQueryVo> findCommonByMemberId(Long memberId);
}
