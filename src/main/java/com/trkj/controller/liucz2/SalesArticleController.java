package com.trkj.controller.liucz2;

import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.service.implLiucz2.InvoiceService;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.service.implOuyang.StockOutService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
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
        System.out.println("pageVo"+pageVo);
        return Result.ok(salesArticleService.findInvoiceAndSalesAll(pageVo));
    }

    /**
     * 添加商品记录及发票记录
     * @param salesArticleAndInvoiceVo
     * @return
     */
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
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        System.out.println("id==="+id);
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
    @DeleteMapping("/delete2/{id}")
    public Result delete2(@PathVariable Long id){
        System.out.println("id==="+id);
        //将出库的物品数归还
        //商品记录表的数据
        SalesArticle salesArticle = salesArticleService.findstoreNumBySaId(id);
        System.out.println("1111");
        //根据出库编号查询出库记录表中的物品数
        Long stockOutNum = stockOutService.findStockNum(salesArticle.getStockoutId());
        System.out.println("stockOutNum="+stockOutNum);
        System.out.println("salesArticle.getStockinNum()="+salesArticle.getStockinNum());
        System.out.println("222");
        int i = stockOutService.updateAddStockStoerNum(salesArticle.getStockoutId(), stockOutNum + salesArticle.getStockinNum());
        System.out.println("33");
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
//    /**
//     * @description:
//     * 修改
//     * @author: Liucz
//     * @date: 2022/10/1 22:55
//     * @param:
//     * @return:
//     **/
//    @PutMapping("/update")
//    public  Result update(@RequestBody SalesArticleAndInvoiceVo salesArticleAndInvoiceVo){
//        System.out.println("salesArticleAndInvoiceVo=="+salesArticleAndInvoiceVo);
//        //修改时判断
//        //判断当前购买数是否大于出库总数
//        Long stockOutNum = stockOutService.findStockOutNum(salesArticleAndInvoiceVo.getOutId());
//        System.out.println("11111111111");
//        System.out.println("stockOutNum="+stockOutNum);
//        System.out.println("getStockInNum="+salesArticleAndInvoiceVo.getStockInNum());
//
//        if(salesArticleAndInvoiceVo.getStockInNum()>stockOutNum){
//            return Result.error().message("购买数超出商品数量");
//        }
//        System.out.println("22222222222");
//
//        //修改出库商品的商品数量
//        int i = stockOutService.updateStockStoerNum2(salesArticleAndInvoiceVo.getOutId(), salesArticleAndInvoiceVo.getStockInNum());
//        if (i!=1){
//            return Result.error().message("购买失败!");
//        }
//        System.out.println("33333333333");
//        //修改商品记录表的金额
//        int update = salesArticleService.update(salesArticleAndInvoiceVo);
//        System.out.println("4444444444444");
//        //修改发票记录表的购买者和数量
//        int i1 = invoiceService.updateInvoice(salesArticleAndInvoiceVo);
//        System.out.println("555555555");
//        if (update==1 && i1==1){
//            return Result.ok().message("修改成功");
//        }
//
//        return Result.error().message("修改失败");
//    }
}