package com.trkj.dto;

import lombok.Data;

/**
 * 用于给角色分配权限时保存 选中的权限数据
 */
@Data
public class PermissionDTO {
    private Long roleId;//角色编号
    private Long permissionId;//权限菜单ID集合
}
