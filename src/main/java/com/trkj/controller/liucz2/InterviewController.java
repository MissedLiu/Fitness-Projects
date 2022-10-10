package com.trkj.controller.liucz2;

import com.trkj.entity.liucz2.Interview;
import com.trkj.service.implLiucz2.InterviewService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-09  00:31
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/interview")
public class InterviewController {
    @Resource
    private InterviewService interviewService;
    /**
     * @description:
     * 添加访谈记录
     * @author: Liucz 
     * @date: 2022/10/9 0:32
     * @param: 
     * @return: 
     **/
    @PreAuthorize("hasAnyAuthority('coachs:interview:add')")
    @PostMapping("/addInterview")
    private Result addInterview(@RequestBody Interview interview){
        boolean save = interviewService.save(interview);
        if(save){
            return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }
    /**
     * @description:
     * 分页并且动态查询
     * @author: Liucz
     * @date: 2022/10/9 8:55
     * @param:
     * @return:
     **/
    @GetMapping("/listInterview")
    public  Result listInterview(PageVo pageVo){
        return Result.ok(interviewService.findAllByEmpId(pageVo));
    }
/**
 * @description:
 * 删除
 * @author: Liucz
 * @date: 2022/10/9 9:36
 * @param:
 * @return:
 **/
@PreAuthorize("hasAnyAuthority('coachs:interview:delete')")
@GetMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
    boolean b = interviewService.removeById(id);
    if(b){
        return Result.ok().message("删除成功");
    }
    return Result.error().message("出错啦亲");
}
}