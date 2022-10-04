package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.entity.ouyang.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StoreQueryVo;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Service
* @createDate 2022-09-23 20:36:05
*/
public interface StoreService extends IService<Store> {
    //将物品入库
    boolean toStore(PoQueryVo poQueryVo);
    //统计相同物品名和品牌的物品
    Long CountSameNameAndBrand(PoQueryVo poQueryVo);
    //查询已存在的库存id
    Long FindStoreId(PoQueryVo poQueryVo);
    //通过库存id修改库存条目最后操作时间和库存数
    Boolean updateStoreNum(Long stockinNum,Long id,Long storeNum);
    //查询库存数
    Long FindStoreNum(PoQueryVo poQueryVo);

    //查询库存表
    IPage <Store> findStoreList(IPage <Store>page,StoreQueryVo storeQueryVo);

    //通过库存id查询库存数
    long FindStoreNumByID(long id);

    //出库
    boolean toOutStock(StoreQueryVo storeQueryVo);
    //修改库存
    boolean updateStroeNumChu(StoreQueryVo storeQueryVo);
    //通过id查询库存数
    Long getStoreNumByStoreId(StoreQueryVo storeQueryVo);

    Long getPoidByEdetails(Edetails edetails);
}
