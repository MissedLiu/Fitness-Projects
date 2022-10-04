package com.trkj.service.implLiucz.liucz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.entity.liucz.Permission;
import com.trkj.dao.liucz.PermissionMapper;
import com.trkj.entity.liucz.User;
import com.trkj.service.implLiucz.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.utils.MenuTree;
import com.trkj.vo.queryLiucz.PermissionQueryVo;
import com.trkj.vo.queryLiucz.RolePermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;

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
    @Resource
    private UserMapper userMapper;
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
    /*
     * 查询分配权限菜单列表
     * */
    @Override
    public RolePermissionVo findPermissionTree(Long userId, Long roleId) {
        //根据账户id查询出当前的登录用户信息
        User user=userMapper.selectById(userId);
        List<Permission> permissionList=null;
        //判断当前用户角色是否是超级管理员,则查询所有权限,如果不是管理员则只查询自己所拥有的权限
        if(user !=null && ObjectUtils.isEmpty(user) && user.getIsAdmin() == 1){
            //当前为超级管理员,拥有所有的权限
            permissionList=baseMapper.selectList(null);
        }else {
            //不为超级管理员,根据账户id查询 则只拥有自己账户下自己的权限
            permissionList=baseMapper.findPermissionListByUserId(userId);
        }
        //组装成树数据
        List<Permission> permissions=MenuTree.makeMenuTree(permissionList,0L);
        //查询要分配角色的原有的权限
        List<Permission>  rolePermission=baseMapper.findPermissionListByRoleId(roleId);
        //5.找出该角色存在的数据
        List<Long> listIds = new ArrayList<Long>();
        Optional.ofNullable(permissionList).orElse(new ArrayList<>())
                .stream()
                .filter(Objects::nonNull) //等同于 obj -> obj!=null
                .forEach(item -> {
                    Optional.ofNullable(rolePermission).orElse(new ArrayList<>())
                            .stream()
                            .filter(Objects::nonNull)
                            .forEach(obj -> {
                                if (item.getId().equals(obj.getId())) {
                                    listIds.add(obj.getId());
                                    return;
                                }
                            });
                });
        //创建
        RolePermissionVo vo=new RolePermissionVo();
        vo.setPermissionList(permissions);
        vo.setCheckList(listIds.toArray());
         return vo;
    }
}
