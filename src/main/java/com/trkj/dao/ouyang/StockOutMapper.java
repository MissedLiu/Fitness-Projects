package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Edetails;
import com.trkj.entity.ouyang.Eeamage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.ouyang.StockOut;
import org.apache.ibatis.annotations.Select;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Mapper
* @createDate 2022-09-27 10:39:53
* @Entity com.trkj.entity.oy.StockOut
*/
public interface StockOutMapper extends BaseMapper<StockOut> {
    @Select(value = "select count(*) from stock_out where store_id=#{stockinId} and stockin_name=#{edName}")
    Long getStoreIdAndStockinName(Eeamage eeamage);

    @Select(value = "select sum(out_num) from stock_out where stockin_name=#{edName} and brand=#{brand}")
    Long getOutNumByNameAndBrand(Edetails edetails);

}




