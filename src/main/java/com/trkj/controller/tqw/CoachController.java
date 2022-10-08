package com.trkj.controller.tqw;

import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtCoach;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.ipmlTqw.PtCoachService;
import com.trkj.service.ipmlTqw.TeamCoachService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;
import com.trkj.vo.queryTqw.EmpAndTeamMealQueryVo;
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
    //查询教练列表
    @GetMapping("/findCoachList")
    public Result findCoachList(EmpQueryVo empQueryVo){
        empQueryVo.setStation("教练");
        return Result.ok(empService.findEmpListByStation(empQueryVo));
    }
    //修改教练
    @PutMapping("/updateEmp")
    public Result updateEmp(@RequestBody Emp emp){
        return Result.ok(empService.updateById(emp));
    }

    //通过员工id查询私教关系表数据
    @GetMapping("/findPtAndEmp")
    public Result findPtAndEmp(Long empId){
        return Result.ok(ptCoachService.findPtAndEmpByEmpId(empId));
    }
    //新增私教套餐教练关系表数据
    @PostMapping("addEmpAndPtMeal")
    public Result addEmpAndPtMeal(@RequestBody EmpAndPtMealQueryVo empAndPtMealQueryVo){
        if(ptCoachService.addEmpAndPtMeal(empAndPtMealQueryVo)){
            return Result.ok().message("添加成功");
        }
        return Result.exist().message("添加失败");
    }

    //通过员工id查询团操关系表数据
    @GetMapping("/findTeamAndEmp")
    public Result findTeamAndEmp(Long empId){
        return Result.ok(teamCoachService.findTeamAndEmpByEmpId(empId));
    }
    //新增团操套餐教练关系表数据
    @PostMapping("addEmpAndTeamMeal")
    public Result addEmpAndTeamMeal(@RequestBody EmpAndTeamMealQueryVo empAndTeamMealQueryVo){
        if(teamCoachService.addEmpAndTeamMeal(empAndTeamMealQueryVo)){
            return Result.ok().message("添加成功");
        }
        return Result.exist().message("添加失败");
    }


}
