package com.trkj.controller.liucz2;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dto.PtMealProjectDTO;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.service.implLiucz2.PtMealService;
import com.trkj.service.implLiucz2.PtProjectService;
import com.trkj.utils.Result;

import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.PtProjectNameVo;
import com.trkj.vo.queryLiucz2.PtProjectVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/ptMeal")
public class PtMealController {
    /*私教套餐*/
    @Resource
    private PtMealService ptMealService;
    @Resource
    private PtProjectService ptProjectService;
     /**
      * @description:
      * 动态查询并分页
      * @author: Liucz
      * @date: 2022/10/2 14:29
      * @param: [ptMealVo]
      * @return: com.trkj.utils.Result
      **/
    @GetMapping("/list")
    public Result selectAllPtMeal(PageVo pageVo) {
        return Result.ok(ptMealService.selectAllPtMeal(pageVo));
    }
    /**
     * @description:
     * 动态查询并分页,状态为0开启的
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.trkj.utils.Result
     **/

    @GetMapping("/listState")
    public Result selectAllPtMealState(PageVo pageVo) {
        return Result.ok(ptMealService.selectAllPtMealState(pageVo));
    }
    /**
     * @description:
     * 添加私教套餐
     * @author: Liucz
     * @date: 2022/10/2 14:49
     * @param: [ptMeal]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:ptMeal:add')")
    @PostMapping("/add")
    public Result addPtMeal(@RequestBody PtMeal ptMeal) {
        //判断当前需要添加的私教套餐名有没有被使用
        PtMeal allByPtname = ptMealService.findAllByPtname(ptMeal);
        if (allByPtname!=null){
            return Result.error().message("该套餐名已存在");
        }
        return Result.ok(ptMealService.save(ptMeal));
    }
    /*修改*/
    @PreAuthorize("hasAnyAuthority('sellgood:ptMeal:edit')")
    @PutMapping("/update")
    public Result update(@RequestBody PtMeal ptMeal) {
        //判断当前需要修改的私教套餐名有没有被使用
        PtMeal allByPtname = ptMealService.findAllByPtname(ptMeal);
        if (allByPtname!=null){
            if(allByPtname.getPtId()!=ptMeal.getPtId()){
                return Result.error().message("修改失败,该套餐名已经存在");
            }
        }
        if (ptMealService.updateById(ptMeal)) {
            return Result.ok().message("套餐修改成功");
        }
        return Result.error().message("套餐修改失败");
    }
    /**
     * @description:
     * 删除套餐,
     * @author: Liucz
     * @date: 2022/10/2 20:19
     * @param: [ptId]
     * @return: com.trkj.utils.Result
     **/

    @PreAuthorize("hasAnyAuthority('sellgood:ptMeal:delete')")
    @DeleteMapping("/delete/{ptId}")
    public Result deleteById(@PathVariable Long ptId) {
        //判断该套餐是否绑定了项目
        List<Long> ptpIdByPtId = ptProjectService.findPtpIdByPtId(ptId);
        System.out.println("ptpIdByPtId="+ptpIdByPtId);
        if (ptpIdByPtId.size()!=0){
            return  Result.error().message("该套餐绑定了私教项目无法删除,删除失败");
        }
        if (ptMealService.removeById(ptId)){
            return Result.ok().message("删除成功");
        }
        return Result.ok().message("删除失败");
    }

    /*
     *
     * 获取私教项目列表
     * */
    @PreAuthorize("hasAnyAuthority('sellgood:ptMeal:xuanze')")
    @GetMapping("/PtProjectList")
    public Result selectPtProject2(PtProjectVo ptProjectVo){
        System.out.println("ptProjectVo=="+ptProjectVo);
        return  Result.ok(ptProjectService.selectPtProjectState(ptProjectVo));
    }
    /**
     * @description:
     * 根据私教套餐id查找该私教套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @GetMapping("/getPtProject/{ptId}")
    public Result getPtProjectPtpIdByPtId(@PathVariable Long ptId){
        //根据私教套餐id查找该私教套餐的项目id
        List<Long> ptpIdByPtId = ptProjectService.findPtpIdByPtId(ptId);
        return Result.ok(ptpIdByPtId);
    }

    /**
     * @description:
     * 保存分配私教套餐的分配的项目
     * @author: Liucz
     * @date: 2022/10/2 17:12
     * @param:
     * @return:
     **/
    @PostMapping("/savePtMealPtProject")
    public Result savePtMealPtProject(@RequestBody PtMealProjectDTO ptMealProjectDTO){
        //保存用户角色的关系
        if (ptMealService.savePtMealPtProject(ptMealProjectDTO.getPtId(), ptMealProjectDTO.getPtpId())) {
            return Result.ok().message("私教项目分配成功");
        }
        return Result.error().message("私教项目分配失败");
    }

}
