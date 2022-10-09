package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Healthform;
import com.trkj.service.implLiucz2.HealthformService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  23:01
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/healthform")
public class HealthformController {
    @Resource
    private HealthformService healthformService;
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:02
     * @param:
     * @return:
     **/
    @GetMapping("/list")
    public Result listByEmpId( PageVo pageVo){
        IPage<Healthform> allIpage = healthformService.findAllIpage(pageVo);
        return  Result.ok(allIpage);
    }
}