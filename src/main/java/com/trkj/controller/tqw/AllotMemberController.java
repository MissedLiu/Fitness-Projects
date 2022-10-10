package com.trkj.controller.tqw;

import com.trkj.entity.tqw.CallbackMember;
import com.trkj.service.ipmlTqw.AllotMemberService;
import com.trkj.service.ipmlTqw.CallbackMemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/allotMember")
public class AllotMemberController {
    @Resource
    private AllotMemberService allotMemberService;
    @Resource
    private CallbackMemberService callbackMemberService;
    //查询需要回访会员
    @GetMapping("/findMemberByEmpId")
    public Result findMemberByEmpId(EmpQueryVo empQueryVo){
        return Result.ok(allotMemberService.findMemberByEmpId(empQueryVo));
    }
    //新增回访记录
    @PreAuthorize("hasAuthority('pay:member:paymember')")
    @PostMapping("/addCallbackMember")
    public Result addCallbackMember(@RequestBody CallbackMember callbackMember){
        if(callbackMemberService.addCallbackMember(callbackMember)){
            return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }
}
