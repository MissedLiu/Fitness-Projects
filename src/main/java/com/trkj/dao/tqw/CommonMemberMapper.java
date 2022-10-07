package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.apache.ibatis.annotations.Param;

public interface CommonMemberMapper extends BaseMapper<Member> {
    //动态查询私教会员（私教）
    IPage<MemberQueryVo> findCommonMemberAll(Page<MemberQueryVo> page , @Param("query") MemberQueryVo memberQueryVo);

    //通过电话和类型和套餐编号查会员
    MemberQueryVo findMemberByPhoneAndMealTypeAndMealId(@Param("mealType") String mealType,
                                                        @Param("memberPhone") String memberPhone,
                                                        @Param("mealId") Long mealId);
}
