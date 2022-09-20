package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.entity.Permission;
import com.trkj.dao.PermissionMapper;
import com.trkj.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.utils.MenuTree;
import com.trkj.vo.query.PermissionQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    //根据用户ID查询权限菜单列表
    @Override
    public List<Permission> findPermissionListByUserId(Long id) {
        return baseMapper.findPermissionListByUserId(id);
    }

    @Override
    public List<Permission> findPermissionList(PermissionQueryVo permissionQueryVo) {
        //创建条件查询构造器
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        //排序
        queryWrapper.orderByAsc("order_num");
        //调用查询菜单列表
        List<Permission> permissionList=baseMapper.selectList(queryWrapper);
        //生成菜单数
        List<Permission> menuTree= MenuTree.makeMenuTree(permissionList,0L);
        return menuTree;
    }
    //查询上级菜单列表
    @Override
    public List<Permission> findParentPermissionList() {
        //创建条件构造器
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        //只查询type为目录和菜单的数据(type=0,type=1)
        queryWrapper.in("type", Arrays.asList(0,1));
        //排序
        queryWrapper.orderByAsc("order_num");
        //查询菜单数据
        List<Permission> permissionList=baseMapper.selectList(queryWrapper);
        //构造顶级菜单信息,如果数据库中的菜单表没有数据,选择上级菜单时则显示顶级菜单
        Permission permission=new Permission();
        permission.setId(0L);
        permission.setParentId(-1L);
        permission.setLabel("顶级菜单");
        permissionList.add(permission);
        //生成菜单数据
        List<Permission> permissions=MenuTree.makeMenuTree(permissionList,-1L);
        return permissions;
    }
    //检查菜单是否有子菜单
    @Override
    public boolean hasChildrenOfPermission(Long id) {
        //创建条件构造器
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        //查询父id
        queryWrapper.eq("parent_id",id) ;
        //判断父id下是否有子菜单,如果有数量大于零,则返回false
        if (baseMapper.selectCount(queryWrapper)>0){
                return true;
        }
         return false;
    }
}
