package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtMeall;

import java.util.List;


/*
*
*私教套餐表
*
*/
public interface PtMealMapperl extends BaseMapper<PtMeall>{
    //通过选择的私教套餐id查询该套餐下的私教教练列表
    List<Emp> selectEmpByPtId(Long ptId);

}
