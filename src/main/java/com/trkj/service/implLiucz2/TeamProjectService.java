package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamProject;
import com.trkj.vo.queryLiucz2.TeamProjectVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
* @author 张鑫
* @description 针对表【team_project(团操项目类型表)】的数据库操作Service
* @createDate 2022-09-26 09:53:18
*/
public interface TeamProjectService extends IService<TeamProject> {
  /*
  * 根据条件查询团操项目列表并分页
  * */
  IPage<TeamProject> selectTeamProject( TeamProjectVo teamProjectVo);

  /**
   * @description:
   * 根据条件查询团操项目列表并分页,并查询只有状态为启用的
   * @author: Liucz
   * @date: 2022/10/3 12:26
   * @param: [teamProjectVo]
   * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.TeamProject>
   **/
  IPage<TeamProject> selectTeamProjectState( TeamProjectVo teamProjectVo);

  /*t添加普通套餐*/
  Boolean addTeamProject(TeamProject teamProject);

  /*
   * 根据传入的项目名称查询id
   * */
  TeamProject findTeamProjectIdByPtpName(String name);

  /**
   * @description:
   * 根据团操套餐id查找该团操套餐的项目id
   * @author: Liucz
   * @date: 2022/10/2 15:29
   * @param:
   * @return:
   **/
  List<Long> findTeamIdBytpId(Long tpId);
  /*
   * 查询所有的团操套餐名
   * */
  List<TeamProject> findAllTeamName (Long teamId);
}
