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
    //添加采购计划
    boolean addPlan(Schedule schedule);
    //执行采购计划
    boolean toPo(Schedule schedule);
    //修改计划状态
    boolean updatePlanState(Schedule schedule);
    //获取未执行的采购计划
    IPage<Schedule> getNotExecuted(IPage<Schedule> page,ScheduleQueryVo scheduleQueryVo);
    //获取计划采购的物品数量
    Long getPlanNum(Schedule schedule);
}
