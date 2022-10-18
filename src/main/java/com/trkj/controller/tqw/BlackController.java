package com.trkj.controller.tqw;

import com.trkj.service.implTqw.BlackService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.DisburseAndMemberQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
*黑白名单
*
*/
@RestController
@RequestMapping("/api/black")
public class BlackController {
    @Resource
    private BlackService blackService;

    /**
     * @title:  查询黑名单列表
     * @param: MemberSelectQueryVo
     * @return: null
     * @author 15087
     * @date: 2022/10/15 14:24
    */
    @GetMapping("/blackMemberList")
    public Result findBlackMember(MemberSelectQueryVo memberSelectQueryVo){
        return Result.ok(blackService.findBlackMember(memberSelectQueryVo));
    }

    /**
     * @title:  移出黑名单
     * @param: MemberAndBlackQueryVo
     * @return: null
     * @author 15087
     * @date: 2022/10/15 15:28
    */
    @PreAuthorize("hasAuthority('members:blacklist:delete')")
    @PutMapping("/outUpdMemberState")
    public Result outUpdMemberState(@RequestBody MemberAndBlackQueryVo memberAndBlackQueryVo){
        if(blackService.outUpdMemberState(memberAndBlackQueryVo.getMemberId(),memberAndBlackQueryVo.getWhy())){
            return Result.ok().message("移出成功");
        }
        return Result.error().message("移出失败");
    }

    /**
     * @title:  查询黑名单会员的套餐
     * @param: Long
     * @return:
     * @author 15087
     * @date: 2022/10/15 15:31
    */
    @GetMapping("/findBlackMemberMeal")
    public Result findBlackMemberMeal(Long memberId){
        return Result.ok(blackService.findBlackMemberMeal(memberId));
    }

    /**
     * @title:  退费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/15 15:32
    */
    @PostMapping("/delMemberAllMeal")
    public Result delMemberAllMeal(@RequestBody DisburseAndMemberQueryVo disburseAndMemberQueryVo){
        if(blackService.delMemberAllMeal(disburseAndMemberQueryVo)){
            return Result.ok().message("退费成功");
        }
        return Result.error().message("退费失败");
    }

}
