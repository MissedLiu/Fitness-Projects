package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.dto.CaiGouShenHeDTO;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.service.implLiucz2.CaigouShenheService;
import com.trkj.service.implOuyang.DisburseService;
import com.trkj.service.implOuyang.ScheduleService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class SheduleController {

    @Resource
    private ScheduleService scheduleService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DisburseService disburseService;
    @Resource
    private CaigouShenheService caigouShenheService;

    @GetMapping("/list")
    public Result findPlanList(ScheduleQueryVo scheduleQueryVo) {
        //创建分页对象
        IPage<Schedule> page = new Page<>(scheduleQueryVo.getPageNo(), scheduleQueryVo.getPageSize());
        //调用分页查询方法
        scheduleService.findPlanList(page, scheduleQueryVo);

        return Result.ok(page);
    }

    //添加采购计划
    @PreAuthorize("hasAnyAuthority('stores:plan:add')")
    @PostMapping("/add")
    public Result addPlan(@RequestBody Schedule schedule) {
        return Result.ok(scheduleService.addPlan(schedule));
    }

    //修改采购计划
    @PreAuthorize("hasAnyAuthority('stores:plan:edit')")
    @PutMapping("/update")
    public Result updatePlan(@RequestBody Schedule schedule) {

        if (scheduleService.updateById(schedule)) {
            return Result.ok().message("修改成功");
        }
        return Result.exist().message("修改失败");
    }

    //删除采购计划记录
    @PreAuthorize("hasAnyAuthority('stores:plan:delete')")
    @DeleteMapping("/delete/{id}")
    public Result daletePlan(@PathVariable Long id) {
        System.out.println("id="+id);
        //根据当前计划id查询出状态
        int state = scheduleService.findState(id);
        System.out.println("state="+state);
        if (state != 0&& state!=5) {
            return Result.exist().message("删除失败,该状态下无法删除");
        }

            if (scheduleService.removeById(id)) {
                return Result.ok().message("恭喜您删除成功");
            }

        return Result.exist().message("删除失败");
    }

    //采购完成，将数据插入已购物品表

    @PreAuthorize("hasAnyAuthority('stores:plan:toPo')")
    @PostMapping("/toPo")
    public Result toPo(@RequestBody ScheduleQueryVo schedule) {
        //先判断是否已经入库了
        int state = scheduleService.findState(schedule.getScheduleId());
        if (state == 4) {
            return Result.exist().message("该计划已经执行入库了");
        }
        if (schedule.getScheduleState() == 2) {
            if (scheduleService.toPo(schedule) && disburseService.toDisburse(schedule)) {
                //修改为已执行
                int i = scheduleService.updateSchduleSteta4(schedule.getScheduleId());
                if (i == 1) {
                    return Result.ok().message("成功执行该采购计划！");
                }
                return Result.exist().message("执行该采购计划不成功！");
            }
            return Result.error().message("采购计划执行失败");
        }
        return Result.exist().message("审核未通过!");


    }

    /**
     * 获取所有未执行的采购计划
     *
     * @param scheduleQueryVo
     * @return
     */
    @GetMapping("/getNotExecuted")
    public Result getNotExecuted(ScheduleQueryVo scheduleQueryVo) {
        IPage<Schedule> page = new Page<>(scheduleQueryVo.getPageNo(), scheduleQueryVo.getPageSize());
        scheduleService.getNotExecuted(page, scheduleQueryVo);
        return Result.ok(page);
    }

    /**
     * @description: 查询财务部的所有员工
     * @author: Liucz
     * @date: 2022/10/5 13:43
     * @param:
     * @return:
     **/
    @GetMapping("/findCaiWuEmp")
    public Result findCaiWuEmp() {
        return Result.ok(userMapper.findCaiwu());
    }

    /**
     * @description: 添加分配采购审核
     * @author: Liucz
     * @date: 2022/10/5 14:21
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('stores:plan:shenhe')")
    @PostMapping("/addCaiGouShenHe")
    public Result addCaiGouShenHe(@RequestBody CaiGouShenHeDTO caiGouShenHeDTO) {

        //修改采购计划表的状态为1-待审核
        int i1 = scheduleService.updateState(caiGouShenHeDTO.getScheduleId());
        if (i1 != 1) {
            return Result.error().message("审核状态修改失败");
        }
        //修改成功,插入数据
        int i = scheduleService.addCaiGouShenHe(caiGouShenHeDTO);
        if (i >= 1) {
            return Result.ok().message("采购申请发送成功");
        }
        return Result.error().message("采购申请发送失败,未选择审核人");
    }

    /**
     * @description: 判断该采购申请是否发起审核
     * @author: Liucz
     * @date: 2022/10/5 15:04
     * @param:
     * @return:
     **/
    @GetMapping("/checkShenqing/{id}")
    public Result checkShenqing(@PathVariable Long id) {
        List<CaigouShenhe> caigouShenhes = caigouShenheService.checkShenqing(id);
        if (caigouShenhes != null && caigouShenhes.size() > 0) {
            return Result.exist().message("该采购计划已经发起审核");
        }
        return Result.ok(true);
    }

    /**
     * @description: 判断该计划是否已执行或已入库
     * @author: Liucz
     * @date: 2022/10/5 21:18
     * @param:
     * @return:
     **/
    @GetMapping("/checkJihua/{id}")
    public Result checkJihua(@PathVariable Long id) {
        //根据当前计划id查询出状态
        int state = scheduleService.findState(id);
        if (!ObjectUtils.isEmpty(state) && state == 0|| state == 5) {
            return Result.ok();
        }
        return Result.exist().message("该计划只有在未审核状态下才能编辑");
    }

    @PreAuthorize("hasAnyAuthority('stores:plan:cxshenhe')")
    @GetMapping("/chexiao/{id}")
    public Result chexiao(@PathVariable Long id) {
        //根据当前计划id查询出状态
        System.out.println("id==" + id);
        int state = scheduleService.findState(id);
        if (!ObjectUtils.isEmpty(state) && state == 0) {
            return Result.exist().message("该计划未发起审核");
        } else if (!ObjectUtils.isEmpty(state) && state == 2) {
            return Result.exist().message("审核已通过,无法撤销");
        } else if (!ObjectUtils.isEmpty(state) && state == 4) {
            return Result.exist().message("该计划已执行,无法撤销");
        }
        if (!ObjectUtils.isEmpty(state) && state == 5) {
            return Result.exist().message("该计划已经撤销,无需重复撤销");
        }
        //删除审核记录中的关系
        int i = caigouShenheService.delete6(id);
        System.out.println("1111111=" + i);
        //修改状态为5-已撤销
        int i1 = scheduleService.updateSchduleSteta5(id);
        System.out.println("2222=" + i1);
        if (i1 == 1 && i >= 1) {
            return Result.ok().message("已成功撤回");
        }
        return Result.error().message("撤回失败");

    }
}
