package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.trkj.dao.liucz2.SalesMapper;
import com.trkj.entity.liucz2.Sales;

import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implLiucz2.SalesService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.CountEmpVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales>
    implements SalesService {
    @Resource
    private SalesMapper salesMapper;


    /**
     * @description:
     * 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    @Override
    public IPage<Sales> findAllSalesPage(PageVo pageVo) {
        List<Sales> salesList=salesMapper.findAllSales();
        Long MbId, MmId;
        //判断getMemberIdByNameAndPhone（通过名字电话查询会员id）是否为空
        for (int i=0;i<salesList.size();i++){
            if (!ObjectUtils.isEmpty(salesMapper.getMemberIdByNameAndPhone(salesList.get(i)))) {
                MbId = salesMapper.getMemberIdByNameAndPhone(salesList.get(i));
                System.out.println("会员存在");
                //判断getMmIdByMemberIdAndMlId（通过会员id和套餐编号查询套餐办理编号）是否为空
                if (!ObjectUtils.isEmpty(salesMapper.getMmIdByMemberIdAndMlId(MbId, salesList.get(i).getMealId()))) {
                    System.out.println("已办理套餐");
                    MmId = salesMapper.getMmIdByMemberIdAndMlId(MbId, salesList.get(i).getMealId());
                    if (salesList.get(i).getType()=="普通"){
                        salesList.get(i).setState((byte) 1);
                        baseMapper.updateById(salesList.get(i));
                    }
                    //判断getCpIdByMmIdAndprojectId（通过套餐办理编号和项目编号查询所选项目表编号）是否为空
                    if (!ObjectUtils.isEmpty(salesMapper.getCpIdByMmIdAndprojectId(MmId, salesList.get(i).getProjectId()))) {
                        System.out.println("已有项目");
                        //如果三重判断通过 则修改课程销售状态为1
                        salesList.get(i).setState((byte) 1);
                        baseMapper.updateById(salesList.get(i));
                    }
                }
            }
        }
        Page<Sales> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<Sales> allSalesIPage = salesMapper.findAllSalesIPage(page, pageVo);

        return allSalesIPage;
    }

    @Override
    public Long getMemberIdByNameAndPhone(Sales sales) {
        return salesMapper.getMemberIdByNameAndPhone(sales);
    }

    @Override
    public Long getMmIdByMemberIdAndMlId(Long MbId, Long MlId) {
        return salesMapper.getMmIdByMemberIdAndMlId(MbId, MlId);
    }

    @Override
    public Long getCpIdByMmIdAndprojectId(Long MmId, Long PjId) {
        return salesMapper.getCpIdByMmIdAndprojectId(MmId, PjId);
    }

    @Override
    public Commission getEmpById(Sales sales) {
        return salesMapper.getEmpById(sales);
    }

    @Override
    public boolean toCommission(Commission commission) {
        return salesMapper.toCommission(commission);
    }

    @Override
    public Long CountEmp(Sales sales) {
        return salesMapper.CountEmp(sales);
    }

    @Override
    public IPage<Sales> findSalesPageByTypeAndId(IPage page,PageVo pageVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("salesman_id",pageVo.getSalesmanId());
        queryWrapper.eq("type",pageVo.getType());
        queryWrapper.in("state", 1,2);
        queryWrapper.orderByDesc("sales_time");
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public Long sumPrice(PageVo pageVo) {
        return salesMapper.sumPrice(pageVo);
    }


    @Override
    public boolean updateCommissionOne(Commission commission) {
        return salesMapper.updateCommission(commission);
    }

    @Override
    public boolean updateSalesState(PageVo pageVo) {
        return salesMapper.updateState(pageVo);
    }
    /**
     * @description:
     * 查询每个销售的业绩
     * @author: Liucz
     * @date: 2022/10/14 9:30
     * @param:
     * @return:
     **/
    @Override
    public List<CountEmpVo> findAllCount() {
        List<CountEmpVo> allCount = salesMapper.findAllCount();
        return allCount;
    }

    /**
     * 刷新页面时重新查询会员表、消费记录表、如果在这些表中存在了该会员的信息 则修改其状态为1（已购买）
     * @param sales
     * @return
     */
    @Override
    public boolean updateStateSetOne(Sales sales) {
        return salesMapper.updateStateSetOne(sales);
    }


}




