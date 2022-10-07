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
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【commission(提成统计表)】的数据库操作Service实现
* @createDate 2022-10-05 09:41:43
*/
@Service
public class CommissionServiceImpl extends ServiceImpl<CommissionMapper, Commission>
    implements CommissionService{

    @Resource
    private CommissionMapper commissionMapper;

    @Override
    public IPage<Commission> getList(IPage page, CommissionQueryVo commissionQueryVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like(!ObjectUtils.isEmpty(commissionQueryVo.getEmpName()),"emp_name",
                commissionQueryVo.getEmpName());
        queryWrapper.orderByAsc("commission_id");
        return baseMapper.selectPage(page,queryWrapper);
    }


    @Override
    public Double getByCommissionPt(Commission commission) {
        return commissionMapper.getByCommissionPt(commission);
    }

    @Override
    public Double getByCommissionSj(Commission commission) {
        return commissionMapper.getByCommissionSj(commission);
    }

    @Override
    public Double getByCommissionTc(Commission commission) {
        return commissionMapper.getByCommissionTc(commission);
    }

    @Override
    public Double getByCommissionSp(Commission commission) {
        return commissionMapper.getByCommissionSp(commission);
    }

    @Override
    public Boolean updateCommissionPrice(Commission commission) {
        return commissionMapper.updateCommissionPrice(commission);
    }

    @Override
    public Boolean updateCommSp(Commission commission) {
        return commissionMapper.updateCommission(commission);
    }


}




