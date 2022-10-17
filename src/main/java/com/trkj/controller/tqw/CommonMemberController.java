package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.tqw.Member;
import com.trkj.service.implTqw.CommonMealService;
import com.trkj.service.implTqw.CommonMemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 普通会员 前端控制器
 *
 *
 */
@RestController
@RequestMapping("/api/commonMember")
public class CommonMemberController {
    @Resource
    CommonMemberService commonMemberService;
    @Resource
    CommonMealService commonMealService;
   /**
    * @title:  查询普通套餐会员
    * @param: null
    * @return:
    * @author 15087
    * @date: 2022/10/15 17:20
   */
    @GetMapping("/commentListAll")
    public Result commentListAll(MemberQueryVo memberQueryVo){
        IPage<Member> commentMember = commonMemberService.findCommentMember(memberQueryVo);
        return Result.ok(commentMember);
    }

    /**
     * @title:  新增普通会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:16
    */
    @PreAuthorize("hasAuthority('members:ptmember:add')")
    @PostMapping("/addCommonMember")
    public Result addCommonMember(@RequestBody @Validated MemberQueryVo memberQueryVo){
        System.out.println("ssssssssss"+memberQueryVo);
        int res=commonMemberService.addCommonMember(memberQueryVo);
        if(res==0){
            return Result.ok().message("套餐添加成功");
        }else if(res==1){
            return Result.error().message("会员未注册");
        }else if(res==2){
            return Result.error().message("电话号码填写错误");
        }else if(res==3){
            return Result.error().message("姓名填写错误");
        }else if(res==4){
            return Result.error().message("此会员已拉黑");
        }else if(res==5){
            return Result.ok().message("套餐已拥有，续费成功");
        }else if(res==6){
            return Result.error().message("该用户已办理过普通套餐，若想继续办理普通套餐，请先升级为正式会员");
        }
        return Result.error().message("系统错误");
    }

    /**
     * @title:  续费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:17
    */
    @PreAuthorize("hasAuthority('members:ptmember:xufei')")
    @PutMapping("/renew")
    public Result RenewCommonMember(@RequestBody MemberQueryVo memberQueryVo){
        System.out.println("ssssssssss"+memberQueryVo);
        int a=commonMemberService.renewCommonMember(memberQueryVo);
         if(a==0){
             return Result.ok().message("续费成功");
         }else if(a==1){
             return Result.exist().message("续费失败，会员以拉黑");
         }else if(a==2){
             return Result.exist().message("续费失败，会员不存在");
         }else if(a==3){
             return Result.exist().message("续费失败，套餐不存在");
         }
         return Result.exist();
    }


    /**
     * @title:  删除
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:17
    */
    @PreAuthorize("hasAuthority('members:ptmember:delete')")
    @DeleteMapping("/delCommonMemberById/{mmId}")
    public Result delCommonMemberById(@PathVariable long mmId){
        if(commonMemberService.delCommonMemberById(mmId)){
            return Result.ok().message("会员套餐删除成功");
        }
        return Result.error().message("会员套餐删除失败");
    }

    /**
     * @title:  查询普通套餐列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:17
    */
    @GetMapping("/findCommonMealListByCmis")
    public Result findCommonMealListByCmis(){
        return Result.ok(commonMealService.selectPtMeal());
    }


    /**
     * @title:  通过会员id查询办理的普通套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:18
    */
    @GetMapping("/findCommonByMemberId")
    public Result findCommonByMemberId(Long memberId){
        return Result.ok(commonMemberService.findCommonByMemberId(memberId));
    }


}
