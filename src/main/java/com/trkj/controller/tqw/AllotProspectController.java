package com.trkj.controller.tqw;

import com.trkj.entity.tqw.CallbackProspect;
import com.trkj.service.implTqw.AllotProspectService;
import com.trkj.service.implTqw.CallbackProspectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/allotProspect")
public class AllotProspectController {
    @Resource
    private AllotProspectService allotProspectService;
    @Resource
    private CallbackProspectService callbackProspectService;

    /**
     * @title:  查询需要回访潜在用户
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:34
    */
    @GetMapping("/findProspectByEmpId")
    public Result findProspectByEmpId(EmpQueryVo empQueryVo){
        return Result.ok(allotProspectService.findProspectByEmpId(empQueryVo));
    }

    /**
     * @title:  新增潜在用户回访记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:34
    */
    @PreAuthorize("hasAuthority('pay:prospect:payprospect')")
    @PostMapping("/addCallbackProspect")
    public Result addCallbackProspect(@RequestBody CallbackProspect callbackProspect){
        if(callbackProspectService.addCallbackProspect(callbackProspect)){
            return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }
}
