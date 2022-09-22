package com.trkj.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dto.RolePermissionDTO;
import com.trkj.entity.Role;
import com.trkj.service.PermissionService;
import com.trkj.service.RoleService;
import com.trkj.utils.Result;
import com.trkj.vo.query.RolePermissionVo;
import com.trkj.vo.query.RoleQueryVo;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author liucz
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    /*
     * 根据账号id查询角色列表
     * */
    @GetMapping("/list")
    public Result list(RoleQueryVo roleQueryVo){
        //创建分页对象
        IPage<Role> page=new Page<Role>(roleQueryVo.getPageNo(),roleQueryVo.getPageSize());
        //调用分页查询方法
        roleService.findRoleListById(page,roleQueryVo);
        //返回数据
        return Result.ok(page);
    }
    //添加角色
    @PostMapping("/add")
    public Result add(@RequestBody Role role){
        if(roleService.save(role)){
            return Result.ok().message("角色添加成功");
        }
        return Result.ok().message("角色添加失败");
    }
    //修改角色信息
    @PutMapping("/update")
    public Result update(@RequestBody Role role){
        if(roleService.updateById(role)){
            return Result.ok().message("角色修改成功");
        }
        return Result.ok().message("角色修改失败");
    }
    //删除角色
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        if(roleService.removeById(id)){
            return Result.ok().message("角色删除成功");
        }
        return Result.ok().message("角色删除失败");
    }
    //查询该角色下是否有账号
    @GetMapping("/check/{id}")
    public Result check(@PathVariable Long id){
        if(roleService.hashRoleCount(id)){
            return Result.exist().message("无法删除,请先收回该角色下的账号");
        }
        return  Result.ok();
    }
    /*
     * 查询权限菜单列表
     * */
    @GetMapping("/getRolePermisson")
    public Result getRolePermisson(Long userId,Long roleId){
        //调用查询权限树数据的方法
        RolePermissionVo permissionVo=permissionService.findPermissionTree(userId,roleId);
        return Result.ok(permissionVo);
    }
    /*
     *保存权限添加
     * */@PostMapping("/saveRoleAssign")
    public Result saveRoleAssign(@RequestBody RolePermissionDTO rolePermissionDTO) {
        //调用保存角色权限关系方法
        if (roleService.saveRolePermission(rolePermissionDTO.getRoleId(), rolePermissionDTO.getList())) {
            return Result.ok().message("权限分配成功");
        }
        return Result.error().message("权限分配失败");
    }


}

