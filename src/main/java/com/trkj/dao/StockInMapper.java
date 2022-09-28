package com.trkj.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.StockIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StockInQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Mapper
* @createDate 2022-09-23 20:22:01
* @Entity com.trkj.entity.StockIn
*/
public interface StockInMapper extends BaseMapper<StockIn> {
    @Insert(value = "insert into stock_in(po_id,in_name,in_num,in_type,brand)" +
            "VALUES (#{poId},#{poName},#{poNum},#{poType},#{brand})")
    Boolean toInStock(PoQueryVo poQueryVo);

}




