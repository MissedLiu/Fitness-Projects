package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.PtMealMapperl;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtMeall;
import com.trkj.service.ipmlTqw.PtMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PtMealServiceImpll extends ServiceImpl<PtMealMapperl, PtMeall> implements PtMealService {
    /*
     *
     *通过是否禁用查询普通套餐
     *
     */
    @Override
    public List<PtMeall> selectPtMeal() {
        QueryWrapper<PtMeall> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pt_is",0);
        return baseMapper.selectList(queryWrapper);
    }

    /*
     *
     *通过选择的私教套餐id查询该套餐下的私教教练列表
     *
     */
    @Override
    public List<Emp> selectEmpByPtId(Long ptId) {
        return baseMapper.selectEmpByPtId(ptId);
    }
    /*
     *
     *通过套餐办理id查询套餐信息
     *
     */
    @Override
    public PtMeall selectPtMealByMealId(long mealId) {
        QueryWrapper<PtMeall> wrapper=new QueryWrapper<>();
        wrapper.eq("pt_id",mealId);
        return baseMapper.selectOne(wrapper);
    }


}
