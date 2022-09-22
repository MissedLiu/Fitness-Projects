package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.dao.UserMapper;
import com.trkj.entity.Role;
import com.trkj.dao.RoleMapper;
import com.trkj.entity.User;
import com.trkj.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.vo.query.RoleQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    /*
     * 根据账号id查询角色列表
     * */
    @Override
    public IPage<Role> findRoleListById(IPage<Role> page, RoleQueryVo roleQueryVo) {
        //创建条件构造器
        QueryWrapper<Role> queryWrapper=new QueryWrapper<Role>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(roleQueryVo.getRoleName()),"role_name",roleQueryVo.getRoleName());
        //排序
        queryWrapper.orderByAsc("id");
        //根据账户id查询账户信息
        User user=userMapper.selectById(roleQueryVo.getUserId());
        //如果不为空,并且不是管理员,则只能查询自己创建的角色
        if(user !=null && !ObjectUtils.isEmpty(user.getIsAdmin()) && user.getIsAdmin() !=1){
            queryWrapper.eq("create_user" , roleQueryVo.getUserId());
        }
        return baseMapper.selectPage(page,queryWrapper);
    }
    //检查角色是否分配账号
    @Override
    public boolean hashRoleCount(Long id) {
        return baseMapper.getRoleCountByRoleId(id) >0 ;
    }
    //保存分配好的权限数据
    @Override
    public boolean saveRolePermission(Long roleId, List<Long> permissionIds) {
        //分配之前先删除已有的权限数据
        baseMapper.deleteRolePermissionByRoleId(roleId);
        //添加分配好的权限数据
        return baseMapper.saveRolePermission(roleId,permissionIds)>0;
    }
}
