package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.CommonMealMapperl;
import com.trkj.entity.tqw.CommonMeall;
import com.trkj.service.implTqw.CommonMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommonMealServiceImpll extends ServiceImpl<CommonMealMapperl, CommonMeall> implements CommonMealService {

    /**
     * @title:  通过是否禁用查询普通套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:44
    */
    @Override
    public List<CommonMeall> selectPtMeal() {
        QueryWrapper<CommonMeall> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cm_Is",0);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * @title:  通过id查普通套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:44
    */
    @Override
    public CommonMeall selectCommonMealByMealId(Long cmId) {
        return baseMapper.selectById(cmId);
    }

}
