package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【schedule(物品采购计划表)】的数据库操作Mapper
* @createDate 2022-09-21 15:55:23
* @Entity com.trkj.entity.ouyang.Schedule
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

    @Select(value = "select schedule_num from schedule where schedule_id=#{scheduleId}")
    public Long getPlanNum(Schedule schedule);
}




