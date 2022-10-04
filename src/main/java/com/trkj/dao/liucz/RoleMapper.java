package com.trkj.dao.liucz;

import com.trkj.entity.liucz.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface RoleMapper extends BaseMapper<Role> {
//查询角色数量
    @Select("select count(1) from sys_user_role where role_Id = #{roleId}")
    int getRoleCountByRoleId(Long id);
    /*
     * 保存角色权限关系
     * */
    int saveRolePermission(Long roleId, List<Long> permissionIds);
    /*
     * 删除该角色的权限关系
     * */
    @Delete("delete from sys_role_permission where role_id =#{id}")
    void deleteRolePermissionByRoleId(Long id);
}
