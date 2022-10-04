package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.service.implOuyang.EdetailsService;
import com.trkj.service.implOuyang.EeamageService;
import com.trkj.service.implOuyang.EmaintenanceService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/repair")
public class EeamageController {
    @Resource
    private EeamageService eeamageService;

    @Resource
    private EmaintenanceService emaintenanceService;

    @Resource
    private EdetailsService edetailsService;

    @GetMapping("/list")
    public Result getRepairList(EeamageQueryVo eeamageQueryVo) {
        //创建分页插件对象
        IPage<Eeamage> page = new Page<>(eeamageQueryVo.getPageNo(), eeamageQueryVo.getPageSize());
        //调用分页查询方法
        eeamageService.findRepairList(page, eeamageQueryVo);
        return Result.ok(page);
    }

    /**
     * 修理完成，获取报修表的数据 插入器材损坏记录表中
     *
     * @param eeamageQueryVo
     * @return
     */
    @PostMapping("/toEm")
    public Result toEm(@RequestBody EeamageQueryVo eeamageQueryVo) {
        //如果前端获取的状态不为修理完成，则可以将其放入材损坏记录表中
        if (!"修理完成".equals(eeamageQueryVo.getBeizhu())) {
            //调用toEm方法，插入数据
            if (emaintenanceService.toEm(eeamageQueryVo)) {
                //修改报修记录状态为“修理完成”
                if (eeamageService.updateBeizhu(eeamageQueryVo)) {
                    return Result.ok().message("操作成功！");
                }
            }
        }
        return Result.error().message("该报修记录已处理！");
    }

    @PostMapping("/add")
    public Result addRepair(@RequestBody Eeamage eeamage) {

        if (edetailsService.CountDetailsByEdCodeAndName(eeamage) > 0) {
            if (eeamageService.addRepair(eeamage)) {
                return Result.ok().message("上报成功");
            }
            return Result.error().message("上报失败");
        }
        return Result.error().message("器材编码或器材名输入有误，请重新输入！");

    }

    @DeleteMapping("/delete/{id}")
    public Result deleteRepair(@PathVariable Long id) {

        if (eeamageService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
