package com.trkj.dao;

import com.trkj.entity.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.beans.binding.BooleanBinding;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import reactor.core.scheduler.Scheduler;

import java.util.List;

/**
* @author oyzz
* @description 针对表【schedule(物品采购计划表)】的数据库操作Mapper
* @createDate 2022-09-21 15:55:23
* @Entity com.trkj.entity.Schedule
*/
public interface ScheduleMapper extends BaseMapper<Schedule> {
    @Insert(value = "insert into schedule (schedule_name,schedule_type,schedule_supplier," +
                    "unit, schedule_address, schedule_num,schedule_price,brand) value " +
                    "(#{scheduleName},#{scheduleType},#{scheduleSupplier},#{unit}," +
                    "#{scheduleAddress},#{scheduleNum},#{schedulePrice},#{brand})")
    public Boolean addPlan(Schedule schedule);

    @Insert(value = "insert into po(schedule_id, po_name, po_num, po_price," +
            " brand, schedule_address, schedule_supplier, po_type) VALUES " +
            "(#{scheduleId},#{scheduleName},#{scheduleNum},#{schedulePrice}," +
            "#{brand},#{scheduleAddress},#{scheduleSupplier},#{scheduleType})")
    public Boolean toPo(Schedule schedule);

    @Update("update schedule set schedule_state='已执行' where schedule_id = #{scheduleId}")
    public Boolean updatePlanState(Schedule schedule);
}




