package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.service.implOuyang.DisburseService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName DisburseController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/4 14:45
 * @since JDK 8
 **/
@RestController
@RequestMapping("/api/disburse")
public class DisburseController {

    @Resource
    private DisburseService disburseService;

    /**
     * 获取支出表数据
     * @param disburseQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result getDisburseList(DisburseQueryVo disburseQueryVo) {
        IPage<Edetails> page=new Page(disburseQueryVo.getPageNo(),disburseQueryVo.getPageSize());
        disburseService.getList(page,disburseQueryVo);
        return Result.ok(page);
    }

    /**
     * 用过id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteDisburse(@PathVariable Long id){
        if (disburseService.removeById(id)){
            return Result.ok().message("删除成功");
        }return Result.error().message("删除失败");
    }

}
