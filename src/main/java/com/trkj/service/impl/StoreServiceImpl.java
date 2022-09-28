package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.Store;
import com.trkj.service.StoreService;
import com.trkj.dao.StoreMapper;
import com.trkj.vo.query.PoQueryVo;
import com.trkj.vo.query.StoreQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Service实现
* @createDate 2022-09-23 20:36:05
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

    @Resource
    private StoreMapper storeMapper;
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

        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public long FindStoreNumByID(long id) {
        return storeMapper.FindStoreNumByID(id);
    }

    @Override
    public boolean toOutStock(StoreQueryVo storeQueryVo) {
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
}




