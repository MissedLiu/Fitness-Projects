package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.BlackService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo;
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


    /*
    *
    *查询黑名单列表
    *
    */
    @GetMapping("/blackMemberList")
    public Result findBlackMember(MemberAndBlackQueryVo memberAndBlackQueryVo){
        return Result.ok(blackService.findBlackMember(memberAndBlackQueryVo));
    }


    /*
    *
    *移出黑名单
    *
    */
    @PreAuthorize("hasAuthority('members:blacklist:delete')")
    @PutMapping("/outUpdMemberState")
    public Result outUpdMemberState(@RequestBody MemberAndBlackQueryVo memberAndBlackQueryVo){
        if(blackService.outUpdMemberState(memberAndBlackQueryVo.getMemberId(),memberAndBlackQueryVo.getWhy())){
            return Result.ok().message("移出成功");
        }
        return Result.error().message("移出失败");
    }
}
