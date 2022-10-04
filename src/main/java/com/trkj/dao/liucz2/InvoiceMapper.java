package com.trkj.dao.liucz2;

import com.trkj.entity.liucz2.Invoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.Invoice
 */
public interface InvoiceMapper extends BaseMapper<Invoice> {
    /**
     * @description:
     * 新增发票记录
     * @author: Liucz
     * @date: 2022/10/1 17:49
     * @param: [salesArticleAndInvoiceVo]
     * @return: int
     **/
  int addInvoice(Invoice Invoice);
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




