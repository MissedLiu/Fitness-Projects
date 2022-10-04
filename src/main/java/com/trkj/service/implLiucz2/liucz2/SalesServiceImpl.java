package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.SalesMapper;
import com.trkj.entity.liucz2.Sales;

import com.trkj.service.implLiucz2.SalesService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales>
    implements SalesService {
    @Resource
    private SalesMapper salesMapper;
    /**
     * @description:
     * 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    @Override
    public IPage<Sales> findAllSalesPage(PageVo pageVo) {
        Page<Sales> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<Sales> allSalesIPage = salesMapper.findAllSalesIPage(page, pageVo);
        return allSalesIPage;
    }

}




