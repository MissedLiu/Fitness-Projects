package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.service.ipmlTqw.TeamMealService;
import com.trkj.service.ipmlTqw.TeamProjectnameService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 团操会员 前端控制器
 *
 *
 */
@RestController
@RequestMapping("/api/teamMember")
public class TeamMemberController {
    @Resource
    MemberService memberService;
    @Resource
    TeamMealService teamMealService;
    @Resource
    TeamProjectnameService teamProjectnameService;
    /*
     *
     *通过套餐类型查询团操会员
     *
     */
    @GetMapping("/teamMemberList")
    public Result teamListAll(){
        String memberType="团操";
        return Result.ok(memberService.findTeamMember(memberType));
    }


    /*
     *
     * 通过电话查询团操会员套餐
     *
     */
    @GetMapping("/findTeamMemberByPhone")
    public Result findTeamMemberByPhone(String memberPhone){
        String mealType="团操";
        return Result.ok(memberService.findTeamMemberByPhone(mealType,memberPhone));
    }


    /*
     *
     *新增团操会员
     *
     */
    @PostMapping("/addTeamMember")
    public Result addTeamMember(@RequestBody MemberQueryVo memberQueryVo){
        memberQueryVo.setMealType("团操");
        int res=memberService.addTeamMember(memberQueryVo);
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
    @DeleteMapping("/delTeamMealById/{mmId}")
    public Result delTeamMealById(@PathVariable long mmId){
        if(memberService.delPtMemberById(mmId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }


    /*
     *
     *通过是否禁用查询团操套餐
     *
     */
    @GetMapping("/selectTeamMealByTeamis")
    public Result selectTeamMealByTeamis(){
        return Result.ok(teamMealService.selectTeamMeal());
    }


    /*
     *
     *通过选择的团操套餐id查询该套餐下的私教教练列表
     *
     */
    @GetMapping("/teamCoachListByTeamId")
    public Result teamCoachListByTeamId(long mealId){
        return Result.ok(teamMealService.selectEmpByTeamId(mealId));
    }


    /*
     *
     *通过团操套餐id查询私教项目(项目未禁用)
     *
     */
    @GetMapping("/selectTeamProjectByPtId")
    public Result selectTeamProjectByPtId(long mealId){
        return Result.ok(teamProjectnameService.selectTeamProject(mealId));
    }


    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息(套餐详情)
     *
     */
    @GetMapping("/selectTeamMealByMealId/{mmId}")
    public Result selectTeamMealByMealId(@PathVariable Long mmId){
        return Result.ok(memberService.selectTeamMealAndEmpByMmId(mmId));
    }
}
