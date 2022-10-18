package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Lose;
import com.trkj.service.implTqw.LoseService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
*失物招领
*
*/
@RestController
@RequestMapping("/api/lose")
public class LoseController {
    @Resource
    private LoseService loseService;

    /**
     * @title:  查询失物列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:56
    */
    @GetMapping("/selectlose")
    public Result selectLose(LoseQueryVo loseQueryVo){
        return Result.ok(loseService.selectLose(loseQueryVo));
    }

    /**
     * @title:  新增失物
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:57
    */
    @PreAuthorize("hasAuthority('loses:lose:add')")
    @PostMapping("/addlose")
    public Result addLose(@RequestBody Lose lose){
        return Result.ok(loseService.addLose(lose));
    }

    /**
     * @title:  新增领取人，修改失物状态
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:57
    */
    @PreAuthorize("hasAuthority('loses:lose:get')")
    @PostMapping("/updateLoseState")
    public Result updateLoseState(@RequestBody Lose lose){
        int a=loseService.updateLoseState(lose);
        if(a==0){
            return Result.exist().message("物品已领取");
        }else if(a==1){
            return Result.ok().message("物品领取成功");
        }
        return Result.exist().message("领取失败");
    }

    /**
     * @title:  删除
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:35
    */
    @DeleteMapping("/deleteLose/{id}")
    public Result deleteLose(@PathVariable Long id){
        if(loseService.deleteLose(id)){
            return Result.ok().message("删除成功");
        }
        return Result.exist().message("删除失败");
    }
}
