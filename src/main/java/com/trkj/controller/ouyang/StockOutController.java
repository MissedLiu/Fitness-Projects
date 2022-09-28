package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.StockOut;
import com.trkj.service.implOuyang.StockOutService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.StockOutQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/stockOut")
public class StockOutController {
    @Resource
    private StockOutService stockOutService;

    @GetMapping("/list")
    public Result findPlanList(StockOutQueryVo stockOutQueryVo) {
        //创建分页对象
        IPage<StockOut> page =new Page<>(stockOutQueryVo.getPageNo(),stockOutQueryVo.getPageSize());
        //调用分页查询方法
        stockOutService.findStockOut(page,stockOutQueryVo);

        return Result.ok(page);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteStockOut(@PathVariable Long id){
        if (stockOutService.removeById(id)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败！");

    }
}
