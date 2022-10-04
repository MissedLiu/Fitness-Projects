package com.trkj.service.implLiucz;

import com.trkj.entity.liucz.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账户表 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface UserService extends IService<User> {
    //根据用户名进行查询
    User findUserByUserName(String username);
}
