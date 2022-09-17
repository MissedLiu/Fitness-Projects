package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.entity.User;
import com.trkj.dao.UserMapper;
import com.trkj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //根据用户名进行查询
    @Override
    public User findUserByUserName(String username) {
        //创建条件构造器对象
        QueryWrapper<User> qw=new QueryWrapper<User>();
        qw.eq("username",username);
        //执行查询
        return baseMapper.selectOne(qw);
    }
}
