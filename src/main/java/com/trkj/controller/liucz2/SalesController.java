package com.trkj.controller.liucz2;

import com.trkj.entity.liucz2.Sales;
import com.trkj.service.implLiucz2.SalesService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-03  15:03
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/sales")
public class SalesController {
   @Resource
    private SalesService salesService;
    /**
     * @description:
     * 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
   @GetMapping("/list")
    public Result findAllSalesIpage(PageVo pageVo){
       return  Result.ok(salesService.findAllSalesPage(pageVo));
   }
   /**
    * @description:
    * 添加买课记录
    * @author: Liucz
    * @date: 2022/10/3 17:34
    * @param:
    * @return:
    **/
   @PostMapping("/addSales")
    public Result addSales(@RequestBody Sales sales){
       System.out.println("sales="+sales);
      if ( salesService.save(sales)){
          return Result.ok().message("购买成功");
      }
       return Result.error().message("购买失败");
   }
   /**
    * @description:
    * 根据删除
    * @author: Liucz
    * @date: 2022/10/3 23:23
    * @param:
    * @return:
    **/
   @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
       if (salesService.removeById(id)){
           return Result.ok().message("删除成功");
       }
       return Result.error().message("删除失败");
   }
}