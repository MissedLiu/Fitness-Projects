package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.SalesArticleMapper;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *商品记录实现
 */
@Service
@Transactional
public class SalesArticleServiceImpl extends ServiceImpl<SalesArticleMapper, SalesArticle>
    implements SalesArticleService {
    @Resource
    private SalesArticleMapper salesArticleMapper;
    /**
     * @description:
     * 查询所有商品记录,以及发票记录,按条件动态并分页查询
     * @author: Liucz
     * @date: 2022/10/1 11:23
     * @param: []
     * @return: java.util.List<com.trkj.entity.liucz2.Invoice>
     **/
    @Override
    public IPage<SalesArticle> findInvoiceAndSalesAll(PageVo pageVo) {
        Page<SalesArticle> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<SalesArticle> invoiceAndSalesAll = salesArticleMapper.findInvoiceAndSalesAll(page, pageVo);
        return invoiceAndSalesAll;
    }
    /**
     * @description:
     * 插入商品数据,返回id
     * @author: Liucz
     * @date: 2022/10/1 17:05
     * @param: [salesArticleAndInvoiceVo]
     * @return: int
     **/
    @Override
    public Long addSalesArticle(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo) {
        SalesArticle salesArticle=new SalesArticle();
        salesArticle.setBrand(salesArticleAndInvoiceVo.getBrand());
        salesArticle.setSaempId(salesArticleAndInvoiceVo.getSaempId());
        salesArticle.setSalesPrice(salesArticleAndInvoiceVo.getSalesPrice()*salesArticleAndInvoiceVo.getStockInNum());
        salesArticle.setStockoutId(salesArticleAndInvoiceVo.getOutId());
        salesArticle.setStockinNum(salesArticleAndInvoiceVo.getStockInNum());
        salesArticle.setStockinName(salesArticleAndInvoiceVo.getStockinName());
        int addinsert = salesArticleMapper.addinsert(salesArticle);
        Long saId = salesArticle.getSaId();
        return saId;
    }
    /**
     * @description:
     * 修改商品表中的金额和数量
     * @author: Liucz
     * @date: 2022/10/1 23:04
     * @param: []
     * @return: int
     **/
    @Override
    public int update(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo) {
        //修改
        int i = salesArticleMapper.updateBySaId(salesArticleAndInvoiceVo.getSaId(), salesArticleAndInvoiceVo.getStockInNum(), salesArticleAndInvoiceVo.getStockInNum() * salesArticleAndInvoiceVo.getSalesPrice());
        return i;
    }


    /**
     * @description:
     * 根据商品记录id,查询购买数
     * @author: Liucz
     * @date: 2022/10/2 10:31
     * @param:
     * @return:
     **/
    @Override
    public SalesArticle findstoreNumBySaId(Long saId) {
        QueryWrapper<SalesArticle> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sa_id" ,saId);
        SalesArticle salesArticle = baseMapper.selectOne(queryWrapper);
        return salesArticle;
    }

    @Override
    public IPage<SalesArticle> getAllSa(IPage page,PageVo pageVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("saemp_id",pageVo.getSalesmanId());
        queryWrapper.orderByDesc("sales_time");
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public Long sumPrice(PageVo pageVo) {
        return salesArticleMapper.sumPrice(pageVo);
    }

    @Override
    public Boolean updateState(PageVo pageVo) {
        return salesArticleMapper.updateState(pageVo);
    }


}




