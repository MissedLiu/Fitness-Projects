package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.StockInVoMapper;
import com.trkj.entity.StockIn;
import com.trkj.service.StockInService;
import com.trkj.dao.StockInMapper;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【stock_in(物品入库表)】的数据库操作Service实现
 * @createDate 2022-09-23 20:22:01
 */
@Service
public class StockInServiceImpl extends ServiceImpl<StockInMapper, StockIn>
        implements StockInService {

    @Resource
    private StockInMapper stockInMapper;

    @Resource
    private StockInVoMapper stockInVoMapper;

    //添加入库记录
    @Override
    public boolean toStock(PoQueryVo poQueryVo) {
        return stockInMapper.toInStock(poQueryVo);
    }

    @Override
    public IPage<StockInQueryVo> findAllStockIn( StockInQueryVo stockInQueryVo) {
        Page<StockInQueryVo> page=new Page<>(stockInQueryVo.getPageNo(),stockInQueryVo.getPageSize());
        return stockInVoMapper.findStockInAllAndLoseOrMore(page,stockInQueryVo);
    }


}




