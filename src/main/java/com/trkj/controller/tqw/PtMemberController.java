package com.trkj.controller.tqw;

import com.trkj.service.implTqw.MemberService;
import com.trkj.service.implTqw.PtMealService;
import com.trkj.service.implTqw.PtMemberService;
import com.trkj.service.implTqw.PtProjectnameService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberQueryVo2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    PtMemberService ptmemberService;
    @Resource
    PtMealService ptMealService;
    @Resource
    PtProjectnameService ptProjectnameService;

    /**
     * @title:  查询私教套餐办理列表（分页）
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/16 16:18
    */
    @GetMapping("/PtMemberList")
    public Result PtMemberList(MemberQueryVo memberQueryVo){
        return Result.ok(ptmemberService.findPtMember(memberQueryVo));
    }

    /*
     *
     *新增私教会员
     *
     */
    @PreAuthorize("hasAuthority('members:sjmember:add')")
    @PostMapping("/addPtMember")
    public Result addPtMember(@RequestBody @Validated MemberQueryVo2 memberQueryVo2){
        int res=ptmemberService.addPtMember(memberQueryVo2);
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
        } else if(res==6){
            return Result.error().message("该用户已办理过私教套餐，若想继续办理私教套餐，请先升级为正式会员");
        }
        return Result.error().message("系统错误");
    }

    /*
     *
     *续费
     *
     */
    @PreAuthorize("hasAuthority('members:sjmember:xufei')")
    @PutMapping("/renew")
    public Result RenewPtMember(@RequestBody MemberQueryVo memberQueryVo){
        int a=ptmemberService.renewPtMember(memberQueryVo);
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
     *通过会员办理套餐表id删除私教会员套餐表，项目表数据
     *
     */
    @PreAuthorize("hasAuthority('members:sjmember:delete')")
    @DeleteMapping("/delPtMealById/{mmId}")
    public Result delPtMealById(@PathVariable long mmId){

        if(ptmemberService.delPtMemberById(mmId)){
            return Result.ok().message("会员套餐删除成功");
        }
        return Result.error().message("会员套餐删除失败");
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
     *通过选择的私教套餐id查询该套餐下的私教教练列表
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



//    /*
//     *
//     *根据所选项目表套餐办理编号查询教练，套餐信息(套餐详情)
//     *
//     */
//    @PreAuthorize("hasAuthority('members:sjmember:xiangqing')")
//    @GetMapping("/selectPtMealByMealId/{mmId}")
//    public Result selectCommonMealByMealId(@PathVariable Long mmId){
//        return Result.ok(ptmemberService.selectPtMealAndEmpByMmId(mmId));
//    }

    /*
     *
     *通过会员id查询办理的私教套餐
     *
     */
    @GetMapping("/findPtByMemberId/{memberId}")
    public Result findPtByMemberId(@PathVariable Long memberId){
        return Result.ok(ptmemberService.findPtByMemberId(memberId));
    }
}
