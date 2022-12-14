package com.trkj.controller.tqw;

import com.trkj.service.implTqw.CallbackMemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/api/callBackMember"))
public class CallBackMemberController {
    @Resource
    private CallbackMemberService callbackMemberService;

    /**
     * @title:  查询列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:34
    */
    @GetMapping("selectCallBackList")
    public Result selectCallBackList(MemberAndCallbackQueryVo memberAndCallbackQueryVo){
        return Result.ok(callbackMemberService.selectCallbackMember(memberAndCallbackQueryVo));
    }

    /**
     * @title:  删除咨询记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:34
    */
    @PreAuthorize("hasAuthority('pay:memberecord:delete')")
    @DeleteMapping("/deleteMemberCord/{callbackId}")
    public Result deleteCounsult(@PathVariable Long callbackId){
        if(callbackMemberService.deleteMemberCord(callbackId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
