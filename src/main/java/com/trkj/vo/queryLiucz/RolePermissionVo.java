package com.trkj.vo.queryLiucz;

import com.trkj.entity.liucz.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
 * 角色权限菜单数据回显VO类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionVo {
    /*
     * 菜单数据
     * */
    private List<Permission> permissionList = new ArrayList<Permission>();
    /*
     * 该角色拥有的权限数据
     * */
    private Object[] checkList;
}
