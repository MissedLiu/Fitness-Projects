package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Commission;
import com.trkj.service.implOuyang.CommissionService;
import com.trkj.dao.ouyang.CommissionMapper;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.CommissionQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【commission(提成统计表)】的数据库操作Service实现
 * @createDate 2022-10-05 09:41:43
 */
@Service
@Transactional
public class CommissionServiceImpl extends ServiceImpl<CommissionMapper, Commission>
        implements CommissionService {

    @Resource
    private CommissionMapper commissionMapper;

    /**
     * 分页获取统计提成表数据
     *
     * @param page
     * @param commissionQueryVo
     * @return
     */
    @Override
    public IPage<Commission> getList(IPage page, CommissionQueryVo commissionQueryVo) {
        //new一个条件构造器
        QueryWrapper queryWrapper = new QueryWrapper();
        //模糊查询
        queryWrapper.like(!ObjectUtils.isEmpty(commissionQueryVo.getEmpName()), "emp_name",
                commissionQueryVo.getEmpName());
        //通过id排序
        queryWrapper.orderByAsc("commission_id");
        return baseMapper.selectPage(page, queryWrapper);
    }

    /**
     * 获取普通套餐提成
     *
     * @param commission
     * @return
     */
    @Override
    public Double getByCommissionPt(Commission commission) {
        return commissionMapper.getByCommissionPt(commission);
    }

    /**
     * 获取私教套餐提成
     *
     * @param commission
     * @return
     */
    @Override
    public Double getByCommissionSj(Commission commission) {
        return commissionMapper.getByCommissionSj(commission);
    }

    /**
     * 获取团操套餐提成
     *
     * @param commission
     * @return
     */
    @Override
    public Double getByCommissionTc(Commission commission) {
        return commissionMapper.getByCommissionTc(commission);
    }

    /**
     * 获取商品销售提成
     *
     * @param commission
     * @return
     */
    @Override
    public Double getByCommissionSp(Commission commission) {
        return commissionMapper.getByCommissionSp(commission);
    }

    /**
     * 修改总提成
     *
     * @param commission
     * @return
     */
    @Override
    public Boolean updateCommissionPrice(Commission commission) {
        return commissionMapper.updateCommissionPrice(commission);
    }

    /**
     * 修改商品销售提成
     *
     * @param commission
     * @return
     */
    @Override
    public Boolean updateCommSp(Commission commission) {
        return commissionMapper.updateCommissionSp(commission);
    }


}




