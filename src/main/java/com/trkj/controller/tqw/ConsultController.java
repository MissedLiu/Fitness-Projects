package com.trkj.controller.tqw;

import com.trkj.entity.tqw.MemberConsult;
import com.trkj.service.ipmlTqw.MemberConsultService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberConsultQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/memberConsult")
public class ConsultController {
    @Resource
    private MemberConsultService memberConsultService;
    //分页查询列表
    @GetMapping("/findMemberConsultList")
    public Result findMemberConsultList(MemberConsultQueryVo memberConsultQueryVo){
        return Result.ok(memberConsultService.selectMemberConsultList(memberConsultQueryVo));
    }

    //新增咨询记录
    @PreAuthorize("hasAuthority('pay:counsult:add')")
    @PostMapping("/addMmeberConsult")
    public Result addMmeberConsult(@RequestBody MemberConsult memberConsult){
       int a= memberConsultService.addMmeberConsult(memberConsult);
       if(a==0){
           return Result.ok().message("记录添加完成");
       }else if(a==1){
           return Result.ok().message("记录添加完成，已添加至潜在用户");
       }else if(a==2){
           return Result.ok().message("记录添加完成，该用户已是会员");
       }
       return Result.error().message("添加失败");
    }
}
