package com.trkj.controller;


import com.trkj.service.UserService;
import com.trkj.utils.Result;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 *
 * 账户表 前端控制器
 *
 *
 * @author liucz
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 查询所有账户列表
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll(){
        return Result.ok(userService.list());
    }

}

