package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.ouyang.StockOutMapper;
import com.trkj.entity.ouyang.StockOut;
import com.trkj.entity.ouyang.Store;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.dao.ouyang.StoreMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StoreQueryVo;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.entity.ouyang.Store;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.dao.ouyang.StoreMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StoreQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Service实现
* @createDate 2022-09-23 20:36:05
*/
@Service
@Transactional
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

    @Resource
    private StoreMapper storeMapper;
@Resource
private StockOutMapper stockOutMapper;
    @Override
    public boolean toStore(PoQueryVo poQueryVo) {
        return storeMapper.toStore(poQueryVo);
    }

    @Override
    public Long CountSameNameAndBrand(PoQueryVo poQueryVo) {
        return storeMapper.CountSameNameAndBrand(poQueryVo);
    }

    @Override
    public Long FindStoreId(PoQueryVo poQueryVo) {
        return storeMapper.FindStoreIdByNameAndBrand(poQueryVo);
    }

    @Override
    public Boolean updateStoreNum(Long stockinNum,Long id, Long storeNum) {
        return storeMapper.updateStoreNum(stockinNum,id,storeNum);
    }




    @Override
    public Long FindStoreNum(PoQueryVo poQueryVo) {
        return storeMapper.FindStoreNum(poQueryVo);
    }

    @Override
    public IPage<Store> findStoreList(IPage<Store> page, StoreQueryVo storeQueryVo) {
        QueryWrapper <Store>queryWrapper=new QueryWrapper();
        queryWrapper.like(!ObjectUtils.isEmpty(storeQueryVo.getStockinName()),
                "stockin_name",storeQueryVo.getStockinName());
        queryWrapper.orderByDesc("stockin_time");
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public long FindStoreNumByID(long id) {
        return storeMapper.FindStoreNumByID(id);
    }

    @Override
    public boolean toOutStock(StoreQueryVo storeQueryVo) {
        //当出库物品名,类型,品牌都相同时,则修改出库数量
        QueryWrapper<StockOut > queryWrapper=new QueryWrapper<>();
        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("stockin_type", storeQueryVo.getStockinType());
        queryParamsMap.put("brand", storeQueryVo.getBrand());
        queryWrapper.allEq(queryParamsMap);
        StockOut stockOut = stockOutMapper.selectOne(queryWrapper);
        System.out.println("stockOut="+stockOut);
        //当查询出结果不为空时,修改出库商品的数量
        if (stockOut!=null){

            StockOut stockOut1=new StockOut();
            stockOut1.setStoreNum(stockOut.getStoreNum()+storeQueryVo.getOutStockNum());
            stockOut1.setOutNum(stockOut.getOutNum()+storeQueryVo.getOutStockNum());
            int i = stockOutMapper.updateOutNumInt(stockOut.getStockinId(), stockOut1.getOutNum(), stockOut1.getStoreNum());
            if (i==1){
                return true;
            }

        }
        return storeMapper.toOutStock(storeQueryVo);
    }

    @Override
    public boolean updateStroeNumChu(StoreQueryVo storeQueryVo) {
        return storeMapper.updateStoreNumChu(storeQueryVo);
    }


    @Override
    public Long getStoreNumByStoreId(StoreQueryVo storeQueryVo) {
        return storeMapper.getStoreNumByStoreId(storeQueryVo);
    }

    @Override
    public Long getPoidByEdetails(Edetails edetails) {
        return storeMapper.getStockinIdByStockinNameAndBrand(edetails);
    }
}




