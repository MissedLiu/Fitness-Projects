package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.StockIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import org.apache.ibatis.annotations.Insert;

/**
* @author oyzz
* @description 针对表【stock_in(物品入库表)】的数据库操作Mapper
* @createDate 2022-09-23 20:22:01
* @Entity com.trkj.entity.ouyang.StockIn
*/
public interface StockInMapper extends BaseMapper<StockIn> {
    @Insert(value = "insert into stock_in(po_id,in_name,in_num,in_type,brand)" +
            "VALUES (#{poId},#{poName},#{poNum},#{poType},#{brand})")
    Boolean toInStock(PoQueryVo poQueryVo);

}




