package com.trkj.service.implLiucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryLiucz.RoleQueryVo;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface RoleService extends IService<Role> {
    /*
    * 根据账号id查询角色列表
    * */
    IPage<Role> findRoleListById(IPage<Role> page, RoleQueryVo roleQueryVo);
    //检查角色是否分配账号
    boolean hashRoleCount(Long id);
    //保存分配好的权限数据
    boolean saveRolePermission(Long roleId, List<Long> permissionIds);
}
