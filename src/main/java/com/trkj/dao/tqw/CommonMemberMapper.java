package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonMemberMapper extends BaseMapper<Member> {
    //动态查询普通会员（普通）
    IPage<Member> findCommonMemberAll(Page<Member> page , @Param("query") MemberQueryVo memberQueryVo);

    //通过电话和类型和套餐编号查会员
    MemberQueryVo findMemberByPhoneAndMealTypeAndMealId(@Param("mealType") String mealType,
                                                        @Param("memberPhone") String memberPhone,

                                                        @Param("mealId") Long mealId);
    //通过会员id查询办理的普通套餐
    List<MemberQueryVo> findCommonByMemberId(Long memberId);
}
