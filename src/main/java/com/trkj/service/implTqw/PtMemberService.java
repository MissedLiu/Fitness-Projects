package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

public interface PtMemberService {
    /*
     *
     *通过套餐类型查询私教会员
     *
     */
    IPage<MemberQueryVo> findPtMember(MemberQueryVo memberQueryVo);



    /*
     *
     *新增私教会员
     *
     */
    int addPtMember(MemberQueryVo memberQueryVo);


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
}
