package com.trkj.dao.liucz;

import com.trkj.entity.liucz.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    //根据用户ID查询权限菜单列表
    List<Permission> findPermissionListByUserId(Long id);
    //根据角色id查询权限列表
    List<Permission> findPermissionListByRoleId(Long roleId);
}
