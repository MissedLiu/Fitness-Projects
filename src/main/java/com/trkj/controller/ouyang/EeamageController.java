package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.entity.liucz.User;
import com.trkj.entity.liucz2.Weixg;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.entity.ouyang.Emaintenance;
import com.trkj.service.implLiucz2.WeixgService;
import com.trkj.service.implOuyang.EdetailsService;
import com.trkj.service.implOuyang.EeamageService;
import com.trkj.service.implOuyang.EmaintenanceService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报修管理
 */
@RestController
@RequestMapping("/api/repair")
public class EeamageController {
    @Resource
    private EeamageService eeamageService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private EmaintenanceService emaintenanceService;
    @Resource
    private WeixgService weixgService;
    @Resource
    private EdetailsService edetailsService;


    @GetMapping("/list")
    public Result getRepairList(EeamageQueryVo eeamageQueryVo) {
        //调用分页查询方法
        IPage<Eeamage> repairListIpage = eeamageService.findRepairListIpage(eeamageQueryVo);
        return Result.ok(repairListIpage);
    }

    @GetMapping("/listByEmpId")
    public Result getRepairListByEmpId(EeamageQueryVo eeamageQueryVo) {
        //调用分页查询方法
        IPage<Eeamage> repairListIpage = eeamageService.findRepairListIpageByEmpId(eeamageQueryVo);
        return Result.ok(repairListIpage);
    }

    /**
     * 修理成功完成，获取报修表的数据 插入器材损坏记录表中
     *
     * @param eeamageQueryVo
     * @return
     */
@PreAuthorize("hasAnyAuthority('equipments:sunhuai:xiuli')")
    @PostMapping("/toEm")
    public Result toEm(@RequestBody EeamageQueryVo eeamageQueryVo) {
        Eeamage stateById = eeamageService.findStateById(eeamageQueryVo.getEeId());
        if (stateById.getState() == 3 || stateById.getState() == 4) {
            return Result.exist().message("该操作已完成");
        }
        //修改状态为3-维修成功
        int i = eeamageService.UpdateStateById3(eeamageQueryVo.getEeId());
        if (i != 1) {
            return Result.exist().message("结果处理失败!");
        }
        //将记录添加进维修记录表中
        Emaintenance emaintenance = new Emaintenance();
        emaintenance.setEeId(eeamageQueryVo.getEeId());
        emaintenance.setEdCode(eeamageQueryVo.getEdCode());
        emaintenance.setEdName(eeamageQueryVo.getEdName());
        emaintenance.setEmpName(eeamageQueryVo.getEmpName());
        emaintenance.setEmTime(eeamageQueryVo.getEmTime());
        emaintenance.setResuIts(eeamageQueryVo.getResuIts());
        emaintenance.setMethods(eeamageQueryVo.getMethods());
        int add = emaintenanceService.add(emaintenance);
        if (add == 0) {
            return Result.exist().message("结果处理失败");
        }
        return Result.ok().message("结果处理成功");
    }

    /**
     * 修理成功完成，获取报修表的数据 插入器材损坏记录表中
     *
     * @param eeamageQueryVo
     * @return
     */
    @PreAuthorize("hasAnyAuthority('equipments:sunhuai:xiuli')")
    @PostMapping("/shibai")
    public Result shibai(@RequestBody EeamageQueryVo eeamageQueryVo) {
        Eeamage stateById = eeamageService.findStateById(eeamageQueryVo.getEeId());
        if (stateById.getState() == 3 || stateById.getState() == 4) {
            return Result.exist().message("该操作已完成");
        }
        //修改状态为4-维修失败
        int i = eeamageService.UpdateStateById4(eeamageQueryVo.getEeId());
        if (i != 1) {
            return Result.exist().message("结果处理失败!");
        }
        if (!eeamageService.updateDetailsState(eeamageQueryVo)){
            return Result.exist().message("结果处理失败!");
        }

        //将记录添加进维修记录表中
        Emaintenance emaintenance = new Emaintenance();
        emaintenance.setEeId(eeamageQueryVo.getEeId());
        emaintenance.setEdCode(eeamageQueryVo.getEdCode());
        emaintenance.setEdName(eeamageQueryVo.getEdName());
        emaintenance.setEmpName(eeamageQueryVo.getEmpName());
        emaintenance.setEmTime(eeamageQueryVo.getEmTime());
        emaintenance.setResuIts(eeamageQueryVo.getResuIts());
        emaintenance.setMethods(eeamageQueryVo.getMethods());
        int add = emaintenanceService.add(emaintenance);
        if (add == 0) {
            return Result.exist().message("结果处理失败");
        }
        return Result.ok().message("结果处理成功");
    }

