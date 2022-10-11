package com.trkj.controller.tqw;

import com.trkj.service.implTqw.ComsuneService;
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

    //根据时间段统计和套餐类型销售总额
    @GetMapping("/sumPrice")
    public Result getSumPrice(PageVo pageVo) {
        if (!ObjectUtils.isEmpty(pageVo.getTypee())) {
            return Result.ok(comsuneService.sumPrice(pageVo));
        }
        return Result.error().message("请选择统计的时间段！");

    }

    //根据id删除
    @DeleteMapping("/delete/{id}")
    public Result deleteComsune(@PathVariable Long id) {
        if (comsuneService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
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
