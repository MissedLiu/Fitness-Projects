package com.trkj.service.implLiucz2;

import com.trkj.entity.liucz2.Invoice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;

import java.util.List;

/**
 *
 */
public interface InvoiceService extends IService<Invoice> {
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
}
