package com.trkj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.ScheduleQueryVo;

import java.util.List;

/**
* @author oyzz
* @description 针对表【schedule(物品采购计划表)】的数据库操作Service
* @createDate 2022-09-21 15:55:23
*/
public interface ScheduleService extends IService<Schedule> {
    //查询采购计划
    IPage<Schedule> findPlanList(IPage<Schedule> page, ScheduleQueryVo scheduleQueryVo);

    boolean addPlan(Schedule schedule);
    boolean toPo(Schedule schedule);
    boolean updatePlanState(Schedule schedule);
}
