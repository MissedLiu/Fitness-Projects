package com.trkj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.Po;
import com.trkj.entity.StockIn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Service
* @createDate 2022-09-23 20:22:01
*/
public interface StockInService extends IService<StockIn> {
    boolean toStock(PoQueryVo poQueryVo);
    IPage <StockIn> findAllStockIn(IPage page, StockInQueryVo stockInQueryVo);
}
