package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Black;

import com.trkj.entity.tqw.MemberMeal;
import com.trkj.vo.queryTqw.BlackMemberMealQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
*黑名单表
*
*/
public interface BlackMapper extends BaseMapper<Black>{
    //动态条件查询并分页(会员)
    IPage<MemberAndBlackQueryVo> findBlackMemberAll(Page<MemberAndBlackQueryVo> page , @Param("query") MemberSelectQueryVo memberSelectQueryVo);

    //查询普通套餐
    List<BlackMemberMealQueryVo> selectCommon( @Param("memberId") long memberId);
    //查询私教套餐
    List<BlackMemberMealQueryVo> selectPt(@Param("memberId") long memberId);
    //查询团操套餐
    List<BlackMemberMealQueryVo> selectTeam(@Param("memberId") long memberId);
    //删除套餐
    int deleteMemberMeal(@Param("list") List<MemberMeal> list);
}
