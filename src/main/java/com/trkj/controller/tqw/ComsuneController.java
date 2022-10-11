package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.service.ipmlTqw.ComsuneService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 *
 *消费记录
 *
 */
@RestController
@RequestMapping("/api/Comsune")
public class ComsuneController {
    @Resource
    private ComsuneService comsuneService;

    //查看消费记录（列表，电话查询，）
    @GetMapping("/selectComsuneList")
    public Result selectComsuneList(ComsuneQueryVo comsuneQueryVo) {
        return Result.ok(comsuneService.selectComsuneList(comsuneQueryVo));
    }

    /**
     * @description:
     * 统计套餐消费次数
     * @author: Liucz
     * @date: 2022/10/10 17:10
     * @param:
     * @return:
     **/
    @GetMapping("/findNum")
    public Result findNum(){
        return Result.ok(comsuneService.findNum());
    }
}
