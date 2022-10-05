package com.trkj.controller.tqw;

import com.trkj.dao.tqw.CallbackProspectMapper;
import com.trkj.entity.tqw.CallbackProspect;
import com.trkj.service.ipmlTqw.CallbackMemberService;
import com.trkj.service.ipmlTqw.CallbackProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import com.trkj.vo.queryTqw.ProspectAndAllotQueryVo;
import com.trkj.vo.queryTqw.ProspectAndCallbackQueryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/api/callBackProspect"))
public class CallBackProspectController {
    @Resource
    private CallbackProspectService callbackProspectService;
    //查询列表
    @GetMapping("/selectCallBackList")
    private Result selectCallBackList(ProspectAndCallbackQueryVo prospectAndAllotQueryVo){
        System.out.println("eee="+prospectAndAllotQueryVo);

        return Result.ok(callbackProspectService.selectCallBackList(prospectAndAllotQueryVo));
    }
}
