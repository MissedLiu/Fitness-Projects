package com.trkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.StockIn;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Mapper
* @createDate 2022-09-23 20:22:01
* @Entity com.trkj.entity.StockIn
*/
public interface StockInVoMapper extends BaseMapper<StockIn> {

    IPage<StockInQueryVo> findStockInAllAndLoseOrMore(IPage<StockInQueryVo> page, @Param("query") StockInQueryVo query);
}



