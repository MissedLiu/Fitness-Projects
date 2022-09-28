package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.StockOut;
import com.trkj.service.StockOutService;
import com.trkj.dao.StockOutMapper;
import com.trkj.vo.query.StockOutQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Service实现
* @createDate 2022-09-27 10:39:53
*/
@Service
public class StockOutServiceImpl extends ServiceImpl<StockOutMapper, StockOut>
    implements StockOutService{

    @Override
    public IPage<StockOut> findStockOut(IPage<StockOut> page, StockOutQueryVo stockOutQueryVo) {
        //创建条件构造器对象
        QueryWrapper<StockOut> queryWrapper = new QueryWrapper<StockOut>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(stockOutQueryVo.getStockinName()), "stockin_name", stockOutQueryVo.getStockinName());
        //获取store列表
        return baseMapper.selectPage(page, queryWrapper);
    }
}




