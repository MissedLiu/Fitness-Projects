package com.trkj.controller;

import com.trkj.service.ChangenumService;
import com.trkj.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/changeNum")
public class ChangeNumController {
    @Resource
    private ChangenumService changenumService;
    @GetMapping("/list")
    public Result findLoseOrMore(Long id){
        return Result.ok(changenumService.getChangeNumById(id));
    }
}
