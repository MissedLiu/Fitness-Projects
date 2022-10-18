package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.InvoiceMapper;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.service.implLiucz2.InvoiceService;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
import com.trkj.vo.queryOuyang.CountQueryVo;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service

public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice>
    implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;

    @Override
    public IPage<Invoice> getInvoiceList(IPage page, InvoiceQueryVo invoiceQueryVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        //根据商品名模糊查询
        queryWrapper.like(!ObjectUtils.isEmpty(invoiceQueryVo.getStockinName()),
                "stockin_name",invoiceQueryVo.getStockinName());
        //根据只有年月的时间模糊查询
        queryWrapper.like(!ObjectUtils.isEmpty(invoiceQueryVo.getChangeTime()),
                "create_time", invoiceQueryVo.getChangeTime());
        //根据时间排序
        queryWrapper.orderByDesc("create_time");

        return baseMapper.selectPage(page,queryWrapper);
    }

    /**
     * @description:
     * 生成发票记录
     * @author: Liucz
     * @date: 17:33
     * @param: [salesArticleAndInvoiceVo, id]
     * @return: int
     **/
    @Override
    @Transactional
    public int addInvoice(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo) {
        Invoice invoice=new Invoice();
        invoice.setSalesId(salesArticleAndInvoiceVo.getSalesId());
        invoice.setInvoiceName(salesArticleAndInvoiceVo.getInvoicedName());
        invoice.setStockinName(salesArticleAndInvoiceVo.getStockinName());
        invoice.setStockinNum(salesArticleAndInvoiceVo.getStockInNum());
        invoice.setPrice(salesArticleAndInvoiceVo.getStockInNum()*salesArticleAndInvoiceVo.getSalesPrice());
        invoice.setEmpId(salesArticleAndInvoiceVo.getSaempId());
        Date date=new Date();
        invoice.setCreateTime(date);
        invoice.setBrand(salesArticleAndInvoiceVo.getBrand());
        int insert = invoiceMapper.addInvoice(invoice);
        return insert;
    }
    /**
     * @description:
     * 根据传入的商品记录id查询出发票id并删除
     * @author: Liucz
     * @date: 17:33
     * @param: [salesArticleAndInvoiceVo, id]
     * @return: int
     **/
    @Override
    @Transactional
    public int deleteInvoice(Long id) {
        QueryWrapper<Invoice > queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sales_id" ,id);
        Invoice invoice = baseMapper.selectOne(queryWrapper);
        if (invoice==null){
            return 1;
        }
        int i = baseMapper.deleteById(invoice.getInvoiceId());
        return i;
    }
    /**
     * @description:
     * 修改发票记录表
     * @author: Liucz
     * @date: 2022/10/1 23:16
     * @param:
     * @return:
     **/
    @Transactional
    @Override
    public int updateInvoice(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo) {
        salesArticleAndInvoiceVo.setSalesPrice(salesArticleAndInvoiceVo.getStockInNum()*salesArticleAndInvoiceVo.getSalesPrice());
        int i = invoiceMapper.updateInvoice(salesArticleAndInvoiceVo);
        return i;
    }
    @Transactional
    @Override
    public Long SumInvoicePrice(Long tjType) {
        Long SumPrice = null;
        if (tjType==1){
            SumPrice=invoiceMapper.SumWeekPrice();
        }
        if (tjType==2){
            SumPrice=invoiceMapper.SumMonthPrice();
        }
        if (tjType==3){
            SumPrice=invoiceMapper.SumQuarterPrice();
        }
        if (tjType==4){
            SumPrice=invoiceMapper.SumLastQuarterPrice();
        }
        if (tjType==5){
            SumPrice=invoiceMapper.SumYearPrice();
        }
        return SumPrice;
    }

    @Override
    public List<CountQueryVo> getCountPrice() {
        return invoiceMapper.getCountPrice();
    }

    @Override
    public List<CountQueryVo> getCountPriceYear() {
        return invoiceMapper.getCountPriceYear();
    }

}




