package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.StockOut;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.entity.ouyang.Eeamage;

import org.apache.ibatis.annotations.Select;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Mapper
* @createDate 2022-09-27 10:39:53
* @Entity com.trkj.entity.ouyang.StockOut
*/
public interface StockOutMapper extends BaseMapper<StockOut> {
    /**
     * @description:
     * 修改出库数量
     * @author: Liucz
     * @date: 2022/10/1 20:10
     * @param:
     * @return:
     **/
    int updateOutNumInt(@Param("stockinId") Long id,@Param("outNum") Long outNum,@Param("storeNum") Long storeNum);
    /**
     * @description:
     * 修改商品数量
     * @author: Liucz
     * @date: 2022/10/1 20:10
     * @param:
     * @return:
     **/
    int updateOutNum(@Param("stockinId") Long id,@Param("storeNum") Long storeNum);
    /**
     * @description:
     * 修改商品数量
     * @author: Liucz
     * @date: 2022/10/1 20:10
     * @param:
     * @return:
     **/
    int updateOutNum2(@Param("outId") Long id,@Param("storeNum") Long storeNum);


    /**
     * 通过物品名和品牌获取出库数
     * @param edetails
     * @return
     */
    @Select(value = "select sum(out_num) from stock_out where stockin_name=#{edName} and brand=#{brand}")
    Long getOutNumByNameAndBrand(Edetails edetails);

}




