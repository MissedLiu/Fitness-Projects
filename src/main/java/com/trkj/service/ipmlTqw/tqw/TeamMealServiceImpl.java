package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.TeamMealMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.TeamMeal;
import com.trkj.service.ipmlTqw.TeamMealService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TeamMealServiceImpl extends ServiceImpl<TeamMealMapper, TeamMeal>
implements TeamMealService {
    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    @Override
    public List<TeamMeal> selectTeamMeal() {
        QueryWrapper<TeamMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("team_is",0);
        return baseMapper.selectList(queryWrapper);
    }
    /*
     *
     *通过选择的私教套餐id查询该套餐下的私教教练列表
     *
     */
    @Override
    public List<Emp> selectEmpByTeamId(Long teamId) {
        return baseMapper.selectEmpByTeamId(teamId);
    }

    /*
     *
     *通过团操套餐id查询套餐信息
     *
     */
    @Override
    public TeamMeal selectTeamMealByMealId(long mealId) {
        QueryWrapper<TeamMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("team_id",mealId);
        return baseMapper.selectOne(wrapper);
    }
}
