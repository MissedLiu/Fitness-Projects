package com.trkj.controller.tqw;


import com.trkj.entity.tqw.Member;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.PtProjectnameService;
import com.trkj.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 会员 前端控制器
 *
 *
 */
@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @Resource
    private PtProjectnameService ptProjectnameService;
    /**
     * 查询会员列表OK
     *
     */
    @GetMapping("/listAll")
    public Result listAll() {
        return Result.ok(memberService.list());
    }


    /**
     * 通过电话查询会员信息OK
     *
     */
    @GetMapping("/findMemberByMemberPhone")
    public Result findMemberByMemberPhone(String memberPhone) {
        return Result.ok(memberService.findMemberByMemberPhone(memberPhone));
    }


    /*
     *
     *新增会员ok
     *
     */
    @PostMapping("/addMember")
    public Result addMember(@RequestBody Member member){
        if(memberService.addMember(member)){
            return Result.ok().message("注册成功");
        }
        return Result.error().message("注册失败,会员已注册");
    }


    /*
    *
    *通过会员id删除会员ok
    *
    */
    @DeleteMapping("/delMemberByMemberId/{memberId}")
    public Result delMemberByMemberId(@PathVariable Long memberId){
        if(memberService.delMemberByMemberId(memberId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }


    /*
     *
     *根据电话修改会员
     *
     */
    @PutMapping("/updataMemberByMemberPhone")
    public Result updataMemberByMemberPhone(@RequestBody Member member){
        if(memberService.updataMemberByMemberPhone(member)){
            return Result.ok().message("修改成功");
        }
        return Result.error().message("修改失败");
    }
}

