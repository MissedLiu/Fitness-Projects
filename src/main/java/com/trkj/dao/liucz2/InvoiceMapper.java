package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Invoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryLiucz2.SalesArticleAndInvoiceVo;
import com.trkj.vo.queryOuyang.InvoiceQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.Invoice
 */
public interface InvoiceMapper extends BaseMapper<Invoice> {
    /**
     * @description: 新增发票记录
     * @author: Liucz
     * @date: 2022/10/1 17:49
     * @param: [salesArticleAndInvoiceVo]
     * @return: int
     **/
    int addInvoice(Invoice Invoice);

    /**
     * @description: 修改发票记录表
     * @author: Liucz
     * @date: 2022/10/1 23:16
     * @param:
     * @return:
     **/
    int updateInvoice(SalesArticleAndInvoiceVo salesArticleAndInvoiceVo);

    @Select(value = "SELECT SUM(price) FROM invoice where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(create_time)")
    Long SumWeekPrice();

    @Select(value = "SELECT SUM(price) FROM invoice where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(create_time)")
    Long SumMonthPrice();

    @Select(value = "select SUM(price) from invoice where QUARTER(create_time)=QUARTER(now());")
    Long SumQuarterPrice();

    @Select(value = "select SUM(price) from invoice where QUARTER(create_time)=QUARTER(DATE_SUB(now(),interval 1 QUARTER));")
    Long SumLastQuarterPrice();

    @Select(value = "select SUM(price) from invoice where YEAR(create_time)=YEAR(NOW());")
    Long SumYearPrice();
}




