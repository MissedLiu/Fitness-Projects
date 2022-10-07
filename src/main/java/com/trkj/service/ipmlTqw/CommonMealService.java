package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.CommonMeall;

import java.util.List;

/**
*普通套餐
*/
public interface CommonMealService extends IService<CommonMeall> {
    /*
     *
     *通过是否禁用查询普通套餐
     *
     */
    List<CommonMeall> selectPtMeal();
    /*
    *
    *通过id查普通套餐
    *
    */
    CommonMeall selectCommonMealByMealId(Long cmId);
}
