package com.trkj.controller.liucz2;


import com.trkj.entity.liucz2.Flyer;
import com.trkj.service.implLiucz2.FlyerService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz2.FlyerVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:活动安排
 * @author: Liucz
 * @date: 2022/9/29 19:36
 * @param:
 * @return:
 **/
@RestController
@RequestMapping("/api/flyer")
public class FlyerController {
    @Resource
    private FlyerService flyerService;

    /**
     * @description: 按条件动态分页查询
     * @author: Liucz
     * @date: 2022/9/29 19:34
     * @param: [flyer]
     * @return: com.trkj.utils.Result
     **/
    @GetMapping("/list")
    public Result selectFlyer(FlyerVo flyerVo) {
        return Result.ok(flyerService.selectAllFlyer(flyerVo));
    }

    /**
     * @description:添加
     * @author: Liucz
     * @date: 2022/9/29 19:33
     * @param: [flyer]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:activity:add')")
    @PostMapping("/add")
    public Result addFlyer(@RequestBody Flyer flyer) {
        return Result.ok(flyerService.addFlyer(flyer));
    }

    /**
     * @description:删除
     * @author: Liucz
     * @date: 2022/9/29 19:35
     * @param: [flyerId]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:activity:delete')")
    @DeleteMapping("delete/{flyerId}")
    public Result deleteFlyer(@PathVariable long flyerId) {
        if (flyerService.removeById(flyerId)) {
            return Result.ok().message("删除成功！");
        }
        return Result.error().message("删除失败！");
    }

    /**
     * @description:修改
     * @author: Liucz
     * @date: 2022/9/29 19:35
     * @param: [flyer]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('sellgood:activity:edit')")
    @PutMapping("update")
    public Result updateFlyer(@RequestBody Flyer flyer) {
        System.out.println("====================================" + flyer.getFlyerId());
        if (flyerService.updateById(flyer)) {

            return Result.ok().message("套餐修改成功");
        }
        return Result.error().message("套餐修改失败");
    }
}
