package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.PtCoach;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.entity.liucz2.TeamCoach;
import com.trkj.service.implLiucz2.PtCoachService;
import com.trkj.service.implLiucz2.TeamCoachService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  11:57
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/souke")
public class soukeController {
    @Resource
    private TeamCoachService teamCoachService;
    @Resource
    private PtCoachService ptCoachService;
    /**
     * @description:
     * 根据教练id查询套餐信息列表
     * @author: Liucz
     * @date: 2022/10/8 12:19
     * @param: [id]
     * @return: com.trkj.utils.Result
     **/
    @GetMapping("/findTeamIdByCoachId")
    public Result findTeamIdByCoachId(PageVo pageVo){
        List<PtMeal> ptIdByCoachId = ptCoachService.findPtIdByCoachId(pageVo);
        return Result.ok(ptIdByCoachId);
    }
}