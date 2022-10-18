package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.service.implLiucz2.InvoiceService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName InvoiceController
 * @Description 商品收入统计表
 * @Author Ouyang
 * @Date 2022/10/7 14:34
 * @since JDK 8
 **/
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Resource
    private InvoiceService invoiceService;

    /**
     * 获取商品收入数据
     * @param invoiceQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result getInvoiceList(InvoiceQueryVo invoiceQueryVo) {
        IPage page = new Page(invoiceQueryVo.getPageNo(), invoiceQueryVo.getPageSize());
        invoiceService.getInvoiceList(page, invoiceQueryVo);
        return Result.ok(page);
    }

    /**
     * 统计数据
     * @param id
     * @return
     */
    @GetMapping("/toSumPrice/{id}")
    public Result toSumPrice(@PathVariable Long id){
        if (!ObjectUtils.isEmpty(id)){
            return Result.ok(invoiceService.SumInvoicePrice(id));
        }return Result.error().message("没有可统计的记录！");
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteInvocie(@PathVariable Long id){
        if (invoiceService.removeById(id)){
            return Result.ok().message("删除成功");
        }return Result.error().message("删除失败");
    }

    @GetMapping("/CountPrice")
    public Result toCountPrice() {
        return Result.ok(invoiceService.getCountPrice());
    }

    @GetMapping("/CountPriceYear")
    public Result toCountPriceYear() {
        return Result.ok(invoiceService.getCountPriceYear());
    }

}
