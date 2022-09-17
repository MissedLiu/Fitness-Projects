package com.trkj.service;

import com.trkj.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

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
    //根据用户ID查询权限菜单列表
    List<Permission> findPermissionListByUserId(Long id);
}
