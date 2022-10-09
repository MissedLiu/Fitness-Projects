package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implLiucz2.SalesArticleService;
import com.trkj.service.implLiucz2.SalesService;
import com.trkj.service.implOuyang.CommissionService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.CommissionQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName CommissionController
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/5 10:43
 * @since JDK 8
 **/
@RestController
@RequestMapping("/api/commission")
public class CommissionController {

    @Resource
    private SalesService salesService;

    @Resource
    private CommissionService commissionService;

    @Resource
    private SalesArticleService salesArticleService;

    /**
     * 获取提及提成表数据
     *
     * @param commissionQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result getList(CommissionQueryVo commissionQueryVo) {
        IPage page = new Page(commissionQueryVo.getPageNo(), commissionQueryVo.getPageSize());
        commissionService.getList(page, commissionQueryVo);
        return Result.ok(page);
    }

    /**
     * 修改提成统计表中的数据
     *
     * @param pageVo
     * @return
     */
    @PostMapping("/updateCommission")
    public Result updateCommission(@RequestBody PageVo pageVo) {
        /*//获取当前时间，并将格式修改成yyyy-MM-dd
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //创建条件构造器
        QueryWrapper queryWrapper = new QueryWrapper();
        //添加条件     库中的最后修改日期=今天的日期
        queryWrapper.select("comm_time").like("comm_time", simpleDateFormat.format(date));
        //库中销售人员id=前台获取的id
        queryWrapper.eq("salesman_id", pageVo.getSalesmanId());
        if (commissionService.count(queryWrapper)>0){
            return Result.exist().message("一天最多统计一次！");
        }*/

        //创建临时变量存储各个套餐类型的总销售价格
        Long allPrice = 0L;
        //调用sumPrice查询总价格 如果不为空则将其赋值给allPrice变量  sumPrice的查询条件为类型type和销售人员id 且状态state需要为1
        if (!ObjectUtils.isEmpty(salesService.sumPrice(pageVo))) {
            allPrice = salesService.sumPrice(pageVo);
        } else {
            //如果状态为1的记录为0
            return Result.exist().message("没有可统计的销售记录");
        }
        //创建临时对象用于存储查询条件和需修改的数据
        Commission commission = new Commission();
        commission.setSalesmanId(pageVo.getSalesmanId());
        Double commPt, commSj, commTc, commSp;
        //判断前端获取的CommRate提成值是否在0-1之间，如果不在，则返回error
        if (pageVo.getCommRate() > 1 || pageVo.getCommRate() < 0) {
            return Result.error().message("请输入正确的提成率（0-1）");
        }
        //看前端需要修改的是什么套餐类型的提成，然后将查询到的当前套餐的总销售值✖前端输入的提成率
        if ("普通".equals(pageVo.getType())) {
            commission.setCommissionPt(allPrice * pageVo.getCommRate());
        }
        if ("私教".equals(pageVo.getType())) {
            commission.setCommissionSj(allPrice * pageVo.getCommRate());
        }
        if ("团操".equals(pageVo.getType())) {
            commission.setCommissionTc(allPrice * pageVo.getCommRate());
        }

        //修改各个提成值
        if (salesService.updateCommissionOne(commission)) {
            commPt = commissionService.getByCommissionPt(commission);
            commSj = commissionService.getByCommissionSj(commission);
            commTc = commissionService.getByCommissionTc(commission);
            commSp = commissionService.getByCommissionSp(commission);
            commission.setCommissionPrice(commPt + commSj + commTc + commSp);
            commissionService.updateCommissionPrice(commission);
            if (salesService.updateSalesState(pageVo)) {
                return Result.ok().message("已成功提交！");
            }
        }
        return Result.error().message("提交失败");
    }

    /**
     * 修改商品提成和总提成
     *
     * @param pageVo
     * @return
     */
    @PostMapping("/updateSpComm")
    public Result updateSpComm(@RequestBody PageVo pageVo) {
        System.out.println("----------------");
        System.out.println(pageVo);
        Long allPrice = 0L;
        //调用sumPrice查询总价格 如果不为空则将其赋值给allPrice变量  sumPrice的查询条件为类型type和销售人员id 且状态state需要为1
        if (!ObjectUtils.isEmpty(salesArticleService.sumPrice(pageVo))) {
            allPrice = salesArticleService.sumPrice(pageVo);
        } else {
            //如果状态为1的记录为0
            return Result.exist().message("没有可统计的销售记录");
        }
        Commission commission = new Commission();
        commission.setSalesmanId(pageVo.getSalesmanId());
        Double commPt, commSj, commTc, commSp;
        //判断前端获取的CommRate提成值是否在0-1之间，如果不在，则返回error
        if (pageVo.getCommRate() > 1 || pageVo.getCommRate() < 0) {
            return Result.error().message("请输入正确的提成率（0-1）");
        }
        commission.setCommissionSp(allPrice * pageVo.getCommRate());
        if (commissionService.updateCommSp(commission)) {
            commPt = commissionService.getByCommissionPt(commission);
            commSj = commissionService.getByCommissionSj(commission);
            commTc = commissionService.getByCommissionTc(commission);
            commSp = commissionService.getByCommissionSp(commission);
            commission.setCommissionPrice(commPt + commSj + commTc + commSp);
            commissionService.updateCommissionPrice(commission);
            if (salesArticleService.updateState(pageVo)) {
                return Result.ok().message("已成功提交！");
            }
        }
        return Result.error().message("提交失败");
    }
}
