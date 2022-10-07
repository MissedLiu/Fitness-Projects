package com.trkj.controller.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.service.ipmlTqw.CommonMealService;
import com.trkj.service.ipmlTqw.CommonMemberService;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.UserQueryVo;
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
     *通过会员办理套餐表id删除普通会员数据
     *
     */
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
     *通过mealId查询普通套餐
     *
     */
    @GetMapping("/findCommenMealByCmId/{cmId}")
    public Result selectCommonMealByMealId(@PathVariable Long cmId){
        System.out.println(cmId);
        return Result.ok(commonMealService.selectCommonMealByMealId(cmId));
    }
}
