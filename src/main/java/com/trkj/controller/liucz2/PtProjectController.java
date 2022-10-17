package com.trkj.controller.liucz2;

import com.trkj.entity.liucz2.PtProject;
import com.trkj.service.implLiucz2.PtChooseSerivce;
import com.trkj.service.implLiucz2.PtProjectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz2.PtProjectVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ptProject")
public class PtProjectController {
    @Resource
    private PtProjectService ptProjectService;
    @Resource
    private PtChooseSerivce ptChooseSerivce;
 /*
 *
 * 分页并按条件查找所有私教项目
 * */
    @GetMapping("list")
    public Result selectPtProject(PtProjectVo ptProjectVo){
        return  Result.ok(ptProjectService.selectPtProject(ptProjectVo));
    }
    /*添加私教项目*/
    @PreAuthorize("hasAnyAuthority('projectname:ptPro:add')")
    @PostMapping("add")
    public Result addPtProject(@RequestBody PtProject ptProject){
        if(ptProjectService.addPtProject(ptProject)){
            boolean save = ptProjectService.save(ptProject);
            if(save){
                return   Result.ok().message("私教项目添加成功");
            }
            return  Result.ok().message("私教项目添加失败");
        }
        return Result.error().message("该私教项目已存在,添加失败");
    }

    /*删除*/
    @PreAuthorize("hasAnyAuthority('projectname:ptPro:delete')")
    @DeleteMapping("delete/{ptpId}")
    public Result deletePtProjectById(@PathVariable Long ptpId){
        //判断当前项目是否绑定了套餐,有则无法删除
        if (!ptChooseSerivce.findPtChoose(ptpId)){
            return Result.error().message("该项目已被绑定套餐! 无法删除");
        }
        if (ptProjectService.removeById(ptpId)) {
            return Result.ok().message("删除成功!");
        }
        return Result.ok().message("删除失败!");
    }


    /*修改*/
    @PreAuthorize("hasAnyAuthority('projectname:ptPro:edit')")
    @PutMapping("update")
    public Result updatePtProject(@RequestBody PtProject ptProject){
        //根据传入的项目名称,查询是否已经存在
        PtProject ptIdByPtpName = ptProjectService.findPtIdByPtpName(ptProject.getPtpName());
        //判断查询出的id,与当前的id是否相等
        if (ptIdByPtpName !=null){
            if(   ptIdByPtpName.getPtpId() != ptProject.getPtpId()){
                return Result.error().message("修改失败,该项目名已存在");
            }
        }


        if (ptProjectService.updateById(ptProject)){

            return Result.ok().message("修改成功");
        }
        return Result.ok().message("修改失败");
    }
    /**
     * @description:
     * 根据私教套餐id 查询 私教项目id
     * @author: Liucz
     * @date: 2022/10/3 20:26
     * @param:
     * @return:
     **/
    @GetMapping("/findPtpName/{ptId}")
    public Result findPtpName(@PathVariable Long ptId){
        List<PtProject> allName = ptProjectService.findAllName(ptId);
        return Result.ok(allName);
    }
}
