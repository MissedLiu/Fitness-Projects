package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.CommonMealMapper;
import com.trkj.entity.tqw.CommonMeal;
import com.trkj.service.ipmlTqw.CommonMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommonMealServiceImpl extends ServiceImpl<CommonMealMapper, CommonMeal> implements CommonMealService {
    /*
     *
     *通过是否禁用查询普通套餐
     *
     */
    @Override
    public List<CommonMeal> selectPtMeal() {
        QueryWrapper<CommonMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cm_Is",0);
        return baseMapper.selectList(queryWrapper);
    }

    /*
     *
     *通过id查普通套餐
     *
     */
    @Override
    public CommonMeal selectCommonMealByMealId(Long cmId) {
        return baseMapper.selectById(cmId);
    }

}
