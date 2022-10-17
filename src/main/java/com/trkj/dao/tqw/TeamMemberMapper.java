package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamMemberMapper extends BaseMapper<Member> {
    //查询团操会员
    IPage<MemberQueryVo> findTeamMember(Page<MemberQueryVo> page , @Param("query") MemberQueryVo memberQueryVo);

    //通过电话和类型和套餐编号和项目编号和教练编号团操会员
    MemberQueryVo findMemberByTeamAll(@Param("mealType") String mealType,
                                      @Param("memberPhone") String memberPhone,
                                      @Param("mealId") Long mealId,
                                      @Param("tpId") long tpId,
                                      @Param("empId") long empId);

    //根据所选项目表套餐办理编号查询教练，套餐信息(团操)
    PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId);
    //通过会员id查询办理的私教套餐
    List<MemberQueryVo> findTeamByMemberId(Long memberId);
}
