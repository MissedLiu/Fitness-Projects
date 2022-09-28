package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.CommonMealService;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
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
    MemberService memberService;
    @Resource
    CommonMealService commonMealService;
    /*
     *
     *通过套餐类型查询普通会员套餐
     *
     */
    @GetMapping("/commentListAll")
    public Result commentListAll(){
        String memberType="普通";
        return Result.ok(memberService.findCommentMember(memberType));
    }


    /**
     * 通过电话查询会员套餐
     *
     */
    @GetMapping("/findCommentMemberByPhone")
    public Result findCommentMemberByPhone(String memberPhone){
        String mealType="普通";
        return Result.ok(memberService.findCommentMemberByPhone(mealType,memberPhone));
    }


    /*
     *
     *新增普通会员
     *
     */
    @PostMapping("/addCommonMember")
    public Result addCommonMember(@RequestBody MemberQueryVo memberQueryVo){
        memberQueryVo.setMealType("普通");
        int res=memberService.addCommonMember(memberQueryVo);
        if(res==1){
            return Result.ok().message("会员注册成功，套餐添加成功");
        }else if(res==2){
            return Result.ok().message("会员已注册,套餐添加成功");
        }else if(res==3){
            return Result.ok().message("会员已注册,套餐已拥有，续费成功");
        }
        System.out.println(memberQueryVo);
        System.out.println(memberQueryVo.getMealType());
        return Result.error().message("会员套餐添加失败");
    }

    /*
     *
     *通过会员办理套餐表id删除普通会员数据
     *
     */
    @DeleteMapping("/delCommonMemberById/{mmId}")
    public Result delCommonMemberById(@PathVariable long mmId){
        if(memberService.delCommonMemberById(mmId)){
            return Result.ok().message("套餐删除成功");
        }
        return Result.error().message("套餐删除失败");
    }

/******************其他**********************/
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
     *通过mealId查询普通套餐
     *
     */
    @GetMapping("/findCommenMealByCmId/{cmId}")
    public Result selectCommonMealByMealId(@PathVariable Long cmId){
        System.out.println(cmId);
        return Result.ok(commonMealService.selectCommonMealByMealId(cmId));
    }
}
