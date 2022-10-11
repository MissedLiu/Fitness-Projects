package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.CountTeamVo;


import java.util.List;

/**
* @author 张鑫
* @description 针对表【team_meal(团操会员套餐表)】的数据库操作Service
* @createDate 2022-09-25 21:14:45
*/
public interface TeamMealService extends IService<TeamMeal> {
    /*模糊查询*/
    List<TeamMeal> selectTeamMealList(TeamMeal teamMeal);
    /*t添加普通套餐*/
    Boolean addTeamMeal(TeamMeal teamMeal);
    /**
     * @description:
     * 动态查询并分页
     * @author: Liucz
     * @date: 2022/10/2 12:16
     * @param:
     * @return:
     **/
    IPage<TeamMeal> findAllTeamMeal(PageVo pageVo);
    /**
     * @description:
     * 动态查询并分页,状态为0表示启用的
     * @author: Liucz
     * @date: 2022/10/2 12:16
     * @param:
     * @return:
     **/
    IPage<TeamMeal> findAllTeamMealState(PageVo pageVo);
    /**
     * @description:
     * 判断当前传入的套餐名,表中是否已经存在,如果存在则提示套餐名已经存在
     * @author: Liucz
     * @date: 2022/10/2 14:17
     * @param:
     * @return:
     **/
    TeamMeal findTeamMealId(TeamMeal teamMeal);
    /**
     * @description:
     * 分配团操项目给私教套餐
     * @author: Liucz
     * @date: 2022/10/2 17:19
     * @param: [ptId, ptpId]
     * @return: boolean
     **/
    boolean saveTeamProject(Long teamId, List<Long> tpId);
    /**
     * @description:
     * 统计每个教练下的团操人数
     * @author: Liucz
     * @date: 2022/10/11 9:29
     * @param:
     * @return:
     **/
    List<CountTeamVo> CountTeamNum();
}
