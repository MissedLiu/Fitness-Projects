package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.TeamProjectname;

import java.util.List;


/**
*
*/
public interface TeamProjectnameService extends IService<TeamProjectname> {
    //通过团操套餐id查询私教项目(项目未禁用)
    List<TeamProjectname> selectTeamProject(long mealId);
}
