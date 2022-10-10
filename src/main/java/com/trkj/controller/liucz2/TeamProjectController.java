package com.trkj.controller.liucz2;


import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.TeamProject;
import com.trkj.service.implLiucz2.TeamChooseService;
import com.trkj.service.implLiucz2.TeamProjectService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz2.TeamProjectVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/tpProject")
public class TeamProjectController {
    @Resource
    private TeamProjectService teamProjectService;
    @Resource
    private TeamChooseService teamChooseService;

    @GetMapping("list")
    /*
     * 按条件查询并分页查询
     * */
    public Result selectTeamProList(TeamProjectVo teamProjectVo) {
        return Result.ok(teamProjectService.selectTeamProject(teamProjectVo));
    }

    /*添加*/
    @PreAuthorize("hasAnyAuthority('projectname:teamPro:add')")
    @PostMapping("add")
    public Result addTeamProject(@RequestBody TeamProject teamProject) {
        if (teamProjectService.addTeamProject(teamProject)) {
            boolean save = teamProjectService.save(teamProject);
            System.out.println("save==" + save);
            if (save) {
                return Result.ok().message("团操项目添加成功");
            }
            return Result.ok().message("团操项目添加失败");
        }
        return Result.error().message("该团操项目已存在,添加失败");
    }

    /*删除*/
    @PreAuthorize("hasAnyAuthority('projectname:teamPro:delete')")
    @DeleteMapping("delete/{tpId}")
    public Result deleteTeamProjectById(@PathVariable Long tpId) {
        //判断当前项目是否绑定了套餐,有则无法删除
        if (!teamChooseService.findTeamChoose(tpId)) {
            return Result.error().message("该项目已被绑定套餐! 无法删除");
        }
        if (teamProjectService.removeById(tpId)) {
            return Result.ok().message("删除成功!");
        }
        return Result.ok().message("删除失败!");
    }

    /*修改*/
    @PreAuthorize("hasAnyAuthority('projectname:teamPro:edit')")
    @PutMapping("update")
    public Result updateTeamProject(@RequestBody TeamProject teamProject) {
        //根据传入的项目名称,查询是否已经存在
        TeamProject teamProjectIdByPtpName = teamProjectService.findTeamProjectIdByPtpName(teamProject.getTpName());
        //判断查询出的id,与当前的id是否相等
        if (teamProjectIdByPtpName != null) {
            if (teamProjectIdByPtpName.getTpId() != teamProject.getTpId()) {
                return Result.error().message("修改失败,该项目名已存在");
            }
        }
        if (teamProjectService.updateById(teamProject)) {
            return Result.ok().message("修改成功");
        }
        return Result.ok().message("修改失败");
    }

    /**
     * @description: 根据团操套餐id 查询 团操项目id
     * @author: Liucz
     * @date: 2022/10/3 20:26
     * @param:
     * @return:
     **/
    @GetMapping("/findTeamName/{TeamId}")
    public Result findTeamName(@PathVariable Long TeamId) {
        List<TeamProject> allName = teamProjectService.findAllTeamName(TeamId);
        return Result.ok(allName);
    }
}
