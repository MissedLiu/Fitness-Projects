package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.trkj.service.implLiucz2.CaigouShenheService;
import com.trkj.service.implOuyang.ScheduleService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-05  16:03
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/caiGouShenHe")
public class CaiGouShenHeController {
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private CaigouShenheService caigouShenheService;

    //根据状态1-待审核的查询该审核人id下的所有信息
    @GetMapping("/list")
    public Result findListByEmpId(PageVo pageVo) {
        IPage<CaigouShenhe> caiGouStateByState = scheduleService.findCaiGouStateByState(pageVo);
        return Result.ok(caiGouStateByState);
    }

    //根据状态不为0-已审核的查询该审核人id下的所有信息
    @GetMapping("/truelist")
    public Result findListByEmpIdtrue(PageVo pageVo) {
        IPage<CaigouShenhe> caiGouStateByState = scheduleService.findCaiGouStateByStatetrue(pageVo);
        return Result.ok(caiGouStateByState);
    }

    /**
     * @description: 同意事件
     * @author: Liucz
     * @date: 2022/10/5 16:46
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('shenhes:caigou:cl')")
    @PostMapping("/agree")
    public Result agree(@RequestBody CaigouShenhe caigouShenhe) {

        //修改审核表中的状态为同意
        int i = caigouShenheService.updateAgress(caigouShenhe);
        if (i == 1) {
            //根据采购编号查询审核表中的状态都为1-同意时则修改采购计划的状态为-2-审核通过
            //根据采购编号查询审核状态
            List<CaigouShenhe> allState = caigouShenheService.findAllState(caigouShenhe.getScheduleId());
            int d = allState.size();
            System.out.println("ddd=" + d);
            int x = 0;
            for (CaigouShenhe allStates : allState) {
                if (allStates.getState() == 1) {
                    x++;
                    if (d == x) {
                        //全部同意,可以修改
                        scheduleService.updateSchduleSteta2(caigouShenhe.getScheduleId());
                    }
                }
            }
            return Result.ok().message("已同意");
        }

        return Result.error().message("同意失败");
    }

    /**
     * @description: 拒绝事件
     * @author: Liucz
     * @date: 2022/10/5 18:40
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('shenhes:caigou:cl')")
    @PostMapping("/refuse")
    public Result refuse(@RequestBody CaigouShenhe caigouShenhe) {

        int i = caigouShenheService.updateRefuse(caigouShenhe);
        if (i == 1) {
            //修改状态为拒绝-2,同时也修改采购计划中的状态为3-审核不通过
            int i1 = scheduleService.updateSchduleSteta(caigouShenhe.getScheduleId());
            if (i1 == 1) {
                return Result.ok().message("已驳回");
            }
            return Result.error().message("驳回失败!");
        }
        return Result.error().message("驳回失败!!");
    }

    /**
     * @description: 删除事件, 修改状态为5-删除
     * @author: Liucz
     * @date: 2022/10/5 19:55
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('shenhes:caigou:delete')")
    @PostMapping("/delete5")
    public Result delete5(@RequestBody CaigouShenhe caigouShenhe) {
        return Result.ok(caigouShenheService.delete5(caigouShenhe));
    }
    /**
     * @description:
     * 查询该采购计划的审核数据
     * @author: Liucz
     * @date: 2022/10/12 14:46
     * @param:
     * @return:
     **/
    @GetMapping("/fingShengheJiHua/{id}")
    public Result fingShengheJiHua(@PathVariable Long id){
        List<CaigouShenhe> allCaigouShenheByscheduleId = caigouShenheService.findAllCaigouShenheByscheduleId(id);
        return Result.ok(allCaigouShenheByscheduleId);
    }
}