package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.CommonMeal;

import java.util.List;

/**
*普通套餐
*/
public interface CommonMealService extends IService<CommonMeal> {
    /*
     *
     *通过是否禁用查询普通套餐
     *
     */
    List<CommonMeal> selectPtMeal();
    /*
    *
    *通过id查普通套餐
    *
    */
    CommonMeal selectCommonMealByMealId(Long cmId);
}
