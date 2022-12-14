package com.trkj.controller.tqw;

import com.trkj.service.implTqw.*;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    /**
     * @title:  查询团操会员(分页)
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 9:01
    */
    @GetMapping("/teamMemberList")
    public Result teamListAll(MemberQueryVo memberQueryVo){
        return Result.ok(teamMemberService.findTeamMember(memberQueryVo));
    }

    /**
     * @title:  新增团操会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:24
    */
    @PreAuthorize("hasAuthority('members:tcmember:add')")
    @PostMapping("/addTeamMember")
    public Result addTeamMember(@RequestBody  @Validated MemberQueryVo2 memberQueryVo2){
        int res=teamMemberService.addTeamMember(memberQueryVo2);
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
            return Result.error().message("该用户已办理过团操套餐，若想继续办理团操套餐，请先升级为正式会员");
        }
        return Result.error().message("系统错误");
    }

    /**
     * @title:  通过会员办理套餐表id删除私教会员套餐表，项目表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:24
    */
    @PreAuthorize("hasAuthority('members:tcmember:delete')")
    @DeleteMapping("/delTeamMealById/{mmId}")
    public Result delTeamMealById(@PathVariable long mmId){
        if(ptMemberService.delPtMemberById(mmId)){
            return Result.ok().message("会员删除成功");
        }
        return Result.error().message("会员删除失败");
    }

    /**
     * @title:  续费
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:25
    */
    @PreAuthorize("hasAuthority('members:tcmember:xufei')")
    @PutMapping("/renew")
    public Result RenewPtMember(@RequestBody MemberQueryVo memberQueryVo){
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

    /**
     * @title:  通过是否禁用查询团操套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:26
    */
    @GetMapping("/selectTeamMealByTeamis")
    public Result selectTeamMealByTeamis(){
        return Result.ok(teamMealService.selectTeamMeal());
    }

    /**
     * @title:  通过选择的团操套餐id查询该套餐下的私教教练列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:26
    */
    @GetMapping("/teamCoachListByTeamId")
    public Result teamCoachListByTeamId(long mealId){
        return Result.ok(teamMealService.selectEmpByTeamId(mealId));
    }

    /**
     * @title:  通过团操套餐id查询私教项目(项目未禁用)
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:26
    */
    @GetMapping("/selectTeamProjectByPtId")
    public Result selectTeamProjectByPtId(long mealId){
        return Result.ok(teamProjectnameService.selectTeamProject(mealId));
    }

    /**
     * @title:  通过会员id查询办理的私教套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:26
    */
    @GetMapping("/findTeamByMemberId/{memberId}")
    public Result findTeamByMemberId(@PathVariable Long memberId){
        return Result.ok(teamMemberService.findTeamByMemberId(memberId));
    }
}
