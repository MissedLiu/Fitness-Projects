package com.trkj.controller.tqw;


import com.trkj.entity.tqw.Member;
import com.trkj.service.ipmlTqw.BlackService;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.PtProjectnameService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo;
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
    private BlackService blackService;
    /**
     * 查询会员列表(phone)无分页
     *
     */
    @GetMapping("/listAllNoPage")
    public Result listAllNoPage(Member member) {
        return Result.ok(memberService.listAllNoPage(member));
    }
    /**
     * 查询会员列表(phone)分页
     *
     */
    @GetMapping("/listAll")
    public Result listAll(MemberQueryVo memberQueryVo) {
        return Result.ok(memberService.findAllMemberByState(memberQueryVo));
    }

    /*
     *
     *新增会员
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
    *通过会员id删除会员
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
        int a=memberService.updataMemberByMemberPhone(member);
        if(a==0){
            return Result.exist().message("修改失败，无法从正式会员改为体验会员");
        }else if(a==1){
            return Result.ok().message("修改成功");
        }else if(a==2){
            return Result.exist().message("修改失败,修改的电话已注册");
        }
        return Result.error().message("系统错误");
    }

    /*
    *
    *加入黑名单
    *
    */
    @PutMapping("/goUpdMemberState")
    public Result goUpdMemberState(@RequestBody MemberAndBlackQueryVo memberAndBlackQueryVo){
        if(blackService.goUpdMemberState(memberAndBlackQueryVo.getMemberId(),memberAndBlackQueryVo.getWhy())){
            return Result.ok().message("拉黑成功");
        }
        return Result.error().message("拉黑失败");
    }


}

