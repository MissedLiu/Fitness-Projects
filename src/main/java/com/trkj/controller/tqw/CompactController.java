package com.trkj.controller.tqw;

import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.service.implTqw.CompactService;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/compact")
public class CompactController {
    @Resource
    private CompactService compactService;
    /**
     * @title:  分页查询合同签订列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:52
    */
    @GetMapping("/findCompactList")
    public Result findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo){
        return Result.ok(compactService.findCompactList(compactAndMemberQueryVo));
    }

    /**
     * @title:  查询会员下办了套餐却没有签订合同的套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:53
    */
    @GetMapping("/findMemberMeal")
    public Result findMemberMeal(Member member){
        return Result.ok(compactService.findMemberMeal(member));
    }

    /**
     * @title:  添加合同数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:53
    */
    @PreAuthorize("hasAuthority('members:contract:add')")
    @PostMapping("/addCompact")
    public Result addCompact(@RequestBody @Validated Compact compact){
        if(compactService.addCompact(compact)){
            return Result.ok().message("记录添加成功");
        }
        return Result.exist().message("记录添加失败");
    }

    /**
     * @title:  删除记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:53
    */
    @PreAuthorize("hasAuthority('members:contract:delete')")
    @DeleteMapping("/delDetial/{compactId}")
    public Result delDetial(@PathVariable Long compactId){
        if(compactService.delDetial(compactId)){
            return Result.ok().message("删除成功");
        }
        return Result.exist().message("删除失败");
    }
}
