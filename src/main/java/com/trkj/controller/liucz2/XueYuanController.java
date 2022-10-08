package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.service.implLiucz2.XueYuanService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  17:13
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/XueYuan")
public class XueYuanController {
    @Resource
    private XueYuanService xueYuanService;
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @GetMapping("/xueyuanlist")
    public Result xueyuanlist(PageVo pageVo){
        IPage<XueYuanVo> allList = xueYuanService.findAllList(pageVo);
        return Result.ok(allList);
    }
}