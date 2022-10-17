package com.trkj.controller.tqw;

import com.trkj.service.implTqw.CallbackProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.ProspectAndCallbackQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/api/callBackProspect"))
public class CallBackProspectController {
    @Resource
    private CallbackProspectService callbackProspectService;
    //查询列表
    @GetMapping("/selectCallBackList")
    public Result selectCallBackList(ProspectAndCallbackQueryVo prospectAndAllotQueryVo){

        return Result.ok(callbackProspectService.selectCallBackList(prospectAndAllotQueryVo));
    }
    //删除咨询记录
    @PreAuthorize("hasAuthority('pay:prospectrecord:delete')")
    @DeleteMapping("/deleteProspectCord/{callbackId}")
    public Result deleteCounsult(@PathVariable Long callbackId){
        if(callbackProspectService.deleteProspectCord(callbackId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
