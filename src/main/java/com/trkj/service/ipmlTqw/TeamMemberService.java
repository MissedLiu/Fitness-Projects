package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

import java.util.List;

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

}
