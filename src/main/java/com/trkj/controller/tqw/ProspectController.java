package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Prospect;
import com.trkj.service.ipmlTqw.ProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.ProspectQueryVo;
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
    @PostMapping("/addProspect")
    public Result addProspect(@RequestBody Prospect prospect){
        if(prospectService.addProspect(prospect)){
           return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }
    //删除潜在用户
    @DeleteMapping("/deleteProspect/{prospectId}")
    public Result deleteProspect(@PathVariable Long prospectId){
        if(prospectService.deleteProspect(prospectId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }

    //修改潜在用户
    @PutMapping("/updProspect")
    public Result updProspect(@RequestBody Prospect prospect){
        if(prospectService.updProspecr(prospect)==true){
            return Result.ok().message("修改成功");
        }
        return Result.error().message("修改失败");
    }


}
