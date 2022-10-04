package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.service.implOuyang.DisburseService;
import com.trkj.service.implOuyang.ScheduleService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/plan")
public class SheduleController {

    @Resource
    private ScheduleService scheduleService;

    @Resource
    private DisburseService disburseService;

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
        if ("未执行".equals(schedule.getScheduleState())) {
            if (scheduleService.updateById(schedule)){
                return Result.ok().message("修改成功");
            }
        }return Result.error().message("该计划已执行，不能再编辑！");
    }

    //删除采购计划记录
    @DeleteMapping("/delete/{id}")
    private Result daletePlan(@PathVariable Long id) {
        if (scheduleService.removeById(id)) {
            return Result.ok().message("恭喜您删除成功");
        }
        return Result.ok().message("删除失败");
    }

    //采购完成，将数据插入已购物品表
    @PostMapping("/toPo")
    private Result toPo(@RequestBody ScheduleQueryVo schedule) {
        if (scheduleService.getPlanNum(schedule)>=schedule.getScheduleNum()){
            if ("未执行".equals(schedule.getScheduleState())){
                if (scheduleService.toPo(schedule) && disburseService.toDisburse(schedule)) {
                    if (scheduleService.updatePlanState(schedule)) {
                        return Result.ok().message("成功执行该采购计划！");
                    } else {
                        return Result.error();
                    }
                }
                return Result.error().message("采购计划执行失败");
            }return Result.error().message("该采购计划已经完成了！");
        }return Result.error().message("采购数量不可多于计划数量！");

    }

    @GetMapping("/getNotExecuted")
    public Result getNotExecuted(ScheduleQueryVo scheduleQueryVo){
        IPage<Schedule> page =new Page<>(scheduleQueryVo.getPageNo(),scheduleQueryVo.getPageSize());
        scheduleService.getNotExecuted(page,scheduleQueryVo);
        return Result.ok(page);
    }
}
