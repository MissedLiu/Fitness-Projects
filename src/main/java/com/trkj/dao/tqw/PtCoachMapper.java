package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.PtCoach;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.trkj.entity.PtCoach
*/
public interface PtCoachMapper extends BaseMapper<PtCoach> {

    //添加教练私教关系
    int insertPtCoachs(@Param("empId") Long empId, @Param("ptMealId") List<Long> ptMealId);

}
