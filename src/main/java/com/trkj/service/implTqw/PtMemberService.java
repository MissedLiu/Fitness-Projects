package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo2;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

import java.util.List;

public interface PtMemberService {
    //通过套餐类型查询私教会员
    IPage<Member> findPtMember(MemberQueryVo memberQueryVo);



    /*
     *
     *新增私教会员
     *
     */
    int addPtMember(MemberQueryVo2 memberQueryVo2);


    /*
     *
     *通过套餐办理编号删除私教会员
     *
     */
    boolean delPtMemberById(long mmId);


    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息
     *
     */
    PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId);

    /*
    *
    *续费
    *
    */
    int renewPtMember(MemberQueryVo memberQueryVo);

    //通过会员id查询办理的私教套餐
    List<MemberQueryVo> findPtByMemberId(Long memberId);
}
