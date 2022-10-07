package com.trkj.controller.tqw;

import com.trkj.entity.liucz.Emp;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
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


}
