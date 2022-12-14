package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Healthform;
import com.trkj.service.implLiucz2.HealthformService;
import com.trkj.service.implLiucz2.XueYuanPtService;
import com.trkj.service.implLiucz2.XueYuanTmService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import com.trkj.vo.queryLiucz2.XueYuanTmVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    private XueYuanPtService xueYuanService;
    @Resource
    private XueYuanTmService xueYuanTmService;
    @Resource
    private HealthformService healthformService;

    /**
     * @description: 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @GetMapping("/xueyuanlist")
    public Result xueyuanlist(PageVo pageVo) {
        //判断是私教还是团操
        if (pageVo.getMealType().equals("私教")) {
            IPage<XueYuanPtVo> allList = xueYuanService.findAllList(pageVo);
            return Result.ok(allList);
        } else if (pageVo.getMealType().equals("团操")) {
            IPage<XueYuanTmVo> allList = xueYuanTmService.findAllList(pageVo);
            return Result.ok(allList);
        }

        return Result.error().message("出错啦亲!");

    }
    /**
     * @description: 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @GetMapping("/xueyuanlistAll")
    public Result xueyuanlistAll(PageVo pageVo) {
        //判断是私教还是团操
        if (pageVo.getMealType().equals("私教")) {
            IPage<XueYuanPtVo> allList = xueYuanService.findAllListAll(pageVo);
            return Result.ok(allList);
        } else if (pageVo.getMealType().equals("团操")) {
            IPage<XueYuanTmVo> allList = xueYuanTmService.findAllListAll(pageVo);
            return Result.ok(allList);
        }

        return Result.error().message("出错啦亲!");

    }

    /**
     * @description: 添加体检记录单
     * @author: Liucz
     * @date: 2022/10/8 22:38
     * @param:
     * @return:
     **/

    @PostMapping("/addTiJian")
    public Result addTiJian(@RequestBody Healthform healthform) {
        return Result.ok(healthformService.save(healthform));
    }

    /**
     * @description: 检查该会员是否添加了体检单
     * @author: Liucz
     * @date: 2022/10/8 23:44
     * @param: [id]
     * @return: com.trkj.utils.Result
     **/

    @GetMapping("/checkMemberId/{id}")
    public Result checkMemberId(@PathVariable Long id) {
        //判断当前会员是否已经添加了体检表单
        Healthform healthform1 = healthformService.checkFind(id);
        if (healthform1 != null) {
            return Result.exist().message("该会员已经添加了体检单");
        }
        return Result.ok();
    }

    /**
     * @description: 删除
     * @author: Liucz
     * @date: 2022/10/8 23:53
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('healthForm:healthForm:delete')")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        boolean b = healthformService.removeById(id);
        if (b) {
            return Result.ok().message("记录清除成功");
        }
        return Result.error().message("记录清除失败");
    }
    /**
     * @description:
     * 查询个个教练下的会员数量
     * @author: Liucz
     * @date: 2022/10/10 20:22
     * @param:
     * @return:
     **/
    @GetMapping("/findNumJiaoLian")
    public Result findNumJiaoLian(){
        return Result.ok(xueYuanTmService.findNUm());
    }
    /**
     * @description:
     * 返回统计私教团操人数
     * @author: Liucz
     * @date: 2022/10/12 21:20
     * @param:
     * @return:
     **/
    @GetMapping("/CountTongJi")
    public Result CountTongJi(){
        return Result.ok(xueYuanTmService.CountTongJi());
    }
    /**
     * @description:
     * 统计个个教练下的人数
     * @author: Liucz
     * @date: 2022/10/13 14:30
     * @param:
     * @return:
     **/
    @GetMapping("/findJiaoXueCount")
    public Result findJiaoXueCount(){
        return  Result.ok(xueYuanTmService.findjiaolainNUm());
    }
/**
 * @description:
 * 查询该会员在该教练下办理的私教套餐项目信息
 * @author: Liucz
 * @date: 2022/10/17 9:57
 * @param: [pageVo]
 * @return: com.trkj.utils.Result
 **/
    @GetMapping("/findMealPt")
    public Result findMealPt(PageVo pageVo){
        return  Result.ok(xueYuanService.findAllptMeal(pageVo));
    }
    /**
     * @description:
     * 查询该会员在该教练下办理的团操套餐项目信息
     * @author: Liucz
     * @date: 2022/10/17 9:57
     * @param: [pageVo]
     * @return: com.trkj.utils.Result
     **/
    @GetMapping("/findMealTm")
    public Result findMealTm(PageVo pageVo){
        return  Result.ok(xueYuanTmService.findAllTmMeal(pageVo));
    }
}