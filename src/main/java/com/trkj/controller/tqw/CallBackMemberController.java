package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.CallbackMemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/api/callBackMember"))
public class CallBackMemberController {
    @Resource
    private CallbackMemberService callbackMemberService;
    //查询列表
    @GetMapping("selectCallBackList")
    private Result selectCallBackList(MemberAndCallbackQueryVo memberAndCallbackQueryVo){
        return Result.ok(callbackMemberService.selectCallbackMember(memberAndCallbackQueryVo));
    }
}
