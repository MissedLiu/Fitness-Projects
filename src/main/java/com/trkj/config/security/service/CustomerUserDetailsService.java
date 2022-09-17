package com.trkj.config.security.service;

import com.trkj.entity.Permission;
import com.trkj.entity.User;
import com.trkj.service.PermissionService;
import com.trkj.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 用户认证处理器类
 * */
@Component//注入spring ioc容器中
public class CustomerUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用根据用户查询用户信息的方法
        User user = userService.findUserByUserName(username);
        //判断是否为空
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码输入错误");
        }
        //查询用户的拥有的权限列表
        List<Permission> permissionList = permissionService.findPermissionListByUserId(user.getId());
        //获取权限编码
        List<String> collect = permissionList.stream()
                .filter(item -> item != null)
                .map(item -> item.getCode()).filter(item -> item != null)
                .collect(Collectors.toList());
        //转换成数组
        String[] strings = collect.toArray(new String[collect.size()]);
        //设置权限列表
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(strings);
        user.setAuthorities(authorityList);
        //设置菜单列表
        user.setPermissionList(permissionList);

        return user;
    }
}
