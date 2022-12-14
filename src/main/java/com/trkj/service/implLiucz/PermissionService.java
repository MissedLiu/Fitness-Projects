package com.trkj.service.implLiucz;

import com.trkj.entity.liucz.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryLiucz.PermissionQueryVo;
import com.trkj.vo.queryLiucz.RolePermissionVo;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface PermissionService extends IService<Permission> {
    /*
    * 根据用户ID查询权限菜单列表
    * */

    List<Permission> findPermissionListByUserId(Long id);

    /*
    * 查询菜单列表
    * */

    List<Permission> findPermissionList(PermissionQueryVo permissionQueryVo);

    /*
    * 查询上级菜单列表
    * */

    List<Permission> findParentPermissionList();

    /*
    * 检查菜单是否有子菜单
    * */

    boolean hasChildrenOfPermission(Long id);

    /*
     * 查询分配权限菜单列表
     * */

    RolePermissionVo findPermissionTree(Long userId,Long roleId);




}
