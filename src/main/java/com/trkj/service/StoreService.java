package com.trkj.service;

import com.trkj.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Service
* @createDate 2022-09-20 09:39:45
*/
public interface StoreService extends IService<Store> {
    Store findById(Integer id);
}
