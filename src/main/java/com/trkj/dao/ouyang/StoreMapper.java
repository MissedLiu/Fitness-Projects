package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StoreQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Mapper
* @createDate 2022-09-23 20:36:05
* @Entity com.trkj.entity.ouyang.Store
*/
public interface StoreMapper extends BaseMapper<Store> {
    @Insert(value = "insert into store(po_id, stockin_name, stockin_num, store_num, stockin_type, brand)" +
            " VALUES (#{poId},#{poName},#{poNum},#{poNum},#{poType},#{brand})")
    public Boolean toStore(PoQueryVo poQueryVo);

    @Select(value = "SELECT COUNT(*) FROM store WHERE stockin_name=#{poName} AND brand=#{brand};")
    public Long CountSameNameAndBrand(PoQueryVo poQueryVo);


    @Update(value = "update store set store_num=#{storeNum},stockIn_num=#{stockinNum} where store_id=#{id}")
    public Boolean updateStoreNum(@Param("stockinNum") Long stockinNum,@Param("id") Long id, @Param("storeNum") Long storeNum);

    @Select(value = "select store_num from store where stockin_name=#{poName} AND brand=#{brand} ")
    public Long FindStoreNum(PoQueryVo poQueryVo);

    @Select(value = "select store_id from store where stockin_name=#{poName} AND brand=#{brand}")
    public Long FindStoreIdByNameAndBrand(PoQueryVo poQueryVo);

    @Select(value = "select store_num from store where store_id=#{id}")
    public Long FindStoreNumByID(Long id);

    @Insert(value = "insert into stock_out (store_id, stockin_id, stockin_name, store_num, out_num,stockin_type,brand)" +
            " VALUES (#{storeId},#{poId},#{stockinName},#{outStockNum},#{outStockNum},#{stockinType},#{brand})")
    public boolean toOutStock(StoreQueryVo storeQueryVo);

    @Update(value ="update store set store_num=#{storeNum}-#{outStockNum} where store_id=#{storeId}")
    public boolean updateStoreNumChu(StoreQueryVo storeQueryVo);

    @Select(value = "select store_num from store  where store_id=#{storeId}")
    public Long getStoreNumByStoreId(StoreQueryVo StoreQueryVo);
}




