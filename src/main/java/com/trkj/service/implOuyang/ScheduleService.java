package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.dto.CaiGouShenHeDTO;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.trkj.entity.ouyang.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;

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
    /**
     * @description:
     * 添加进采购审核
     * @author: Liucz
     * @date: 2022/10/5 14:26
     * @param:
     * @return:
     **/
    int addCaiGouShenHe(CaiGouShenHeDTO caiGouShenHeDTO);

    //修改采购计划表的状态
    int updateState(Long id);
    //查询当前人采购计划状态为1-待审核的记录
    IPage<CaigouShenhe> findCaiGouStateByState(PageVo pageVo);
    //根据状态不为0-已审核的查询该审核人id下的所有信息
    IPage<CaigouShenhe> findCaiGouStateByStatetrue(PageVo pageVo);
    /**
     * @description:
     * 修改采购计划表中的状态为3-审核不通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta(Long id);
    /**
     * @description:
     * 修改采购计划表中的状态为2-审核通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta2(Long id);
    /**
     * @description:
     * 根据采购编号查询状态
     * @author: Liucz
     * @date: 2022/10/5 21:00
     * @param:
     * @return:
     **/
    int findState(Long id);
    /**
     * @description:
     * 修改采购计划表中的状态为4-已执行
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta4(Long id);
    /**
     * @description:
     * 修改采购计划表中的状态为5-已撤销
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    int updateSchduleSteta5(Long id);
}
