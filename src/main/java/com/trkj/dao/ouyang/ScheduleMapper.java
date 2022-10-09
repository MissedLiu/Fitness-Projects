package com.trkj.dao.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.trkj.entity.ouyang.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【schedule(物品采购计划表)】的数据库操作Mapper
* @createDate 2022-09-21 15:55:23
* @Entity com.trkj.entity.ouyang.Schedule
*/
public interface ScheduleMapper extends BaseMapper<Schedule> {
    /**
     * 添加采购计划
     * @param schedule
     * @return
     */
    @Insert(value = "insert into schedule (schedule_name,scheduleemp_id,schedule_type,schedule_supplier," +
            "unit, schedule_address, schedule_num,schedule_price,brand) value " +
            "(#{scheduleName},#{scheduleempId},#{scheduleType},#{scheduleSupplier},#{unit}," +
            "#{scheduleAddress},#{scheduleNum},#{schedulePrice},#{brand})")
    public Boolean addPlan(Schedule schedule);

    /**
     * 采购计划完成、添加到已购物品表
     * @param schedule
     * @return
     */
    @Insert(value = "insert into po(schedule_id, po_name, po_num, po_price," +
            " brand, schedule_address, schedule_supplier, po_type) VALUES " +
            "(#{scheduleId},#{scheduleName},#{scheduleNum},#{schedulePrice}," +
            "#{brand},#{scheduleAddress},#{scheduleSupplier},#{scheduleType})")
    public Boolean toPo(Schedule schedule);

    /**
     * 修改采购计划状态
     * @param schedule
     * @return
     */
    @Update("update schedule set schedule_state='已执行' where schedule_id = #{scheduleId}")
    public Boolean updatePlanState(Schedule schedule);
//通过id查询计划采购的数量
    @Select(value = "select schedule_num from schedule where schedule_id=#{scheduleId}")
    public Long getPlanNum(Schedule schedule);

    //修改采购计划表的状态
    int updateState(Long id);

    //查询当前人采购计划状态为1-待审核的记录
    IPage<CaigouShenhe> findCaiGouStateByState(Page<CaigouShenhe> page, @Param("empId") Long empId);

    //根据状态不为0-已审核的查询该审核人id下的所有信息
    IPage<CaigouShenhe> findCaiGouStateByStatetrue(Page<CaigouShenhe> page, @Param("empId") Long empId);

    /**
     * @description: 修改采购计划表中的状态为3-审核不通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta(Long id);
    /**
     * @description: 修改采购计划表中的状态为2-审核通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta2(Long id);
    /**
     * @description: 修改采购计划表中的状态为4-已执行
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta4(Long id);
    /**
     * @description: 修改采购计划表中的状态为5-撤销
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta5(Long id);
}



