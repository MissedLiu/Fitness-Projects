package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.SchoolteachingMapper;
import com.trkj.entity.liucz2.Schoolteaching;

import com.trkj.entity.liucz2.TeamCoachl;
import com.trkj.service.implLiucz2.SchoolteachingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service

public class SchoolteachingServiceImpl extends ServiceImpl<SchoolteachingMapper, Schoolteaching>
    implements SchoolteachingService {
    /**
     * @description:
     * 根据教练id获取套餐id列表
     * @author: Liucz
     * @date: 2022/10/8 12:20
     * @param:
     * @return:
     **/
    @Override
    public List<TeamCoachl> findTeamIdByCoachId(Long empId) {
        return null;
    }
}




