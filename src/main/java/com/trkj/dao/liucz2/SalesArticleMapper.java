package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.entity.liucz2.SalesArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.SalesArticle
 */
public interface SalesArticleMapper extends BaseMapper<SalesArticle> {
    /**
     * @description:
     * 查询所有商品记录,以及发票记录
     * @author: Liucz
     * @date: 2022/10/1 11:23
     * @param: []
     * @return: java.util.List<com.trkj.entity.liucz2.Invoice>
     **/
    IPage<SalesArticle> findInvoiceAndSalesAll(Page<SalesArticle> page , @Param("query") PageVo query);
    /**
     * @description:
     * 插入商品数据,返回id
     * @author: Liucz
     * @date: 2022/10/1 17:05
     * @param: [salesArticleAndInvoiceVo]
     * @return: int
     **/
    int  addinsert(SalesArticle salesArticle);
    /**
     * @description:
     * 根据商品记录id修改购买数,和金额
     * @author: Liucz
     * @date: 2022/10/1 23:08
     * @param: []
     * @return: int
     **/
    int updateBySaId(@Param("saId") Long saId, @Param("stockinNum") Long stockinNum,@Param("salesPrice") Long salesPrice);
}




