package com.trkj.controller.liucz2;


import com.trkj.entity.liucz2.CommonMeal;
import com.trkj.service.implLiucz2.CommonMealService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @description:普通套餐管理
 * @author: Liucz 
 * @date: 2022/9/30 10:28
 * @param: 
 * @return: 
 **/
@RestController
@RequestMapping("/api/commonMeal")
public class CommonMealController {
    /*普通套餐*/
    @Resource
    private CommonMealService commonMealService;
     /**
      * @description:动态条件查询并分页
      * @author: Liucz
      * @date: 2022/9/30 10:29
      * @param: [commonMeal]
      * @return: com.trkj.utils.Result
      **/
    @GetMapping("/list")
    public Result selectAllCommonMeal(PageVo pageVo){
        return Result.ok(commonMealService.selectAllCommonMeal(pageVo));
    }
    /**
     * @description:动态条件查询并分页,状态为1的数据列表
     * @author: Liucz
     * @date: 2022/9/30 10:29
     * @param: [commonMeal]
     * @return: com.trkj.utils.Result
     **/

    @GetMapping("/listState")
    public Result selectAllCommonMealState(PageVo pageVo){
        System.out.println("pageVo="+pageVo);
        return Result.ok(commonMealService.selectAllCommonMealState(pageVo));
    }
    /*删除*/
    @PreAuthorize("hasAnyAuthority('sellgood:commonMeal:delete')")
    @DeleteMapping("/delete/{cmId}")
    public Result deleteById(@PathVariable Long cmId) {
        if (commonMealService.removeById(cmId)){
            return Result.ok().message("删除成功");
        }
         return Result.ok().message("删除失败");
    }
    /**
     * @description:添加普通套餐
     * @author: Liucz
     * @date: 2022/9/30 14:07
     * @param: [commonMeal]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:commonMeal:add')")
    @PostMapping("/add")
    public Result addCommonMeal(@RequestBody CommonMeal commonMeal){
        System.out.println("commonMeal=="+commonMeal);
        //判断当前输入的套餐名是否存在
        CommonMeal commonMeal1 = commonMealService.checkCommonMeal(commonMeal.getCmName());
        if(commonMeal1 ==null){
            return Result.ok(commonMealService.addCommonMeal(commonMeal));
        }
        return Result.error().message("该套餐名称已经存在");
    }
    /**
     * @description:
     * 修改套餐,判断修改的套餐名称是否存在
     * @author: Liucz
     * @date: 2022/9/30 14:27
     * @param: [commonMeal]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:commonMeal:edit')")
    @PutMapping("/update")
    public Result update(@RequestBody CommonMeal commonMeal) {
        //判断当前修改的套餐名称是否存在
        CommonMeal commonMeal1 = commonMealService.checkCommonMeal(commonMeal.getCmName());

        if(commonMeal1 !=null){
            if (commonMeal.getCmId() != commonMeal1.getCmId()){
                return Result.error().message("该套餐名称已经存在,修改失败");
            }
        }
        if (commonMealService.updateById(commonMeal)) {
            return Result.ok().message("普通套餐修改成功");
        }
        return Result.error().message("普通套餐修改失败");
    }


}
