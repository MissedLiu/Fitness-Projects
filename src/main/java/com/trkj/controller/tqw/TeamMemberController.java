package com.trkj.controller.tqw;

import com.trkj.service.ipmlTqw.*;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
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
    TeamMemberService teamMemberService;
    @Resource
    TeamMealService teamMealService;
    @Resource
    TeamProjectnameService teamProjectnameService;
    @Resource
    PtMemberService ptMemberService;
    /*
     *
     *通过套餐类型查询团操会员
     *
     */
    @GetMapping("/teamMemberList")
    public Result teamListAll(MemberQueryVo memberQueryVo){
        return Result.ok(teamMemberService.findTeamMember(memberQueryVo));
    }

    /*
     *
     *新增团操会员
     *
     */
    @PreAuthorize("hasAuthority('members:tcmember:add')")
    @PostMapping("/addTeamMember")
    public Result addTeamMember(@RequestBody MemberQueryVo memberQueryVo){
        int res=teamMemberService.addTeamMember(memberQueryVo);
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
     *通过会员办理套餐表id删除私教会员套餐表，项目表数据
     *
     */
    @PreAuthorize("hasAuthority('members:tcmember:delete')")
    @DeleteMapping("/delTeamMealById/{mmId}")
    public Result delTeamMealById(@PathVariable long mmId){
        if(ptMemberService.delPtMemberById(mmId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }

    /*
     *
     *续费
     *
     */
    @PreAuthorize("hasAuthority('members:tcmember:xufei')")
    @PutMapping("/renew")
    public Result RenewPtMember(@RequestBody MemberQueryVo memberQueryVo){
        System.out.println("memberQueryVo"+memberQueryVo);
        int a=teamMemberService.renewTeamMember(memberQueryVo);
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
    @PreAuthorize("hasAuthority('members:tcmember:xiangqing')")
    @GetMapping("/selectTeamMealByMealId/{mmId}")
    public Result selectTeamMealByMealId(@PathVariable Long mmId){
        return Result.ok(teamMemberService.selectTeamMealAndEmpByMmId(mmId));
    }
}
