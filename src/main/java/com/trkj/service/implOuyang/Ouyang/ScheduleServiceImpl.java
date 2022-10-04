package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.service.implOuyang.ScheduleService;
import com.trkj.dao.ouyang.ScheduleMapper;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【schedule(物品采购计划表)】的数据库操作Service实现
 * @createDate 2022-09-21 15:55:23
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
        implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    /**
     * 分页查询采购计划
     * @param page
     * @param scheduleQueryVo
     * @return
     */
    @Override
    public IPage<Schedule> findPlanList(IPage<Schedule> page, ScheduleQueryVo scheduleQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<Schedule>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(scheduleQueryVo.getScheduleName()), "schedule_name", scheduleQueryVo.getScheduleName());
        //根据日期降序
        queryWrapper.orderByDesc("schedule_time");
        //获取store列表
        return baseMapper.selectPage(page, queryWrapper);


    }

    /**
     * 添加采购计划
     * @param schedule
     * @return
     */
    @Override
    public boolean addPlan(Schedule schedule) {
        if (scheduleMapper.addPlan(schedule)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 完成采购计划，把数据插入已购物品表
     * @param schedule
     * @return
     */
    @Override
    public boolean toPo(Schedule schedule) {
        return scheduleMapper.toPo(schedule);
    }

    /**
     * 修改采购计划状态
     * @param schedule
     * @return
     */
    @Override
    public boolean updatePlanState(Schedule schedule) {
        return scheduleMapper.updatePlanState(schedule);
    }

    /**
     * 获取所有未执行的计划
     * @param page
     * @param scheduleQueryVo
     * @return
     */
    @Override
    public IPage<Schedule> getNotExecuted(IPage<Schedule> page,ScheduleQueryVo scheduleQueryVo) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper();
        queryWrapper.eq("schedule_state","未执行");
        return baseMapper.selectPage(page,queryWrapper);
    }

    /**
     * 根据ID查询计划采购的数量
     * @param schedule
     * @return
     */
    @Override
    public Long getPlanNum(Schedule schedule) {
        return scheduleMapper.getPlanNum(schedule);
    }


}




