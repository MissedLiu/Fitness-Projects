package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.TeamCoachMapper;
import com.trkj.entity.tqw.TeamCoach;
import com.trkj.service.implTqw.TeamCoachService;
import com.trkj.vo.queryTqw.EmpAndTeamMealQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
*/
@Service
public class TeamCoachServiceImpl extends ServiceImpl<TeamCoachMapper, TeamCoach>
implements TeamCoachService {
    /**
     * @title:  新增团操套餐教练关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:13
    */
    @Override
    @Transactional
    public boolean addEmpAndTeamMeal(EmpAndTeamMealQueryVo empAndTeamMealQueryVo) {
        //删除原来的
        QueryWrapper<TeamCoach> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empAndTeamMealQueryVo.getEmpId());
        baseMapper.delete(wrapper);
        //添加新的
        if(baseMapper.insertTeamCoachs(empAndTeamMealQueryVo.getEmpId(),empAndTeamMealQueryVo.getTeamMealId())>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  通过员工id查询团操关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:13
    */
    @Override
    public List<TeamCoach> findTeamAndEmpByEmpId(Long empId) {
        QueryWrapper<TeamCoach> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empId);
        return baseMapper.selectList(wrapper);
    }

}
