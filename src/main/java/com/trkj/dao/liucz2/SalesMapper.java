package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Sales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.trkj.entity.liucz2.Sales
 */
public interface SalesMapper extends BaseMapper<Sales> {
/**
 * @description:
 * 动态分页查询
 * @author: Liucz
 * @date: 2022/10/3 14:55
 * @param:
 * @return:
 **/
IPage<Sales> findAllSalesIPage(Page<Sales> page , @Param("query") PageVo query);

}




