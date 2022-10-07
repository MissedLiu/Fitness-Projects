package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.service.implLiucz2.InvoiceService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName InvoiceController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/7 14:34
 * @since JDK 8
 **/
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Resource
    private InvoiceService invoiceService;

    @GetMapping("/list")
    public Result getInvoiceList(InvoiceQueryVo invoiceQueryVo) {
        IPage page = new Page(invoiceQueryVo.getPageNo(), invoiceQueryVo.getPageSize());
        invoiceService.getInvoiceList(page, invoiceQueryVo);
        return Result.ok(page);
    }

    @GetMapping("/toSumPrice/{id}")
    public Result toSumPrice(@PathVariable Long id){
        System.out.println("wertyuiop"+id);
        if (!ObjectUtils.isEmpty(id)){
            return Result.ok(invoiceService.SumInvoicePrice(id));
        }return Result.error().message("没有可统计的记录！");
    }
}
