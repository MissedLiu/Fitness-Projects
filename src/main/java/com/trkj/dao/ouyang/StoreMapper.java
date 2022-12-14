package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Store;
import com.trkj.entity.ouyang.Edetails;
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
 * @Entity com.trkj.entity.oy.Store
 */
public interface StoreMapper extends BaseMapper<Store> {
    //入库
    @Insert(value = "insert into store(po_id, stockin_name, stockin_num, store_num, stockin_type, brand)" +
            " VALUES (#{poId},#{poName},#{poNum},#{poNum},#{poType},#{brand})")
    public Boolean toStore(PoQueryVo poQueryVo);

    //查询当前品牌物品的库存记录条数
    @Select(value = "SELECT COUNT(*) FROM store WHERE stockin_name=#{poName} AND brand=#{brand};")
    public Long CountSameNameAndBrand(PoQueryVo poQueryVo);

    //入库时 如果有相同物品 则修改总库存
    @Update(value = "update store set store_num=#{storeNum},stockIn_num=#{stockinNum} where store_id=#{id}")
    public Boolean updateStoreNum(@Param("stockinNum") Long stockinNum, @Param("id") Long id, @Param("storeNum") Long storeNum);

    //通过物品名和品牌获取库存数
    @Select(value = "select store_num from store where stockin_name=#{poName} AND brand=#{brand} ")
    public Long FindStoreNum(PoQueryVo poQueryVo);

    //通过物品名和品牌获取库存id
    @Select(value = "select store_id from store where stockin_name=#{poName} AND brand=#{brand}")
    public Long FindStoreIdByNameAndBrand(PoQueryVo poQueryVo);

    //通过id查询库存数
    @Select(value = "select store_num from store where store_id=#{id}")
    public Long FindStoreNumByID(Long id);

    //出库
    @Insert(value = "insert into stock_out (store_id, stockin_id, stockin_name, store_num, out_num,stockin_type,brand)" +
            " VALUES (#{storeId},#{poId},#{stockinName},#{outStockNum},#{outStockNum},#{stockinType},#{brand})")
    public boolean toOutStock(StoreQueryVo storeQueryVo);

    //出库后修改库中库存
    @Update(value = "update store set store_num=#{storeNum}-#{outStockNum} where store_id=#{storeId}")
    public boolean updateStoreNumChu(StoreQueryVo storeQueryVo);

    //通过ID获取库存数
    @Select(value = "select store_num from store  where store_id=#{storeId}")
    public Long getStoreNumByStoreId(StoreQueryVo StoreQueryVo);

    //通过物品品牌和名字获取物品ID
    @Select(value = "select po_id from store where brand=#{brand} and stockin_name=#{edName}")
    Long getStockinIdByStockinNameAndBrand(Edetails edetails);

    @Select(value = "select count(*) from sys_emp where emp_name=#{empName}")
    Long getEmpByName(StoreQueryVo storeQueryVo);

    @Insert(value = "insert into stock_out_record (store_id, stockin_id, stockin_name,  out_num,stockin_type,brand,emp_name)" +
            " VALUES (#{storeId},#{poId},#{stockinName},#{outStockNum},#{stockinType},#{brand},#{empName})")
    public boolean toOutStockRecord(StoreQueryVo storeQueryVo);
}




