package com.trkj.dao;

import com.trkj.entity.StockIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PoQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Mapper
* @createDate 2022-09-23 20:22:01
* @Entity com.trkj.entity.StockIn
*/
public interface StockInMapper extends BaseMapper<StockIn> {
    @Insert(value = "insert into stock_in(po_id,in_name,in_num,in_type,brand)" +
            "VALUES (#{poId},#{poName},#{poNum},#{poType},#{brand})")
    public Boolean toInStock(PoQueryVo poQueryVo);


}




