package com.trkj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.Po;
import com.trkj.entity.StockIn;
import com.trkj.service.StockInService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/stockIn")
public class stockInController {

    @Resource
    private StockInService stockInService;
    @GetMapping("/list")
    public Result findStockInList(StockInQueryVo stockInQueryVo) {
        //创建分页对象
        IPage<StockIn> page = new Page<StockIn>(stockInQueryVo.getPageNo(), stockInQueryVo.getPageSize());
        //调用分页查询方法
        stockInService.findAllStockIn(page, stockInQueryVo);

        return Result.ok(page);
    }
}
