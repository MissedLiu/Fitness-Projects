package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Sales;
import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.service.implLiucz2.SalesService;
import com.trkj.service.implOuyang.CommissionService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.attribute.ResolutionSyntax;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.controller.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-03  15:03
 * @Description: TODO
 * @Version: 5.0
 */
@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Resource
    private SalesService salesService;

    @Resource
    private CommissionService commissionService;

    @Resource
    private SalesArticleService salesArticleService;

    /**
     * @description: 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    @GetMapping("/list")
    public Result findAllSalesIpage(PageVo pageVo) {
        return Result.ok(salesService.findAllSalesPage(pageVo));
    }

    /**
     * @description: 添加买课记录
     * @author: Liucz
     * @date: 2022/10/3 17:34
     * @param:
     * @return:
     **/
    @PostMapping("/addSales")
    public Result addSales(@RequestBody Sales sales) {
        System.out.println("sales=" + sales);
        Long MbId = 0L, MmId = 0L;
        //判断getMemberIdByNameAndPhone（通过名字电话查询会员id）是否为空
        if (!ObjectUtils.isEmpty(salesService.getMemberIdByNameAndPhone(sales))) {
            MbId = salesService.getMemberIdByNameAndPhone(sales);
            //判断getMmIdByMemberIdAndMlId（通过会员id和套餐编号查询套餐办理编号）是否为空
            if (!ObjectUtils.isEmpty(salesService.getMmIdByMemberIdAndMlId(MbId, sales.getMealId()))) {
                MmId = salesService.getMmIdByMemberIdAndMlId(MbId, sales.getMealId());
                if (sales.getType() == "普通") {
                    sales.setState((byte) 1);
                }
                //判断getCpIdByMmIdAndprojectId（通过套餐办理编号和项目编号查询所选项目表编号）是否为空
                if (!ObjectUtils.isEmpty(salesService.getCpIdByMmIdAndprojectId(MmId, sales.getProjectId()))) {
                    //如果三重判断通过 则修改课程销售状态为1
                    sales.setState((byte) 1);
                }
            }
        }
        Commission commission = salesService.getEmpById(sales);
        if (salesService.save(sales)) {
            commission.setSalesmanId(sales.getSalesmanId());
            if (salesService.CountEmp(sales) == 0) {
                salesService.toCommission(commission);
            }
            return Result.ok().message("购买成功");
        }
        return Result.error().message("购买失败");
    }

    /**
     * @description: 根据删除
     * @author: Liucz
     * @date: 2022/10/3 23:23
     * @param:
     * @return:
     **/
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        if (salesService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }

    /**
     * 获取课程销售列表
     *
     * @param pageVo
     * @return
     */
    @GetMapping("/getSales")
    public Result getPt(PageVo pageVo) {
        IPage page = new Page(pageVo.getPageNo(), pageVo.getPageSize());
        salesService.findSalesPageByTypeAndId(page, pageVo);
        return Result.ok(page);
    }

}