package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.service.implLiucz2.InvoiceService;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.service.implOuyang.StockOutService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-01  12:00
 * @Description: TODO 商品记录表,发票记录表
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/salesArticle")
public class SalesArticleController {
    @Resource
    private SalesArticleService salesArticleService;
    @Resource
    private InvoiceService invoiceService;
    @Resource
    private StockOutService stockOutService;
    /**
     * @description:
     * 查询所有商品记录,以及发票记录
     * @author: Liucz
     * @date: 2022/10/1 11:23
     * @param: []
     * @return: java.util.List<com.trkj.entity.liucz2.Invoice>
     **/
    @GetMapping("/list")
    public Result findSalesList( PageVo pageVo){
        return Result.ok(salesArticleService.findInvoiceAndSalesAll(pageVo));
    }

    /**
     * 获取商品销售信息
     * @param pageVo
     * @return
     */
    @GetMapping("/saList")
    public Result findsaList(PageVo pageVo){
        IPage page=new Page(pageVo.getPageNo(),pageVo.getPageSize());
        salesArticleService.getAllSa(page,pageVo);
        return Result.ok(page);
    }
    /**
     * 添加商品记录及发票记录
     * @param salesArticleAndInvoiceVo
     * @return
     */
    @PreAuthorize("hasAnyAuthority('sellgood:sellgood:add')")
    @PostMapping("/add")
    public Result add(@RequestBody SalesArticleAndInvoiceVo salesArticleAndInvoiceVo){
        //判断当前购买数是否大于出库总数
        Long stockNum = stockOutService.findStockNum(salesArticleAndInvoiceVo.getOutId());
        if(salesArticleAndInvoiceVo.getStockInNum()>stockNum){
            return Result.error().message("购买数超出商品数量");
        }
        //修改出库商品的商品数量
        int i = stockOutService.updateStockStoerNum(salesArticleAndInvoiceVo.getStockinId(), salesArticleAndInvoiceVo.getStockInNum());
        if (i!=1){
        return Result.error().message("购买失败!");
        }
        //插入商品记录表,返回商品记录id
        Long salesArticle = salesArticleService.addSalesArticle(salesArticleAndInvoiceVo);
        if (salesArticle==null){
           return Result.error().message("购买失败!!");
        }
      //插入发票记录
        salesArticleAndInvoiceVo.setSalesId(salesArticle);
        if(invoiceService.addInvoice(salesArticleAndInvoiceVo)!=1){
            return Result.error().message("购买失败!!!");
        }

        return  Result.ok().message("购买成功");
    }
    /**
     * @description:
     * 删除
     * @author: Liucz
     * @date: 2022/10/1 22:55
     * @param: [id]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:sellgood:delete')")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        if (invoiceService.deleteInvoice(id)!=1){
            return Result.error().message("发票记录删除失败");
        }
        boolean b = salesArticleService.removeById(id);
        if (!b){
            return Result.error().message("发票记录删除成功,商品购买记录删除失败");
        }
        return Result.ok().message("删除成功");
    }
    /**
     * @description:
     * 撤销购买
     * @author: Liucz
     * @date: 2022/10/1 22:55
     * @param: [id]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:sellgood:delete2')")
    @DeleteMapping("/delete2/{id}")
    public Result delete2(@PathVariable Long id){
        //将出库的物品数归还
        //商品记录表的数据
        SalesArticle salesArticle = salesArticleService.findstoreNumBySaId(id);
        //根据出库编号查询出库记录表中的物品数
        Long stockOutNum = stockOutService.findStockNum(salesArticle.getStockoutId());
        int i = stockOutService.updateAddStockStoerNum(salesArticle.getStockoutId(), stockOutNum + salesArticle.getStockinNum());
        if (i!=1){
            return  Result.error().message("撤销购买失败");
        }

        if (invoiceService.deleteInvoice(id)!=1){
            return Result.error().message("发票记录删除失败");
        }
        boolean b = salesArticleService.removeById(id);
        if (!b){
            return Result.error().message("发票记录删除成功,商品购买记录删除失败");
        }
        return Result.ok().message("撤销成功");
    }

}