package com.trkj.service.implLiucz2.liucz2;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.TeamMealMapper;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.service.implLiucz2.TeamMealService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.CountTeamVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Service实现
* @createDate 2022-09-22 21:34:27
*/
@Service
public class TeamMealServiceImpl extends ServiceImpl<TeamMealMapper, TeamMeal>
    implements TeamMealService {
    @Resource
    private  TeamMealMapper teamMealMapper;

    /*添加团操信息*/
    @Override
    public Boolean addTeamMeal(TeamMeal teamMeal) {
        return teamMealMapper.addTeamMeal(teamMeal);
    }

    /*模糊查询*/

    public List<TeamMeal> selectTeamMealList(TeamMeal teamMeal) {
         QueryWrapper<TeamMeal> queryWrapper = new QueryWrapper<>();
         //第一个判断条件,若为ture,则表示此句有效,若为false,则此句无效
         queryWrapper.like(!ObjectUtils.isEmpty(teamMeal.getTeamName()), "team_name", teamMeal.getTeamName());
           return  baseMapper.selectList(queryWrapper);
     }
    /**
     * @description:
     * 动态查询并分页
     * @author: Liucz
     * @date: 2022/10/2 12:16
     * @param:
     * @return:
     **/
    @Override
    public IPage<TeamMeal> findAllTeamMeal(PageVo pageVo) {
        Page<TeamMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<TeamMeal> allTeamMeal = teamMealMapper.findAllTeamMeal(page, pageVo);
        return allTeamMeal;
    }
    /**
     * @description:
     * 动态查询并分页,状态为0表示启用的
     * @author: Liucz
     * @date: 2022/10/2 12:16
     * @param:
     * @return:
     **/
    @Override
    public IPage<TeamMeal> findAllTeamMealState(PageVo pageVo) {
        Page<TeamMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<TeamMeal> allTeamMeal = teamMealMapper.findAllTeamMealState(page, pageVo);
        return allTeamMeal;
    }
    /**
     * @description:
     * 判断当前传入的套餐名,表中是否已经存在,如果存在则提示套餐名已经存在
     * @author: Liucz
     * @date: 2022/10/2 14:17
     * @param:
     * @return:
     **/
    @Override
    public TeamMeal findTeamMealId(TeamMeal teamMeal) {
        QueryWrapper<TeamMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("team_name",teamMeal.getTeamName());
        TeamMeal teamMeal1 = baseMapper.selectOne(queryWrapper);
        return teamMeal1;

    }
    /**
     * @description:
     * 分配团操项目给私教套餐
     * @author: Liucz
     * @date: 2022/10/2 17:19
     * @param: [ptId, ptpId]
     * @return: boolean
     **/
    @Override
    public boolean saveTeamProject(Long teamId, List<Long> tpId) {
        //分配之前先删除原本有的
        baseMapper.deleteTeamProject(teamId);
        //在重新添加
        return   baseMapper.saveTeamProject(teamId,tpId)>0;
    }
    /**
     * @description:
     * 统计每个教练下的团操人数
     * @author: Liucz
     * @date: 2022/10/11 9:29
     * @param:
     * @return:
     **/
    @Override
    public List<CountTeamVo> CountTeamNum() {
        List<CountTeamVo> countTeamVos = teamMealMapper.CountTeamNum();
        return countTeamVos;
    }

}









