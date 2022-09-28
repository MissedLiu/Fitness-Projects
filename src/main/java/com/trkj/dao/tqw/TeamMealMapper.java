package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.TeamMeal;

import java.util.List;

/**
* @Entity com.trkj.domain.TeamMealentity
*/
public interface TeamMealMapper extends BaseMapper<TeamMeal> {
// 通过选择的团操套餐id查询该套餐下的团操教练列表
    List<Emp> selectEmpByTeamId(Long teamId);

}
