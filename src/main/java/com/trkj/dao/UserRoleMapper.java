package com.trkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.User;
import com.trkj.vo.query.UserQueryVo;
import com.trkj.vo.query.UserRoleQueryVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

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
