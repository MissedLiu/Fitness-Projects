package com.trkj.controller.liucz;


import com.trkj.entity.liucz.Permission;
import com.trkj.service.implLiucz.PermissionService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.PermissionQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author liucz
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Resource
   private PermissionService permissionService;
    /**
     * 查询菜单列表
     */
    @GetMapping("/list")
    public Result getmenuList(PermissionQueryVo permissionQueryVo){
        List<Permission> permissionList= permissionService.findPermissionList(permissionQueryVo);
        //返回数据
    return Result.ok(permissionList);
    }
    /*
    * 查询上级菜单列表
    * */
    @GetMapping("/parent/list")
    public Result getParentList(){
        //查询上级菜单列表
        List<Permission> permissionList=permissionService.findParentPermissionList();
        return Result.ok(permissionList);
    }
    /*
    * 添加菜单
    * */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public Result add(@RequestBody Permission permission){
        if(permissionService.save(permission)){
            return  Result.ok().message("菜单添加成功");
        }
        return  Result.ok().message("菜单添加失败");
    }
    /*
    * 检查菜单是否有子菜单
    * */
    @GetMapping("/check/{id}")
    public Result check(@PathVariable Long id){
        //判断菜单是否有子菜单
        if(permissionService.hasChildrenOfPermission(id)){
            return Result.exist().message("该菜单下有子菜单,无法删除");
        }
        return Result.ok();
    }
    /*
    * 删除菜单
    * */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable Long id){
        //判断
        if(permissionService.removeById(id)){
            return Result.ok().message("菜单删除成功");
        }
        return  Result.ok().message("菜单删除失败");
    }
    /*
    * 修改菜单
    * */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    public Result update(@RequestBody Permission permission){
        if (permissionService.updateById(permission)){
            return Result.ok().message("菜单修改成功");
        }
        return Result.ok().message("菜单修改失败");
    }


}

