package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtMeal;

import java.util.List;


/*
*
*私教套餐表
*
*/
public interface PtMealMapper extends BaseMapper<PtMeal>{
    //通过选择的私教套餐id查询该套餐下的私教教练列表
    List<Emp> selectEmpByPtId(Long ptId);

}
