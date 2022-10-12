package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.CaigouShenheMapper;
import com.trkj.dto.CaiGouShenHeDTO;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.service.implOuyang.ScheduleService;
import com.trkj.dao.ouyang.ScheduleMapper;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyzz
 * @description 针对表【schedule(物品采购计划表)】的数据库操作Service实现
 * @createDate 2022-09-21 15:55:23
 */
@Service
@Transactional
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
        implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;
    @Resource
    private CaigouShenheMapper caigouShenheMapper;
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
        queryWrapper.eq("scheduleemp_id",scheduleQueryVo.getScheduleempId());
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

    /**
     * @description:
     * 添加进采购审核
     * @author: Liucz
     * @date: 2022/10/5 14:26
     * @param:
     * @return:
     **/
    @Override
    public int addCaiGouShenHe(CaiGouShenHeDTO caiGouShenHeDTO) {

        return  caigouShenheMapper.addCaigouSh(caiGouShenHeDTO.getScheduleId(),caiGouShenHeDTO.getId());
    }
    //修改采购计划表的状态为待审核
    @Override
    public int updateState(Long id) {
        return scheduleMapper.updateState(id);
    }
    //查询当前人采购计划状态为1-待审核的记录
    @Override
    public IPage<CaigouShenhe> findCaiGouStateByState(PageVo pageVo) {
        Page<CaigouShenhe> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<CaigouShenhe> caiGouStateByState = scheduleMapper.findCaiGouStateByState(page, pageVo.getShenheempId());
        return caiGouStateByState;
    }
    //根据状态不为0-已审核的查询该审核人id下的所有信息
    @Override
    public IPage<CaigouShenhe> findCaiGouStateByStatetrue(PageVo pageVo) {
        Page<CaigouShenhe> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<CaigouShenhe> caiGouStateByStatetrue = scheduleMapper.findCaiGouStateByStatetrue(page, pageVo.getShenheempId());
        return caiGouStateByStatetrue;
    }
    /**
     * @description:
     * 修改采购计划表中的状态为3-审核不通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    @Override
    public int updateSchduleSteta(Long id) {
        int i = scheduleMapper.updateSchduleSteta(id);
        return i;
    }

    /**
     * @description:
     * 修改采购计划表中的状态为2-审核通过
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    @Override
    public int updateSchduleSteta2(Long id) {
        int i = scheduleMapper.updateSchduleSteta2(id);
        return i;
    }
    /**
     * @description:
     * 根据采购编号查询状态
     * @author: Liucz
     * @date: 2022/10/5 21:00
     * @param:
     * @return:
     **/
    @Override
    public int findState(Long id) {
        QueryWrapper<Schedule> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("schedule_id" ,id);
        Schedule schedule = baseMapper.selectOne(queryWrapper);
        return schedule.getScheduleState();
    }
    /**
     * @description:
     * 修改采购计划表中的状态为4-已执行
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    @Override
    public int updateSchduleSteta4(Long id) {
        int i = scheduleMapper.updateSchduleSteta4(id);
        return i;
    }
    /**
     * @description:
     * 修改采购计划表中的状态为5-已撤销
     * @author: Liucz
     * @date: 2022/10/5 18:55
     * @param:
     * @return:
     **/
    @Override
    public int updateSchduleSteta5(Long id) {
        int i = scheduleMapper.updateSchduleSteta5(id);
        return i;
    }

}




