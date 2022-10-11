package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.PtCoach;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;

import java.util.List;

/**
*
*/
public interface PtCoachService extends IService<PtCoach> {
    //新增私教套餐教练关系表数据
    boolean addEmpAndPtMeal(EmpAndPtMealQueryVo empAndPtMealQueryVo);

    //通过员工id查询私教关系表数据
    List<PtCoach> findPtAndEmpByEmpId(Long empId);
}
