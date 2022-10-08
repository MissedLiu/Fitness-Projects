package com.trkj.service.implLiucz2;

import com.trkj.entity.liucz2.Schoolteaching;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.TeamCoach;

import java.util.List;

/**
 *授课业务
 */
public interface SchoolteachingService extends IService<Schoolteaching> {
    /**
     * @description:
     * 根据教练id获取套餐id列表
     * @author: Liucz
     * @date: 2022/10/8 12:20
     * @param:
     * @return:
     **/
     List<TeamCoach> findTeamIdByCoachId (Long empId);
}
