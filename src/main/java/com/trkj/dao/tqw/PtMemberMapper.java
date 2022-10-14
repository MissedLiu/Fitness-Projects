package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PtMemberMapper extends BaseMapper<Member> {
    //动态查询私教会员（私教）
    IPage<Member> findPtMember(Page<Member> page , @Param("query") MemberQueryVo memberQueryVo);

    //通过电话和类型和套餐编号和项目编号和教练编号私教会员
    MemberQueryVo findMemberByPtAll(@Param("mealType") String mealType,
                                    @Param("memberPhone") String memberPhone,
                                    @Param("mealId") Long mealId,
                                    @Param("ptpId") long ptpId,
                                    @Param("empId") long empId);

    //根据所选项目表套餐办理编号查询教练，套餐信息（私教）
    PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId);
    //通过会员id查询办理的私教套餐
    List<MemberQueryVo> findPtByMemberId(Long memberId);
}
