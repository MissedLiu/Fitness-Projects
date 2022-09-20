package com.trkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.Store;
import com.trkj.service.StoreService;
import com.trkj.dao.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author oyzz
* @description 针对表【store(物品库存表)】的数据库操作Service实现
* @createDate 2022-09-20 09:39:45
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{


    @Override
    public Store findById(Integer id) {
        return null;
    }
}




