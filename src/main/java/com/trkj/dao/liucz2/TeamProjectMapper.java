package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.entity.liucz2.TeamProject;
import com.trkj.vo.queryLiucz2.PtProjectVo;
import com.trkj.vo.queryLiucz2.TeamProjectVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 张鑫
* @description 针对表【team_project(团操项目类型表)】的数据库操作Mapper
* @createDate 2022-09-26 10:17:18
* @Entity com.trkj.entity.TeamProject
*/
public interface TeamProjectMapper extends BaseMapper<TeamProject> {
    /*添加团餐项目*/
         @Insert(value = "insert into team_projectname (tp_name,create_time,update_time,tp_is)" +
                  " value (#{tpName},now(),now(),#{tpIs})")
        boolean addTeamProject(TeamProject teamProject);
         /*
          * 根据条件分页查询所有的团操项目列表
          * */
         IPage<TeamProject> findTeamProject(IPage<TeamProject> page , @Param("query") TeamProjectVo query);
    /**
     * @description:
     *  根据条件查询团操项目列表并分页,并查询只有状态为启用的
     * @author: Liucz
     * @date: 2022/10/3 12:27
     * @param: [page, query]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.TeamProject>
     **/
    IPage<TeamProject> findTeamProjectState(IPage<TeamProject> page , @Param("query") TeamProjectVo query);

         /*
     * 根据项目名称查询是否存在
     * */
    TeamProject findTeamProjectBytpName(String name);
    /**
     * @description:
     * 根据团操套餐id查找该团操套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @Select("select tp_id from team_choose where team_id = #{teamId}")
    List<Long> findTeamIdBytpId(Long teamId);
    /*
     * 查询所有的团操套餐名
     * */
    List<TeamProject> findAllNameTeam ( Long tpId);
}




