package com.trkj.controller.ouyang;/**
 * @ClassName StockOutRRecordController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/12 10:07
 * @since JDK 8
 **/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.ouyang.StockOutRecordMapper;
import com.trkj.service.implOuyang.StockOutRecordService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.StockOutRecordQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *@ClassName StockOutRRecordController
 *@Description TODO
 *@Author Ouyang
 *@Date 2022/10/12 10:07
 *@Version 1.0
 **/
@RestController
@RequestMapping("/api/outRecord")
public class StockOutRecordController {

    @Resource
    private StockOutRecordService recordService;

    @GetMapping("/list")
    public Result getList(StockOutRecordQueryVo queryVo){
        IPage page=new Page(queryVo.getPageNo(),queryVo.getPageSize());
        return Result.ok(recordService.getList(page,queryVo));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        if (recordService.removeById(id)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
