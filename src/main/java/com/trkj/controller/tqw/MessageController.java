package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Member;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.MessageService;
import com.trkj.service.ipmlTqw.ProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.MemberMessageQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController {
    @Resource
    private EmpService empService;
    @Resource
    private MemberService memberService;
    @Resource
    private MessageService messageService;
    @Resource
    private ProspectService prospectService;
    //查询客服列表
    @GetMapping("/empList")
    public Result empList(EmpQueryVo empQueryVo){
        empQueryVo.setStation("客服");
        return Result.ok(empService.findEmpListByStation(empQueryVo));
    }
    //查询会员状态为0的会员
    @GetMapping("/findMemberByState")
    public Result findMemberByState(){
        return Result.ok(memberService.findMemberByState(0));
    }

    //分配会员
    @PostMapping("/allocationMember")
    public Result allocationMember(@RequestBody MemberMessageQueryVo memberMessageQueryVo){
        System.out.println("empId:"+memberMessageQueryVo);
        if(messageService.allocationMember(memberMessageQueryVo)==true){
            return Result.ok().message("分配成功");
        }
        return Result.error().message("分配失败");
    }

    //查询分配状态为0的潜在用户
    @GetMapping("/findProspectByProspectIs")
    public Result findProspectByProspectIs(){
        return Result.ok(prospectService.findProspectByProspectIs(0));
    }

    //分配潜在用户
    @PostMapping("/allocationProspect")
    public Result allocationProspect(@RequestBody MemberMessageQueryVo memberMessageQueryVo){
        System.out.println("empId:"+memberMessageQueryVo);
        if(messageService.allocationProspect(memberMessageQueryVo)==true){
            return Result.ok().message("分配成功");
        }
        return Result.error().message("分配失败");
    }

}
