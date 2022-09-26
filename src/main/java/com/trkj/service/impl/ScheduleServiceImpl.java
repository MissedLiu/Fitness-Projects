package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.Schedule;
import com.trkj.service.ScheduleService;
import com.trkj.dao.ScheduleMapper;
import com.trkj.vo.query.ScheduleQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @author oyzz
* @description 针对表【schedule(物品采购计划表)】的数据库操作Service实现
* @createDate 2022-09-21 15:55:23
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService{

    @Resource
    private ScheduleMapper mapper;

    @Override
    public IPage<Schedule> findPlanList(IPage<Schedule> page, ScheduleQueryVo scheduleQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<Schedule>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(scheduleQueryVo.getScheduleName()),"schedule_name",scheduleQueryVo.getScheduleName());
        //获取store列表
        return  baseMapper.selectPage(page,queryWrapper);


    }

    @Override
    public boolean addPlan(Schedule schedule) {
        Boolean a=mapper.addPlan(schedule);
        if (a=true){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean toPo(Schedule schedule) {
        return mapper.toPo(schedule);
    }

    @Override
    public boolean updatePlanState(Schedule schedule) {
        return mapper.updatePlanState(schedule);
    }


}