    /**
     * @description: 器材损坏上报
     * @author: Liucz
     * @date: 2022/10/6 10:48
     * @param: [eeamage]
     * @return: com.trkj.utils.Result
     **/

    @PreAuthorize("hasAnyAuthority('repairs:record:add')")
    @PostMapping("/add")
    public Result addRepair(@RequestBody Eeamage eeamage) {
        Edetails edetails = new Edetails();
        edetails.setEdName(eeamage.getEeName());
        edetails.setEdCode(eeamage.getEdCode());
        if (edetailsService.CountDetailsByEdCodeAndName(edetails) > 0) {
            //上报时查询,该物品的状态
            List<Eeamage> stateByNameById = eeamageService.findStateByNameById(eeamage);
            System.out.println("sss=" + stateByNameById);
            if (stateByNameById != null && stateByNameById.size() != 0) {
                for (Eeamage state : stateByNameById) {
                    if (state.getState() == 0 || state.getState() == 2 || state.getState() == 4) {
                        return Result.exist().message("该器材正在处理中");
                    }
                }
            }

            if (eeamageService.addRepair(eeamage)) {
                return Result.ok().message("上报成功");
            }
            return Result.error().message("上报失败");
        }
        return Result.error().message("该器材未使用，请重新输入！");

    }

    /**
     * @description: 删除上报记录
     * @author: Liucz
     * @date: 2022/10/6 12:37
     * @param: [id]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('repairs:record:delete')")
    @DeleteMapping("/delete/{id}")
    public Result deleteRepair(@PathVariable Long id) {
        //判断状态为 2-维修中则不可删除
        Eeamage stateById = eeamageService.findStateById(id);
        if (stateById.getState() == 2) {
            return Result.exist().message("删除失败,该计划正在维修");
        }
        if (eeamageService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }

    /**
     * @description: 查询所有的维修工
     * @author: Liucz
     * @date: 2022/10/6 12:57
     * @param:
     * @return:
     **/
    @GetMapping("/weixiug")
    public Result weixiug() {
        List<User> weiXiuG = userMapper.findWeiXiuG();
        return Result.ok(weiXiuG);
    }

    /**
     * @description: 保存分配好的维修工记录, 并修改上报记录表的状态为2-维修中
     * @author: Liucz
     * @date: 2022/10/6 13:22
     * @param:
     * @return:
     **/
    @PreAuthorize("hasAnyAuthority('shenhes:baoxiu:fenpei')")
    @PostMapping("/saveWeiXiuName")
    public Result saveWeiXiuName(@RequestBody Weixg weixg) {
        //判断如果已经分配则不能再分配
        Weixg allWeixiu = weixgService.findAllWeixiu(weixg.getEeId());
        if (allWeixiu != null) {
            return Result.exist().message("已分配,无需分配");
        }

        //分配成功
        boolean save = weixgService.save(weixg);
        //修改上报表中的状态
        int i = eeamageService.UpdateStateById(weixg.getEeId());
        if (i != 1) {
            return Result.error().message("分配失败!");
        }
        if (save) {
            return Result.ok().message("分配成功");
        }
        return Result.error().message("分配失败");
    }
}
