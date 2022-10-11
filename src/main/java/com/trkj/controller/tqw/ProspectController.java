package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Prospect;
import com.trkj.service.implTqw.ProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.ProspectQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/prospect")
public class ProspectController {
    @Resource
    private ProspectService prospectService;
    //分页查询潜在用户列表（电话查询）
    @GetMapping("/findProspect")
    public Result findProspect(ProspectQueryVo prospectQueryVo){
        return Result.ok(prospectService.findProspectList(prospectQueryVo));
    }
    //新增潜在用户
    @PreAuthorize("hasAuthority('prospects:prospects:add')")
    @PostMapping("/addProspect")
    public Result addProspect(@RequestBody Prospect prospect){
        if(prospectService.addProspect(prospect)){
           return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }
    //删除潜在用户
    @PreAuthorize("hasAuthority('prospects:prospects:delete')")
    @DeleteMapping("/deleteProspect/{prospectId}")
    public Result deleteProspect(@PathVariable Long prospectId){
        if(prospectService.deleteProspect(prospectId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败,用户为重点或普通对象");
    }

    //修改潜在用户
    @PreAuthorize("hasAuthority('prospects:prospects:edit')")
    @PutMapping("/updProspect")
    public Result updProspect(@RequestBody Prospect prospect){
        if(prospectService.updProspecr(prospect)==true){
            return Result.ok().message("修改成功");
        }
        return Result.error().message("修改失败");
    }

    //通过id修改潜在用户状态
    @PreAuthorize("hasAuthority('prospects:prospects:editById')")
    @PutMapping("/updProspectById")
    public Result updProspectById(@RequestBody Prospect prospect){
        if(prospectService.updProspectById(prospect)==true){
            return Result.ok().message("修改成功");
        }
        return Result.error().message("修改失败");
    }


}
