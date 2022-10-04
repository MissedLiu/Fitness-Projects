package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamChoose;

public interface TeamChooseService extends IService<TeamChoose> {
    /*
     * 根据团操项目编号查询套餐id
     * */
    boolean findTeamChoose(Long id);
}
