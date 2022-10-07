package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 张鑫
* @description 针对表【team_meal(团操会员套餐表)】的数据库操作Mapper
* @createDate 2022-09-25 21:14:45
* @Entity com.trkj.entity.TeamMeall
*/
public interface TeamMealMapper extends BaseMapper<TeamMeal> {
    /*团体套餐添加*/
    @Insert(value = "insert into team_meal (team_name,team_time,team_date,team_is,team_price)" +
            " value (#{teamName},#{teamTime},now(),#{teamIs},#{teamPrice})")
    public Boolean addTeamMeal(TeamMeal teamMeal);
    /**
     * @description:
     * 动态查询并分页
     * @author: Liucz
     * @date: 2022/10/2 12:11
     * @param:
     * @return:
     **/
    IPage<TeamMeal> findAllTeamMeal(Page<TeamMeal> page, @Param("query") PageVo pageVo);
    /**
     * @description:
     * 动态查询并分页,状态为0表示启用的
     * @author: Liucz
     * @date: 2022/10/2 12:11
     * @param:
     * @return:
     **/
    IPage<TeamMeal> findAllTeamMealState(Page<TeamMeal> page, @Param("query") PageVo pageVo);
    /**
     * @description:
     * 删除团操套餐与团操项目的关系
     * @author: Liucz
     * @date: 2022/10/2 17:23
     * @param: [ptId]
     * @return: void
     **/
    //分配之前先删除原本有的
    @Delete("delete from team_choose where team_id=#{teamId}")
    int deleteTeamProject(Long teamId);

    int saveTeamProject(Long teamId, List<Long> tpId);
}




