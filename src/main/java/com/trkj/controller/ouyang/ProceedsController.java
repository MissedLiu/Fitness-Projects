package com.trkj.controller.ouyang;/**
 * @ClassName ProceedsController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/11 10:13
 * @since JDK 8
 **/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.service.implOuyang.ProceedsService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.ProceedsQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *@ClassName ProceedsController
 *@Description TODO
 *@Author Ouyang
 *@Date 2022/10/11 10:13
 *@Version 1.0
 **/
@RestController
@RequestMapping("/api/proceeds")
public class ProceedsController {

    @Resource
    private ProceedsService proceedsService;

    @GetMapping("/list")
    public Result getList(PageVo pageVo){
        IPage page=new Page(pageVo.getPageNo(),pageVo.getPageSize());
        return Result.ok(proceedsService.getList(page,pageVo));
    }

    //根据时间段统计和套餐类型销售总额
    @GetMapping("/sumPrice")
    public Result getSumPrice(PageVo pageVo) {
        if (!ObjectUtils.isEmpty(pageVo.getTypee())) {
            return Result.ok(proceedsService.sumPrice(pageVo));
        }
        return Result.error().message("请选择统计的时间段！");

    }

    //根据id删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        if (proceedsService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
