package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.service.implOuyang.EmaintenanceService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.EmaintenanceQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName EmaintenanceController
 * @Description 器材维修记录
 * @Author Ouyang
 * @Date 2022/10/4 8:49
 * @since JDK 8
 **/
@RestController
@RequestMapping("/api/equipment")
public class EmaintenanceController {

    @Resource
    EmaintenanceService emaintenanceService;

    @GetMapping("/list")
    public Result getList(EmaintenanceQueryVo emaintenanceQueryVo){
        //创建分页插件对象
        IPage<Eeamage> page = new Page<>(emaintenanceQueryVo.getPageNo(), emaintenanceQueryVo.getPageSize());
        //调用分页查询方法
        emaintenanceService.getEmList(page, emaintenanceQueryVo);
        return Result.ok(page);
    }

    @PreAuthorize("hasAnyAuthority('equipment:plan:delete')")
    @DeleteMapping("/delete/{id}")
    public Result deleteEm(@PathVariable Long id){
        if (emaintenanceService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
    }

