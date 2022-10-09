package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Locker;
import com.trkj.service.ipmlTqw.BlackService;
import com.trkj.service.ipmlTqw.LockerService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.LockerQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
*储物柜
*
*/
@RestController
@RequestMapping("/api/locker")
public class LockerController {
    @Resource
    private LockerService lockerService;
   //查询储物柜列表（1，所有列表 2，电话参数 3，储物柜状态参数）
    @GetMapping("/lockerList")
    public Result lockerList(LockerQueryVo lockerQueryVo){
        return Result.ok(lockerService.findLockerList(lockerQueryVo));
    }

    //新增储物柜
    @PostMapping("/addLocker")
    public Result addLocker(@RequestBody LockerQueryVo lockerQueryVo){
        int i = lockerService.addLocker(lockerQueryVo.getLockerId());
        if(i==0){
            return Result.ok().message("添加成功");
        }else {
            return Result.error().message("添加失败,储物柜已存在");
        }
    }
    //删除储物柜
    @DeleteMapping("/deleteLocker/{lockerId}")
    public Result deleteLocker(@PathVariable long lockerId){
        int a = lockerService.deleteLocker(lockerId);
        if(a==0){
            return Result.error().message("删除失败");
        }else if(a==1){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败，储物柜下有会员");
    }

    //修改储物柜
    @PutMapping("/updateLocker")
    public Result updateLocker(@RequestBody LockerQueryVo lockerQueryVo){
        if(lockerService.updateLocker(lockerQueryVo)){
            return Result.ok().message("成功");
        }
        return Result.error().message("失败");
    }


    //储物柜添加会员
    @PostMapping("/addLockerByMemberId")
    public Result addLockerByMemberId(@RequestBody LockerQueryVo lockerQueryVo){
        int a = lockerService.addLockerByMemberId(lockerQueryVo);
        if(a==0){
            return Result.error().message("会员已拉黑，无法添加储物柜");
        }else if(a==1){
            return Result.ok().message("添加成功");
        }else if(a==2){
            return Result.error().message("会员不存在");
        }else if(a==3){
            return Result.error().message("电话输入有误");
        }else if(a==4){
            return Result.error().message("姓名输入有误");
        }else if(a==6){
            return Result.exist().message("储物柜已被使用");
        }
        return Result.error().message("系统错误");
    }

    //储物柜移除会员
    @DeleteMapping("/deleteLockerByMemberId/{memberId}/{lockerId}")
    public Result deleteLockerByMemberId(@PathVariable long memberId,@PathVariable long lockerId){
        if(lockerService.deleteLockerByMemberId(memberId,lockerId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }

}
