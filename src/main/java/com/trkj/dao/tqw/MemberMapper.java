package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
*会员表
*
*/
public interface MemberMapper extends BaseMapper<Member> {

    //通过电话或类型或套餐编号查会员(会员查询，普通会员查询)
    List<MemberQueryVo> findMemberByPhoneOrMealTypeOrMealId(@Param("mealType") String mealType,
                                                            @Param("memberPhone") String memberPhone,
                                                            @Param("mealId") Long mealId);

    //通过电话和类型和套餐编号查会员
    MemberQueryVo findMemberByPhoneAndMealTypeAndMealId(@Param("mealType") String mealType,
                                                            @Param("memberPhone") String memberPhone,
                                                            @Param("mealId") Long mealId);

    //通过电话或类型或套餐编号查私教会员（私教）
    List<MemberQueryVo> findPtMemberByPhoneOrMealTypeOrMealId(@Param("mealType") String mealType,
                                                              @Param("memberPhone") String memberPhone,
                                                              @Param("mealId") Long mealId);

    //通过电话和类型和套餐编号和项目编号和教练编号私教会员
    MemberQueryVo findMemberByPtAll(@Param("mealType") String mealType,
                                    @Param("memberPhone") String memberPhone,
                                    @Param("mealId") Long mealId,
                                    @Param("ptpId") long ptpId,
                                    @Param("empId") long empId);

    //根据所选项目表套餐办理编号查询教练，套餐信息（私教）
    PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId);


    //通过电话或类型或套餐编号查团操会员
    List<MemberQueryVo> findTeamMemberByPhoneOrMealTypeOrMealId(@Param("mealType") String mealType,
                                                              @Param("memberPhone") String memberPhone,
                                                              @Param("mealId") Long mealId);

    //通过电话和类型和套餐编号和项目编号和教练编号团操会员
    MemberQueryVo findMemberByTeamAll(@Param("mealType") String mealType,
                                    @Param("memberPhone") String memberPhone,
                                    @Param("mealId") Long mealId,
                                    @Param("tpId") long tpId,
                                    @Param("empId") long empId);

    //根据所选项目表套餐办理编号查询教练，套餐信息(团操)
    PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId);
}

