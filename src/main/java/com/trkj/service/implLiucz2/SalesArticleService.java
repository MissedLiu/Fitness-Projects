package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.entity.liucz2.SalesArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.ouyang.Commission;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;

import java.util.List;

/**
 *
 */
public interface SalesArticleService extends IService<SalesArticle> {
    /**
     * @description:
     * 查询所有商品记录,以及发票记录
     * @author: Liucz
     * @date: 2022/10/1 11:23
     * @param: []
     * @return: java.util.List<com.trkj.entity.liucz2.Invoice>
     **/
    IPage<SalesArticle> findInvoiceAndSalesAll(PageVo pageVo);
    /**
     * @description:
     * 插入商品数据,返回id
     * @author: Liucz
     * @date: 2022/10/1 17:05
     * @param: [salesArticleAndInvoiceVo]
     * @return: int
     **/
    Long addSalesArticle(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo);
     /**
      * @description:
      * 修改商品表中的金额和数量
      * @author: Liucz
      * @date: 2022/10/1 23:04
      * @param: []
      * @return: int
      **/
    int update(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo);
    /**
     * @description:
     * 根据商品记录id,查询购买数
     * @author: Liucz
     * @date: 2022/10/2 10:31
     * @param:
     * @return:
     **/
    SalesArticle findstoreNumBySaId(Long saId);

    /**
     * 获取商品销售记录
     * @param page
     * @param pageVo
     * @return
     */
    IPage<SalesArticle> getAllSa(IPage page,PageVo pageVo);

    Long sumPrice(PageVo pageVo);

    Boolean updateState(PageVo pageVo);
}
