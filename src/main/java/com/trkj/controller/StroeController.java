package com.trkj.controller;

import com.trkj.entity.Store;
import com.trkj.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StroeController {

    @Resource
    private StoreService service;

    @GetMapping("/getId")
    public Store getbyId(){
        System.out.println(service.findById(1));
        return service.findById(1);
    }
}
