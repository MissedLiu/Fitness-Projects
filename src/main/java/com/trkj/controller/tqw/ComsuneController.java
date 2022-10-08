package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.service.ipmlTqw.ComsuneService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result selectComsuneList(ComsuneQueryVo comsuneQueryVo){
        return Result.ok(comsuneService.selectComsuneList(comsuneQueryVo));
    }

    @GetMapping("/sumPrice")
    public Result getSumPrice(PageVo pageVo){
        if (!ObjectUtils.isEmpty(pageVo.getTypee())){
            return Result.ok(comsuneService.sumPrice(pageVo));
        }return Result.error().message("请选择统计的时间段！");

    }
}
