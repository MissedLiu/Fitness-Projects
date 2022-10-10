package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.service.ipmlTqw.CompactService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/compact")
public class CompactController {
    @Resource
    private CompactService compactService;
    //分页查询合同签订列表
    @GetMapping("/findCompactList")
    public Result findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo){
        return Result.ok(compactService.findCompactList(compactAndMemberQueryVo));
    }
    //查询会员下办了套餐却没有签订合同的套餐
    @GetMapping("/findMemberMeal")
    public Result findMemberMeal(Member member){
        return Result.ok(compactService.findMemberMeal(member));
    }
    //添加合同数据
    @PreAuthorize("hasAuthority('members:contract:add')")
    @PostMapping("/addCompact")
    public Result addCompact(@RequestBody Compact compact){
        if(compactService.addCompact(compact)){
            return Result.ok().message("记录添加成功");
        }
        return Result.exist().message("记录添加失败");
    }
    //删除记录
    @PreAuthorize("hasAuthority('members:contract:delete')")
    @DeleteMapping("/delDetial/{compactId}")
    public Result delDetial(@PathVariable Long compactId){
        if(compactService.delDetial(compactId)){
            return Result.ok().message("删除成功");
        }
        return Result.exist().message("删除失败");
    }
}
