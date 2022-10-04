package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Sales;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;

/**
 *
 */
public interface SalesService extends IService<Sales> {
    /**
     * @description:
     * 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    IPage<Sales> findAllSalesPage(PageVo pageVo);

}
