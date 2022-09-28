package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.StockOut;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.StockOutQueryVo;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Service
* @createDate 2022-09-27 10:39:53
*/
public interface StockOutService extends IService<StockOut> {
    IPage<StockOut> findStockOut(IPage<StockOut> page,StockOutQueryVo stockOutQueryVo);
}
