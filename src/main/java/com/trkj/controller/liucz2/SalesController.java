package com.trkj.controller.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz.User;
import com.trkj.entity.liucz2.Sales;
import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implLiucz.UserService;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.service.implLiucz2.SalesService;
import com.trkj.service.implOuyang.CommissionService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Resource
    private UserService userService;


    /**
     * @description: 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    @GetMapping("/list")
    public Result findAllSalesIpage(PageVo pageVo) {
        System.out.println("?????" + pageVo);
        List<Sales> list = salesService.list();
        Long MbId = 0L, MmId = 0L;
        for (int i = 0; i < list.size(); i++) {
            //判断getMemberIdByNameAndPhone（通过名字电话查询会员id）是否为空
            System.out.println("iiiiiii="+list.get(i).getState());
            if (list.get(i).getState() != 2) {
                System.out.println("sssss="+list.get(i).getState());
                if (!ObjectUtils.isEmpty(salesService.getMemberIdByNameAndPhone(list.get(i)))) {
                    MbId = salesService.getMemberIdByNameAndPhone(list.get(i));
                    //判断getMmIdByMemberIdAndMlId（通过会员id和套餐编号查询套餐办理编号）是否为空
                    if (!ObjectUtils.isEmpty(salesService.getMmIdByMemberIdAndMlId(MbId, list.get(i).getMealId()))) {
                        MmId = salesService.getMmIdByMemberIdAndMlId(MbId, list.get(i).getMealId());
                        if ("普通".equals(list.get(i).getType())) {
                            list.get(i).setState((byte) 1);
                            salesService.updateStateSetOne(list.get(i));
                        }
                        //判断getCpIdByMmIdAndprojectId（通过套餐办理编号和项目编号查询所选项目表编号）是否为空
                        if (!ObjectUtils.isEmpty(salesService.getCpIdByMmIdAndprojectId(MmId, list.get(i).getProjectId()))) {

                            //如果三重判断通过 则修改课程销售状态为1
                            list.get(i).setState((byte) 1);
                            salesService.updateStateSetOne(list.get(i));
                        }
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
    @PreAuthorize("hasAnyAuthority('sellgood:classSell:getMeal')")
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
        //sales.getSalesmanId()账号id
        User userByUserId = userService.findUserEmpByUserId(sales.getSalesmanId());
        Commission commission = salesService.getEmpById(userByUserId.getEmpId());
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
    @PreAuthorize("hasAnyAuthority('sellgood:classSell:delete')")
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
        IPage<Sales> salesPageByTypeAndId = salesService.findSalesPageByTypeAndId(page, pageVo);
        System.out.println("===+" + salesPageByTypeAndId.getRecords());
        return Result.ok(salesPageByTypeAndId);
    }

    /**
     * @description: 查询每个销售的业绩
     * @author: Liucz
     * @date: 2022/10/14 9:30
     * @param:
     * @return:
     **/
    @GetMapping("/findSalesCount")
    public Result findSalesCount() {
        return Result.ok(salesService.findAllCount());
    }
}