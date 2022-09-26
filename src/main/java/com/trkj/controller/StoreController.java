package com.trkj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.Schedule;
import com.trkj.entity.Store;
import com.trkj.service.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.query.ScheduleQueryVo;
import com.trkj.vo.query.StoreQueryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @GetMapping("/list")
    public Result findStoreList(StoreQueryVo storeQueryVo) {
        //创建分页对象
        IPage<Store> page =new Page<>(storeQueryVo.getPageNo(),storeQueryVo.getPageSize());
        //调用分页查询方法
        storeService.findStoreList(page,storeQueryVo);

        return Result.ok(page);
    }
}
