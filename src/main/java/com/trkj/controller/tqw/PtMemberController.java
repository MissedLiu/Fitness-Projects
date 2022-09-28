package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.PtMealService;
import com.trkj.service.ipmlTqw.PtProjectnameService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 私教会员 前端控制器
 *
 *
 */
@RestController
@RequestMapping("/api/ptMember")
public class PtMemberController {
    @Resource
    MemberService memberService;
    @Resource
    PtMealService ptMealService;
    @Resource
    PtProjectnameService ptProjectnameService;
    /*
     *
     *通过套餐类型查询私教会员套餐
     *
     */
    @GetMapping("/PtMemberList")
    public Result PtMemberList(){
        String memberType="私教";
        return Result.ok(memberService.findPtMember(memberType));
    }


    /*
     *
     * 通过电话查询私教会员套餐
     *
     */
    @GetMapping("/findPtMemberByPhone")
    public Result findPtMemberByPhone(String memberPhone){
        String mealType="私教";
        return Result.ok(memberService.findPtMemberByPhone(mealType,memberPhone));
    }


    /*
     *
     *新增私教会员
     *
     */
    @PostMapping("/addPtMember")
    public Result addPtMember(@RequestBody MemberQueryVo memberQueryVo){
        memberQueryVo.setMealType("私教");
        System.out.println(memberQueryVo);
        int res=memberService.addPtMember(memberQueryVo);
        if(res==1){
            return Result.ok().message("会员注册成功，套餐添加成功");
        }else if(res==2){
            return Result.ok().message("会员已注册,套餐添加成功");
        }else if(res==3){
            return Result.ok().message("会员已注册,套餐已拥有，续费成功");
        }
        return Result.error().message("会员套餐添加失败");
    }


    /*
     *
     *通过会员办理套餐表id删除私教会员套餐表，项目表数据
     *
     */
    @DeleteMapping("/delPtMealById/{mmId}")
    public Result delPtMealById(@PathVariable long mmId){

        if(memberService.delPtMemberById(mmId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }



    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    @GetMapping("/selectPtMealByPtis")
    public Result selectPtMealByPtis(){
        return Result.ok(ptMealService.selectPtMeal());
    }


    /*
     *
     *通过选择的私教套餐id查询该套餐下的私教套餐列表
     *
     */
    @GetMapping("/ptCoachListByPtId")
    public Result ptCoachListByMealId(long ptId){
        return Result.ok(ptMealService.selectEmpByPtId(ptId));
    }


    /*
     *
     *通过套餐id查询私教项目(项目未禁用)
     *
     */
    @GetMapping("/selectPtProjectByPtId")
    public Result selectPtProjectByPtId(long ptId){
        return Result.ok(ptProjectnameService.selectPtProject(ptId));
    }



    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息(套餐详情)
     *
     */
    @GetMapping("/selectPtMealByMealId/{mmId}")
    public Result selectCommonMealByMealId(@PathVariable Long mmId){
        return Result.ok(memberService.selectPtMealAndEmpByMmId(mmId));
    }
}
