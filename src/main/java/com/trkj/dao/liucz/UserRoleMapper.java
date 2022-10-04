package com.trkj.dao.liucz;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.liucz.User;
import com.trkj.vo.queryLiucz.UserRoleQueryVo;

import java.util.List;

/**
 * <p>
 * 账户表与角色 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface UserRoleMapper extends BaseMapper<User> {

    /*
    * 通过账户id查询所拥有的岗位
    * */
    List<UserRoleQueryVo> findUserAndRoleById(Long id);

}
