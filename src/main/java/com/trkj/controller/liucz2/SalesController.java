package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
import java.util.List;

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



    /**
     * @description: 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    @GetMapping("/list")
    public Result findAllSalesIpage(PageVo pageVo) {
        List<Sales> list=salesService.list();
        Long MbId = 0L, MmId = 0L;
        for (int i = 0; i < list.size(); i++) {
            //判断getMemberIdByNameAndPhone（通过名字电话查询会员id）是否为空
            if (!ObjectUtils.isEmpty(salesService.getMemberIdByNameAndPhone(list.get(i)))) {
                MbId = salesService.getMemberIdByNameAndPhone(list.get(i));
                //判断getMmIdByMemberIdAndMlId（通过会员id和套餐编号查询套餐办理编号）是否为空
                if (!ObjectUtils.isEmpty(salesService.getMmIdByMemberIdAndMlId(MbId, list.get(i).getMealId()))) {
                    MmId = salesService.getMmIdByMemberIdAndMlId(MbId, list.get(i).getMealId());
                    if ("普通".equals(list.get(i).getType())) {
                        list.get(i).setState((byte) 1);
                        salesService.save(list.get(i));
                    }
                    //判断getCpIdByMmIdAndprojectId（通过套餐办理编号和项目编号查询所选项目表编号）是否为空
                    if (!ObjectUtils.isEmpty(salesService.getCpIdByMmIdAndprojectId(MmId, list.get(i).getProjectId()))) {
                        //如果三重判断通过 则修改课程销售状态为1
                        list.get(i).setState((byte) 1);
                        salesService.updateById(list.get(i));
                    }
                }
            }
        }

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
        Long MbId = 0L, MmId = 0L;
        //判断getMemberIdByNameAndPhone（通过名字电话查询会员id）是否为空
        if (!ObjectUtils.isEmpty(salesService.getMemberIdByNameAndPhone(sales))) {
            MbId = salesService.getMemberIdByNameAndPhone(sales);
            //判断getMmIdByMemberIdAndMlId（通过会员id和套餐编号查询套餐办理编号）是否为空
            if (!ObjectUtils.isEmpty(salesService.getMmIdByMemberIdAndMlId(MbId, sales.getMealId()))) {
                MmId = salesService.getMmIdByMemberIdAndMlId(MbId, sales.getMealId());
                if ("普通".equals(sales.getType())) {
                    sales.setState((byte) 1);
                }
                //判断getCpIdByMmIdAndprojectId（通过套餐办理编号和项目编号查询所选项目表编号）是否为空
                if (!ObjectUtils.isEmpty(salesService.getCpIdByMmIdAndprojectId(MmId, sales.getProjectId()))) {
                    //如果三重判断通过 则修改课程销售状态为1
                    sales.setState((byte) 1);
                }
            }
        }
        System.out.println("sales=" + sales);
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