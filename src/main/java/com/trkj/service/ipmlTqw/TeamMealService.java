package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.TeamMeal;

import java.util.List;

/**
*
*/
public interface TeamMealService extends IService<TeamMeal> {
    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    List<TeamMeal> selectTeamMeal();
    /*
     *
     *通过选择的私教套餐id查询该套餐下的私教教练列表
     *
     */
    List<Emp> selectEmpByTeamId(Long teamId);
    /*
     *
     *通过团操套餐id查询套餐信息
     *
     */
    TeamMeal selectTeamMealByMealId(long mealId);

}
