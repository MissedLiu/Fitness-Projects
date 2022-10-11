package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.service.implTqw.CommonMealService;
import com.trkj.service.implTqw.CommonMemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
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
    /*
     *
     *查询普通套餐会员
     *
     */
    @GetMapping("/commentListAll")
    public Result commentListAll(MemberQueryVo memberQueryVo){
        System.out.println(memberQueryVo);
        IPage<MemberQueryVo > commentMember = commonMemberService.findCommentMember(memberQueryVo);
        return Result.ok(commentMember);
    }


    /*
     *
     *新增普通会员
     *
     */
    @PreAuthorize("hasAuthority('members:ptmember:add')")
    @PostMapping("/addCommonMember")
    public Result addCommonMember(@RequestBody MemberQueryVo memberQueryVo){
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
        }
        return Result.error().message("系统错误");
    }

    /*
     *
     *续费
     *
     */
    @PreAuthorize("hasAuthority('members:ptmember:xufei')")
    @PutMapping("/renew")
    public Result RenewCommonMember(@RequestBody MemberQueryVo memberQueryVo){
        int a=commonMemberService.renewCommonMember(memberQueryVo);
         if(a==0){
             return Result.ok().message("续费成功");
         }else if(a==1){
             return Result.exist().message("续费失败，会员以拉黑");
         }else if(a==2){
             return Result.exist().message("续费失败，会员不存在");
         }
         return Result.exist();
    }


    /*
     *
     *通过会员办理套餐表id删除普通会员数据
     *
     */
    @PreAuthorize("hasAuthority('members:ptmember:delete')")
    @DeleteMapping("/delCommonMemberById/{mmId}")
    public Result delCommonMemberById(@PathVariable long mmId){
        if(commonMemberService.delCommonMemberById(mmId)){
            return Result.ok().message("会员套餐删除成功");
        }
        return Result.error().message("会员套餐删除失败");
    }

    /*
     *
     *通过是否禁用查询普通套餐
     *
     */
    @GetMapping("/findCommonMealListByCmis")
    public Result findCommonMealListByCmis(){
        return Result.ok(commonMealService.selectPtMeal());
    }

    /*
     *
     *通过mealId查询普通套餐（详情）
     *
     */
    @PreAuthorize("hasAuthority('members:ptmember:xiangqing')")
    @GetMapping("/findCommenMealByCmId/{cmId}")
    public Result selectCommonMealByMealId(@PathVariable Long cmId){
        System.out.println(cmId);
        return Result.ok(commonMealService.selectCommonMealByMealId(cmId));
    }
}
