package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.StockOut;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.StockOutQueryVo;

import com.trkj.entity.ouyang.Edetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.ouyang.StockOut;
import com.trkj.vo.queryOuyang.StockOutQueryVo;

import java.util.List;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Service
* @createDate 2022-09-27 10:39:53
*/
public interface StockOutService extends IService<StockOut> {
    IPage<StockOut> findStockOut(IPage<StockOut> page,StockOutQueryVo stockOutQueryVo);
    /**
     * @description:
     * 查询出库数
     * @author: Liucz
     * @date: 2022/10/1 19:36
     * @param:
     * @return:
     **/
    Long findStockOutNum(Long id);
    /**
     * @description:
     * 修改商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    int updateStockStoerNum(Long stockinId ,Long storeNum);
    /**
     * @description:
     * 修改商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    int updateStockStoerNum2(Long outId ,Long storeNum);
    /**
     * @description:
     * 归还已购的商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    int updateAddStockStoerNum(Long outId ,Long storeNum);
    /**
     * @description:
     * 查询物品数
     * @author: Liucz
     * @date: 2022/10/1 19:36
     * @param:
     * @return:
     **/
    Long findStockNum(Long id);
    Long getOutNum(Edetails edetails);
}
