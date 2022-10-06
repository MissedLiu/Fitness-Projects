package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Member;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.ipmlTqw.*;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
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
    @Resource
    private AllotMemberService allotMemberService;
    @Resource
    private AllotProspectService allotProspectService;
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
        if(messageService.allocationMember(memberMessageQueryVo)){
            return Result.ok().message("分配成功");
        }
        return Result.error().message("分配失败");
    }
    //已分配会员查看
    @GetMapping("/findMemberByEmpIds")
    public Result findMemberByEmpIds(Long empId){
        return Result.ok(allotMemberService.findMemberByEmpIds(empId));
    }
    //移除会员分配
    @DeleteMapping("/deleteAllocationMember/{empId}/{memberId}")
    public Result deleteAllocationMember(@PathVariable Long empId,@PathVariable Long memberId){
        if(allotMemberService.deleteAllocationMember(empId,memberId)){
            return Result.ok().message("移除成功");
        }
        return Result.exist().message("移除失败");
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
    //已分配潜在用户查看
    @GetMapping("/findProspectByEmpIds")
    public Result findProspectByEmpIds(Long empId){
        return Result.ok(allotProspectService.findProspectByEmpIds(empId));
    }

    //移除潜在用户分配
    @DeleteMapping("/deleteAllocationProspect/{empId}/{prospectId}")
    public Result deleteAllocationProspect(@PathVariable Long empId,@PathVariable Long prospectId){
        if(allotProspectService.deleteAllocationProspect(empId,prospectId)){
            return Result.ok().message("移除成功");
        }
        return Result.exist().message("移除失败");
    }

}
