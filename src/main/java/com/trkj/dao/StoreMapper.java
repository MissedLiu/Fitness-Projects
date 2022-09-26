package com.trkj.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trkj.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PoQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Mapper
* @createDate 2022-09-23 20:36:05
* @Entity com.trkj.entity.Store
*/
public interface StoreMapper extends BaseMapper<Store> {
    @Insert(value = "insert into store(po_id, stockin_name, stockin_num, store_num, stockin_type, brand)" +
            " VALUES (#{poId},#{poName},#{poNum},#{poNum},#{poType},#{brand})")
    public Boolean toStore(PoQueryVo poQueryVo);

    @Select(value = "SELECT COUNT(*) FROM store WHERE stockin_name=#{poName} AND brand=#{brand};")
    public Long CountSameNameAndBrand(PoQueryVo poQueryVo);


    @Update(value = "update store set stockin_time=#{date},store_num=#{storeNum} where store_id=#{id}")
    public Boolean updateStoreNum(Date date,Long id,Long storeNum);

    @Select(value = "select sum(store_num) from store where stockin_name=#{poName} AND brand=#{brand}")
    public Long FindStoreNum(PoQueryVo poQueryVo);

    @Select(value = "select store_id from store where stockin_name=#{poName} AND brand=#{brand}")
    public Long FindStoreIdByNameAndBrand(PoQueryVo poQueryVo);
}




