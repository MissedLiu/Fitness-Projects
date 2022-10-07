package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.TeamProjectnameMapper;
import com.trkj.entity.tqw.TeamProjectname;
import com.trkj.service.ipmlTqw.TeamProjectnameService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TeamProjectnameServiceImpl extends ServiceImpl<TeamProjectnameMapper, TeamProjectname>
implements TeamProjectnameService {
    //通过套餐id查询团操教项目(项目未禁用)
    @Override
    public List<TeamProjectname> selectTeamProject(long mealId){
        return baseMapper.selectTeamProjectByTeamId(mealId);
    }
}