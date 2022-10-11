package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.TeamMeall;

import java.util.List;

/**
*
*/
public interface TeamMealService extends IService<TeamMeall> {
    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    List<TeamMeall> selectTeamMeal();
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
    TeamMeall selectTeamMealByMealId(long mealId);

}
