package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

public interface TeamMemberService {
    /*
     *
     *通过套餐类型查询团操会员
     *
     */
    IPage<MemberQueryVo> findTeamMember(MemberQueryVo memberQueryVo);
    /*
     *
     *新增团操会员
     *
     */
    int addTeamMember(MemberQueryVo memberQueryVo);
    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息（团操）
     *
     */
    PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId);
    /*
    *
    *续费
    *
    */
    int renewTeamMember(MemberQueryVo memberQueryVo);

}
