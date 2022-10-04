package com.trkj.controller.liucz2;


import com.trkj.dto.PtMealProjectDTO;
import com.trkj.dto.TeamProjectDTO;
import com.trkj.entity.liucz2.TeamMeal;
import com.trkj.service.implLiucz2.TeamMealService;
import com.trkj.service.implLiucz2.TeamProjectService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.TeamProjectVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/teamMeal")
public class TeamMealController {
    @Resource
    private TeamMealService teamMealService;
    @Resource
    private TeamProjectService teamProjectService;
    /**
     * @description:
     * 动态查询并分页
     * @author: Liucz
     * @date: 2022/10/2 12:10
     * @param: [teamMeal]
     * @return: com.trkj.utils.Result
     **/
    @GetMapping("/list")
    public Result selectTeamMealList(PageVo pageVo) {
        return Result.ok(teamMealService.findAllTeamMeal(pageVo));
    }
    /**
     * @description:
     * 动态查询并分页,状态为0表示启用的
     * @author: Liucz
     * @date: 2022/10/2 12:10
     * @param: [teamMeal]
     * @return: com.trkj.utils.Result
     **/
    @GetMapping("/listState")
    public Result selectTeamMealListState(PageVo pageVo) {
        return Result.ok(teamMealService.findAllTeamMealState(pageVo));
    }

    /**
     * @description:add团操套餐
     * @author: Liucz
     * @date: 2022/10/2 14:14
     * @param: [teamMeal]
     * @return: com.trkj.utils.Result
     **/
    @PostMapping("/add")
    public Result addTeamMeal(@RequestBody TeamMeal teamMeal) {
        //判断当前传入的套餐名,表中是否已经存在,如果存在则提示套餐名已经存在
        TeamMeal teamMealId = teamMealService.findTeamMealId(teamMeal);
        if (teamMealId!=null){
            return Result.error().message("该套餐名已存在,请跟换");
        }
        return Result.ok(teamMealService.addTeamMeal(teamMeal));
    }

    /**
     * @description:
     * update团操套餐
     * @author: Liucz
     * @date: 2022/10/2 14:22
     * @param: [teamMeal]
     * @return: com.trkj.utils.Result
     **/
    @PutMapping("/update")
    public Result updateTeamMeal(@RequestBody TeamMeal teamMeal) {
        //修改套餐时,先判断该套餐名是否存在,如果存在则提示存在无法修改
        TeamMeal teamMealId = teamMealService.findTeamMealId(teamMeal);
        if(teamMealId!=null){
            if (teamMealId.getTeamId() != teamMeal.getTeamId()){
                return Result.error().message("该套餐名已存在,修改失败");
            }
        }

        if (teamMealService.updateById(teamMeal)) {
            return Result.ok().message("套餐修改成功");
        }
        return Result.error().message("套餐修改失败");
    }

    /**
     * @description:
     * 删除
     * @author: Liucz
     * @date: 2022/10/2 22:12
     * @param: [teamId]
     * @return: com.trkj.utils.Result
     **/
    @DeleteMapping("/delete/{teamId}")
    public Result deleteById(@PathVariable Long teamId) {
        //判断该套餐是否绑定了团操项目
        //根据团操套餐id查找该团操套餐的项目id
        List<Long> teamIdBytpId = teamProjectService.findTeamIdBytpId(teamId);
        if(teamIdBytpId.size() !=0){
            return Result.error().message("该套餐下绑定了项目,无法删除");
        }
        if (teamMealService.removeById(teamId)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }



    /*
     * 获取团操项目列表,
     * */
    @GetMapping("/listTeamProList")
    public Result selectTeamProList(TeamProjectVo teamProjectVo){
//        根据条件查询团操项目列表并分页,并查询只有状态为启用的
        return Result.ok(teamProjectService.selectTeamProjectState(teamProjectVo));
    }
    /**
     * @description:
     * 根据团操套餐id查找该团操套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @GetMapping("/getTeamProIdByPtId/{teamId}")
    public Result getTeamProIdByPtId(@PathVariable Long teamId){
        //根据团操套餐id查找该团操套餐的项目id
        List<Long> teamIdBytpId = teamProjectService.findTeamIdBytpId(teamId);
        return Result.ok(teamIdBytpId);
    }

    /**
     * @description:
     * 保存分配团操套餐的分配的项目
     * @author: Liucz
     * @date: 2022/10/2 17:12
     * @param:
     * @return:
     **/
    @PostMapping("/saveTeamProject")
    public Result savePtMealPtProject(@RequestBody TeamProjectDTO teamProjectDTO){
        //保存团操和项目的关系
        if (teamMealService.saveTeamProject(teamProjectDTO.getTeamId(), teamProjectDTO.getTpId())) {
            return Result.ok().message("私教项目分配成功");
        }
        return Result.error().message("私教项目分配失败");
    }
}