package com.trkj.service.impl;

import com.trkj.entity.Permission;
import com.trkj.dao.PermissionMapper;
import com.trkj.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
