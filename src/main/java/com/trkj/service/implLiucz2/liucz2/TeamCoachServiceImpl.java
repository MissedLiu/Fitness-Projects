package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.TeamCoachMapper;
import com.trkj.entity.liucz2.TeamCoach;
import com.trkj.service.implLiucz2.TeamCoachService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class TeamCoachServiceImpl extends ServiceImpl<TeamCoachMapper, TeamCoach>
    implements TeamCoachService{
    @Resource
    private TeamCoachMapper teamCoachMapper;
    /**
     * @description:
     * 根据教练id查询套餐id
     * @author: Liucz
     * @date: 2022/10/8 12:11
     * @param:
     * @return:
     **/
    @Override
    public List<TeamCoach> findTeamIdByCoachId(Long empId) {
        QueryWrapper<TeamCoach> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("emp_id",empId);
        List<TeamCoach> teamCoaches = baseMapper.selectList(queryWrapper);
        return teamCoaches;
    }
}




