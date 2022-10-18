package com.trkj.controller.tqw;

import com.trkj.entity.liucz.Emp;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.implTqw.PtCoachService;
import com.trkj.service.implTqw.TeamCoachService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;
import com.trkj.vo.queryTqw.EmpAndTeamMealQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
*教练管理
*
*/
@RestController
@RequestMapping("/api/coach")
public class CoachController {
    @Resource
    private EmpService empService;
    @Resource
    private PtCoachService ptCoachService;
    @Resource
    private TeamCoachService teamCoachService;
    /**
     * @title:  查询教练列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:10
    */
    @GetMapping("/findCoachList")
    public Result findCoachList(EmpQueryVo empQueryVo){
        empQueryVo.setStation("教练");
        return Result.ok(empService.findEmpListByStation(empQueryVo));
    }

    /**
     * @title:  修改教练
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:11
    */
    @PreAuthorize("hasAuthority('coachs:coach:edit')")
    @PutMapping("/updateEmp")
    public Result updateEmp(@RequestBody @Validated Emp emp){
        return Result.ok(empService.updateById(emp));
    }

    /**
     * @title:  通过员工id查询私教关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:11
    */
    @PreAuthorize("hasAuthority('coachs:coach:sjmeal')")
    @GetMapping("/findPtAndEmp")
    public Result findPtAndEmp(Long empId){
        return Result.ok(ptCoachService.findPtAndEmpByEmpId(empId));
    }

    /**
     * @title:  新增私教套餐教练关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:11
    */
    @PostMapping("addEmpAndPtMeal")
    public Result addEmpAndPtMeal(@RequestBody EmpAndPtMealQueryVo empAndPtMealQueryVo){
        if(ptCoachService.addEmpAndPtMeal(empAndPtMealQueryVo)){
            return Result.ok().message("添加成功");
        }
        return Result.exist().message("添加失败");
    }

    /**
     * @title:  通过员工id查询团操关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:11
    */
    @PreAuthorize("hasAuthority('coachs:coach:tcmeal')")
    @GetMapping("/findTeamAndEmp")
    public Result findTeamAndEmp(Long empId){
        return Result.ok(teamCoachService.findTeamAndEmpByEmpId(empId));
    }

    /**
     * @title:  新增团操套餐教练关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:11
    */
    @PostMapping("addEmpAndTeamMeal")
    public Result addEmpAndTeamMeal(@RequestBody EmpAndTeamMealQueryVo empAndTeamMealQueryVo){
        if(teamCoachService.addEmpAndTeamMeal(empAndTeamMealQueryVo)){
            return Result.ok().message("添加成功");
        }
        return Result.exist().message("添加失败");
    }


}
