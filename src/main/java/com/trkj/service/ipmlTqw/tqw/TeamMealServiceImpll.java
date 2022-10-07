package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.TeamMealMapperl;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.tqw.TeamMeall;
import com.trkj.service.ipmlTqw.TeamMealService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TeamMealServiceImpll extends ServiceImpl<TeamMealMapperl, TeamMeall>
implements TeamMealService {
    /*
     *
     *通过是否禁用查询私教套餐
     *
     */
    @Override
    public List<TeamMeall> selectTeamMeal() {
        QueryWrapper<TeamMeall> queryWrapper=new QueryWrapper<>();
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
    public TeamMeall selectTeamMealByMealId(long mealId) {
        QueryWrapper<TeamMeall> wrapper=new QueryWrapper<>();
        wrapper.eq("team_id",mealId);
        return baseMapper.selectOne(wrapper);
    }
}
