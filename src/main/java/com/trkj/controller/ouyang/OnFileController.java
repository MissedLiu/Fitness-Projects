package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.OnFile;
import com.trkj.service.implOuyang.OnFileService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.OnFileQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName OnFileController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/12 20:59
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/onFile")
public class OnFileController {

    @Resource
    private OnFileService onFileService;


    @PostMapping("/toFile")
    public Result toFile(@RequestBody OnFileQueryVo onFileQueryVo) {
        //判断前端传入的之中是否有时间 如果没有则提示 请选择需归档的月份
        if (ObjectUtils.isEmpty(onFileQueryVo.getChangeTime())) {
            return Result.exist().message("请选择需归档的月份！");
        }
        //判断归档记录中是否有相同年月相同类型的记录，如果没有就进入下一步判断
        if (ObjectUtils.isEmpty(onFileService.getFileNumByDate(onFileQueryVo)) ||
                onFileService.getFileNumByDate(onFileQueryVo) == 0) {
            Long sumPrice = 0l;
            switch (onFileQueryVo.getOnFileType()) {
                case "支出":
                    sumPrice = onFileService.SumDisbursePrice(onFileQueryVo);
                    break;
                case "套餐收入":
                    sumPrice = onFileService.SumProceedsPrice(onFileQueryVo);
                    break;
                case "商品收入":
                    sumPrice = onFileService.SumInvoicePrice(onFileQueryVo);
                    break;
            }
            if (sumPrice != 0) {
                onFileQueryVo.setSumPrice(sumPrice);
                String date = String.join("-", onFileQueryVo.getChangeTime(), "01");
                onFileQueryVo.setChangeTime(date);
                if (onFileService.toOnFile(onFileQueryVo)){
                    return Result.ok().message("归档成功");
                }
                return Result.error().message("归档失败！");
            }
            return Result.exist().message("该月没有任何支出！");
        }
        return Result.exist().message("该月的支出数据已归档！");
    }

    @GetMapping("/getOnFile")
    public Result getOnFile(PageVo pageVo){
        IPage <OnFile>page=new Page(pageVo.getPageNo(),pageVo.getPageSize());
        onFileService.getOnFile(page,pageVo);
        return Result.ok(page);
    }
}
