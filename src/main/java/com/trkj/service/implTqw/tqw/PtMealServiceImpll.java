package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.PtMealMapperl;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.PtMeall;
import com.trkj.service.implTqw.PtMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PtMealServiceImpll extends ServiceImpl<PtMealMapperl, PtMeall> implements PtMealService {

    /**
     * @title:  通过是否禁用查询普通套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:50
    */
    @Override
    public List<PtMeall> selectPtMeal() {
        QueryWrapper<PtMeall> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pt_is",0);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * @title:  通过选择的私教套餐id查询该套餐下的私教教练列表
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:50
    */
    @Override
    public List<Emp> selectEmpByPtId(Long ptId) {
        return baseMapper.selectEmpByPtId(ptId);
    }

    /**
     * @title:  通过套餐办理id查询套餐信息
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:50
    */
    @Override
    public PtMeall selectPtMealByMealId(long mealId) {
        QueryWrapper<PtMeall> wrapper=new QueryWrapper<>();
        wrapper.eq("pt_id",mealId);
        return baseMapper.selectOne(wrapper);
    }


}
