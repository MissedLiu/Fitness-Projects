package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.dto.CaiGouShenHeDTO;
import com.trkj.entity.ouyang.StockIn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StockInQueryVo;

/**
 * @author oyzz
 * @description 针对表【stock_in(物品入库表)】的数据库操作Service
 * @createDate 2022-09-23 20:22:01
 */
public interface StockInService extends IService<StockIn> {
    // 添加入库记录
    boolean toStock(PoQueryVo poQueryVo);

    //分页查询入库记录
    IPage<StockInQueryVo> findAllStockIn(StockInQueryVo stockInQueryVo);

}
