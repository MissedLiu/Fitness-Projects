package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.PtProjectMapper;
import com.trkj.dao.liucz2.TeamChooseMapper;
import com.trkj.entity.liucz2.PtChoose;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamChoose;
import com.trkj.service.implLiucz2.TeamChooseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamChooseServiceImpl extends ServiceImpl<TeamChooseMapper, TeamChoose> implements TeamChooseService {
   @Resource
   private TeamChooseMapper teamChooseMapper;

    /*
     * 根据团操项目编号查询套餐id
     * */
    @Override
    public boolean findTeamChoose(Long id) {
        QueryWrapper<TeamChoose> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tp_id" ,id);
        //当查询数据存在,不能删除 返回false;
        List<TeamChoose> teamChooses = baseMapper.selectList(queryWrapper);
        teamChooses.forEach(System.out::println);
        if (teamChooses.size() !=0){
            return false;
        }
        return true;

    }
}
