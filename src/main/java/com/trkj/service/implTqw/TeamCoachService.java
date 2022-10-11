package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.TeamCoach;
import com.trkj.vo.queryTqw.EmpAndTeamMealQueryVo;

import java.util.List;

/**
*
*/
public interface TeamCoachService extends IService<TeamCoach> {

    //新增团操套餐教练关系表数据
    boolean addEmpAndTeamMeal(EmpAndTeamMealQueryVo empAndTeamMealQueryVo);

    //通过员工id查询团操关系表数据
    List<TeamCoach> findTeamAndEmpByEmpId(Long empId);
}
