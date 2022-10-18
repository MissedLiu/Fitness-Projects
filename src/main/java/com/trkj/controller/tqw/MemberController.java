package com.trkj.controller.tqw;


import com.trkj.entity.tqw.Black;
import com.trkj.entity.tqw.Member;
import com.trkj.service.implTqw.BlackService;
import com.trkj.service.implTqw.MemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 *
 * 会员列表管理
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
     * @title:  查询会员列表（无分页）
     * @param:
     * @return:
     * @author 15087
     * @date: 2022/10/14 11:32
    */
    @GetMapping("/listMemberAllNoPage")
    public Result listAllNoPage(MemberSelectQueryVo memberSelectQueryVo) {
        return Result.ok(memberService.listAllNoPage(memberSelectQueryVo));
    }

    /**
     * @title:  查询会员列表（分页）ok
     * @param: MemberSelectQueryVo
     * @return: null
     * @author 15087
     * @date: 2022/10/14 11:33
    */
    @GetMapping("/listMemberAll")
    public Result listAll(MemberSelectQueryVo memberSelectQueryVo) {
        return Result.ok(memberService.findAllMember(memberSelectQueryVo));
    }

    /**
     * @title:  新增会员ok
     * @param: Member
     * @return: null
     * @author 15087
     * @date: 2022/10/14 11:33
    */
    @PreAuthorize("hasAuthority('members:refinance:add')")
    @PostMapping("/addMember")
    public Result addMember(@RequestBody @Validated Member member){
        if(memberService.addMember(member)){
            return Result.ok().message("注册成功");
        }
        return Result.exist().message("注册失败,会员已注册");
    }

    /**
     * @title:  删除会员ok
     * @param: memberId(会员id)
     * @return: null
     * @author 15087
     * @date: 2022/10/14 11:33
    */
    @PreAuthorize("hasAuthority('members:refinance:delete')")
    @DeleteMapping("/delMemberByMemberId/{memberId}")
    public Result delMemberByMemberId(@PathVariable Long memberId){
        if(memberService.removeMember(memberId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }

    /**
     * @title:  修改会员ok
     * @param: Member
     * @return: null
     * @author 15087
     * @date: 2022/10/14 11:34
    */
    @PreAuthorize("hasAuthority('members:refinance:edit')")
    @PutMapping("/updMemberByMemberPhone")
    public Result updMemberByMemberPhone(@RequestBody Member member){
        int state=memberService.updataMemberByMemberPhone(member);
        if(state==0){
            return Result.exist().message("修改失败，无法从正式会员改为体验会员");
        }else if(state==1){
            return Result.ok().message("修改成功");
        }else if(state==2){
            return Result.exist().message("修改失败,修改的电话已注册");
        }
        return Result.error().message("系统错误");
    }

    /**
     * @title:  加入黑名单
     * @param: Black
     * @return: null
     * @author 15087
     * @date: 2022/10/14 17:03
    */
    @PreAuthorize("hasAuthority('members:refinance:addblack')")
    @PutMapping("/goBlack")
    public Result goBlack(@RequestBody @Validated Black black){
        if(blackService.goBlack(black.getMemberId(),black.getWhy())){
            return Result.ok().message("拉黑成功");
        }
        return Result.error().message("拉黑失败");
    }

    /**
     * @title:  通过会员id查询所有套餐ok
     * @param: Long
     * @return: null
     * @author 15087
     * @date: 2022/10/14 19:12
    */
    @GetMapping("/listMealByMemberId")
    public Result listMealByMemberId(Long memberId){
          return Result.ok( memberService.findMemberMealByMemberId(memberId));
    }

}

