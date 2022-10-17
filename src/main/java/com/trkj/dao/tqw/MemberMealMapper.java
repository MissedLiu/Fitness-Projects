package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.CompactQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
*
*会员套餐
*
*/
public interface MemberMealMapper extends BaseMapper<MemberMeal> {
    //查询会员下办了套餐却没有签订合同的套餐
    List<CompactQueryVo> selectMemberMeal(Long memberId);

}
