package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.TeamProjectMapper;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.entity.liucz2.TeamProject;
import com.trkj.service.implLiucz2.TeamProjectService;
import com.trkj.vo.queryLiucz2.TeamProjectVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 张鑫
* @description 针对表【team_project(团操项目类型表)】的数据库操作Service实现
* @createDate 2022-09-26 09:53:18
*/
@Service

public class TeamProjectServiceImpl extends ServiceImpl<TeamProjectMapper, TeamProject>
    implements TeamProjectService {


      @Resource
      private  TeamProjectMapper teamProjectMapper;
    /*
     * 根据条件查询团操项目列表并分页
     * */
    @Override
    public IPage<TeamProject> selectTeamProject(TeamProjectVo teamProjectVo) {
        Page<TeamProject > page=new Page<>(teamProjectVo.getPageNo(),teamProjectVo.getPageSize());
        IPage<TeamProject> teamProject = teamProjectMapper.findTeamProject(page, teamProjectVo);
        return  teamProject;
    }
    /**
     * @description:
     * 根据条件查询团操项目列表并分页,并查询只有状态为启用的
     * @author: Liucz
     * @date: 2022/10/3 12:26
     * @param: [teamProjectVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.TeamProject>
     **/
    @Override
    public IPage<TeamProject> selectTeamProjectState(TeamProjectVo teamProjectVo) {
        Page<TeamProject > page=new Page<>(teamProjectVo.getPageNo(),teamProjectVo.getPageSize());
        IPage<TeamProject> teamProject = teamProjectMapper.findTeamProjectState(page, teamProjectVo);
        return  teamProject;
    }

    /*t添加普通套餐*/
    @Transactional
    @Override
    public Boolean addTeamProject(TeamProject teamProject) {
        //根据项目名查询是否存在
        TeamProject teamProjectBytpName = teamProjectMapper.findTeamProjectBytpName(teamProject.getTpName());
        if (teamProjectBytpName !=null){
            //不为空则存在,不能添加
            return false;
        }
        return true;

    }

    /*
     * 根据传入的项目名称查询id
     * */
    @Override
    public TeamProject findTeamProjectIdByPtpName(String name) {
        QueryWrapper<TeamProject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tp_name",name);
        TeamProject teamProject = teamProjectMapper.selectOne(queryWrapper);
        if (teamProjectMapper.selectOne(queryWrapper) == null){
            return null;
        }
        return teamProject;
    }
    /**
     * @description:
     * 根据团操套餐id查找该团操套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @Override
    public List<Long> findTeamIdBytpId(Long tpId) {
        return  baseMapper.findTeamIdBytpId(tpId);
    }
    /*
     * 查询所有的团操套餐名
     * */
    @Override
    public List<TeamProject> findAllTeamName(Long teamId) {
        List<Long> teamIdBytpId = baseMapper.findTeamIdBytpId(teamId);
        List<TeamProject> list=new ArrayList<>();
        for (Long teamIdBytpIds: teamIdBytpId) {
            List<TeamProject> allNameTeam = teamProjectMapper.findAllNameTeam(teamIdBytpIds);
            for (TeamProject allNames: allNameTeam) {
                list.add(allNames);
            }
        }
        return list;
    }
}




