package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtMeall;

import java.util.List;

/**
*私教套餐
*/
public interface PtMealService extends IService<PtMeall> {
    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    List<PtMeall> selectPtMeal();
    /*
    *
    *通过选择的私教套餐id查询该套餐下的私教教练列表
    *
    */
    List<Emp> selectEmpByPtId(Long ptId);
    /*
    *
    *通过id查询套餐信息
    *
    */
    PtMeall selectPtMealByMealId(long mealId);
}
