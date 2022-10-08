package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.TeamCoach;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.trkj.entity.TeamCoach
*/
public interface TeamCoachMapper extends BaseMapper<TeamCoach> {


    //添加教练团操关系
    int insertTeamCoachs(@Param("empId") Long empId, @Param("teamMealId") List<Long> teamMealId);
}
