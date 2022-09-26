package com.trkj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.Role;
import com.trkj.entity.Schedule;
import com.trkj.service.ScheduleService;
import com.trkj.utils.Result;
import com.trkj.vo.query.ScheduleQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class SheduleController {

    @Resource
    private ScheduleService scheduleService;

    @GetMapping("/list")
    public Result findPlanList(ScheduleQueryVo scheduleQueryVo) {
        //创建分页对象
        IPage<Schedule> page =new Page<>(scheduleQueryVo.getPageNo(),scheduleQueryVo.getPageSize());
        //调用分页查询方法
        scheduleService.findPlanList(page,scheduleQueryVo);

        return Result.ok(page);
    }

    //添加采购计划
    @PostMapping("/add")
    private Result addPlan(@RequestBody Schedule schedule) {
        return Result.ok(scheduleService.addPlan(schedule));
    }

    //修改采购计划
    @PutMapping("/update")
    private Result updatePlan(@RequestBody Schedule schedule) {
        if (scheduleService.updateById(schedule)) {
            return Result.ok().message("恭喜您修改成功");
        }
        return Result.ok().message("修改失败");
    }

    //删除采购计划记录
    @DeleteMapping("/delete/{id}")
    private Result daletePlan(@PathVariable Long id) {
        System.out.println("-------------------------------------------------------");
        System.out.println(id);
        if (scheduleService.removeById(id)) {
            return Result.ok().message("恭喜您删除成功");
        }
        return Result.ok().message("删除失败");
    }

    //采购完成，将数据插入已购物品表
    @PostMapping("/toPo")
    private Result toPo(@RequestBody Schedule schedule) {
        System.out.println("------------------------------------------------");
        System.out.println(schedule.getScheduleState());
        if ("未执行".equals(schedule.getScheduleState())){
            if (scheduleService.toPo(schedule)) {
                if (scheduleService.updatePlanState(schedule)) {
                    return Result.ok().message("成功执行该采购计划！");
                } else {
                    return Result.error();
                }
            }
            return Result.error().message("采购计划执行失败");
        }return Result.error().message("该采购计划已经完成了！");
    }
}
