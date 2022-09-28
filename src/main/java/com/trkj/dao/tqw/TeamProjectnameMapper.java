package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.TeamProjectname;

import java.util.List;


/**
* @Entity com.trkj.domain.Team_projectnameentity
*/
public interface TeamProjectnameMapper extends BaseMapper<TeamProjectname> {
    //通过套餐id查询团操项目(项目未禁用)
    List<TeamProjectname> selectTeamProjectByTeamId(Long teamId);
}
