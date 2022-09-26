package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.StockIn;
import com.trkj.service.StockInService;
import com.trkj.dao.StockInMapper;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Service实现
* @createDate 2022-09-23 20:22:01
*/
@Service
public class StockInServiceImpl extends ServiceImpl<StockInMapper, StockIn>
    implements StockInService{

    @Resource
    private StockInMapper stockInMapper;

    //添加入库记录
    @Override
    public boolean toStock(PoQueryVo poQueryVo) {
        return stockInMapper.toInStock(poQueryVo);
    }

    @Override
    public IPage<StockIn> findAllStockIn(IPage page, StockInQueryVo stockInQueryVo) {
        //创建条件构造器对象
        QueryWrapper<StockIn> queryWrapper = new QueryWrapper<StockIn>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(stockInQueryVo.getInName()),"in_name", stockInQueryVo.getInName());
        //获取store列表
        return  baseMapper.selectPage(page,queryWrapper);
    }


}




