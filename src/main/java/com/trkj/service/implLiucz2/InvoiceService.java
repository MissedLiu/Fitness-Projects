package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Invoice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
import com.trkj.vo.queryOuyang.CountQueryVo;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;

import java.util.List;

/**
 *
 */
public interface InvoiceService extends IService<Invoice> {
    /**
     * 获取商品收入记录
     * @param page
     * @param invoiceQueryVo
     * @return
     */
    IPage<Invoice> getInvoiceList(IPage page, InvoiceQueryVo invoiceQueryVo);
    /**
     * @description:
     * 生成发票记录
     * @author: Liucz
     * @date: 17:33
     * @param: [salesArticleAndInvoiceVo, id]
     * @return: int
     **/
    int addInvoice(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo);
    /**
     * @description:
     * 根据传入的商品记录id查询出发票id并删除
     * @author: Liucz
     * @date: 17:33
     * @param: [salesArticleAndInvoiceVo, id]
     * @return: int
     **/
    int deleteInvoice(Long id);
    /**
     * @description:
     * 修改发票记录表
     * @author: Liucz
     * @date: 2022/10/1 23:16
     * @param:
     * @return:
     **/
    int updateInvoice(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo);


    Long SumInvoicePrice(Long tjType);


    List<CountQueryVo> getCountPrice();

    List<CountQueryVo> getCountPriceYear();
}
