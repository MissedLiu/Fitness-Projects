package com.trkj.controller.ouyang;

import com.trkj.service.implOuyang.StockInService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.StockInQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/stockIn")
public class stockInController {

    @Resource
    private StockInService stockInService;

    /**
     * 分页获取入库记录
     * @param StockInQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result findPoList(StockInQueryVo StockInQueryVo) {
        return Result.ok(stockInService.findAllStockIn(StockInQueryVo));
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @PreAuthorize("hasAnyAuthority('stores:outStore:delete')")
    @DeleteMapping("/delete/{id}")
    public Result deleteStockIn(@PathVariable Long id){
        if (stockInService.removeById(id)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败！");
    }



}
