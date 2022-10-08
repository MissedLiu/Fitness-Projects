package com.trkj.service.implLiucz2;

import com.trkj.entity.liucz2.TeamCoach;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface TeamCoachService extends IService<TeamCoach> {
    /**
     * @description:
     * 根据教练id查询套餐id
     * @author: Liucz
     * @date: 2022/10/8 12:11
     * @param:
     * @return:
     **/
    List<TeamCoach> findTeamIdByCoachId(Long empId);
}
