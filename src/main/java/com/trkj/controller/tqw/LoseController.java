package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.extension.api.R;
import com.trkj.entity.tqw.Lose;
import com.trkj.service.ipmlTqw.LockerService;
import com.trkj.service.ipmlTqw.LoseService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.LockerQueryVo;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
*储物柜
*
*/
@RestController
@RequestMapping("/api/lose")
public class LoseController {
    @Resource
    private LoseService loseService;
    //查询失物列表
    @GetMapping("/selectlose")
    public Result selectLose(LoseQueryVo loseQueryVo){
        System.out.println("----------------"+loseQueryVo);
        return Result.ok(loseService.selectLose(loseQueryVo));
    }
    //新增失物
    @PostMapping("/addlose")
    public Result addLose(@RequestBody Lose lose){
        System.out.println("++++++++++++++++++="+lose);
        return Result.ok(loseService.addLose(lose));
    }

    //新增领取人，修改失物状态
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
}
