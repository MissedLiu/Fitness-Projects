package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.extension.api.R;
import com.trkj.service.implTqw.LockerService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.LockerQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
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
    /**
     * @title:  查询储物柜列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:48
    */
    @GetMapping("/lockerList")
    public Result lockerList(LockerQueryVo lockerQueryVo){
        return Result.ok(lockerService.findLockerList(lockerQueryVo));
    }

    /**
     * @title:  新增储物柜
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:48
    */
    @PreAuthorize("hasAuthority('members:locker:add')")
    @PostMapping("/addLocker")
    public Result addLocker(@RequestBody LockerQueryVo lockerQueryVo){
        int i = lockerService.addLocker(lockerQueryVo.getLockerId());
        if(i==0){
            return Result.ok().message("添加成功");
        }else {
            return Result.error().message("添加失败,储物柜已存在");
        }
    }
    /**
     * @title:  删除储物柜
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:48
    */
    @PreAuthorize("hasAuthority('members:locker:delete')")
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

    /**
     * @title:  修改储物柜
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:48
    */
    @PutMapping("/updateLocker")
    public Result updateLocker(@RequestBody LockerQueryVo lockerQueryVo){
        if(lockerService.updateLocker(lockerQueryVo)){
            return Result.ok().message("成功");
        }
        return Result.error().message("失败");
    }

    /**
     * @title:  储物柜添加会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:49
    */
    @PreAuthorize("hasAuthority('members:locker:addmember')")
    @PostMapping("/addLockerByMemberId")
    public Result addLockerByMemberId(@RequestBody LockerQueryVo lockerQueryVo){
        System.out.println("---------------"+lockerQueryVo);
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

    /**
     * @title:  储物柜移除会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:49
    */
    @PreAuthorize("hasAuthority('members:locker:deletemember')")
    @DeleteMapping("/deleteLockerByMemberId/{memberId}/{lockerId}")
    public Result deleteLockerByMemberId(@PathVariable long memberId,@PathVariable long lockerId){
        if(lockerService.deleteLockerByMemberId(memberId,lockerId)){
            return Result.ok().message("会员移除成功");
        }
        return Result.error().message("会员移除失败");
    }

}
