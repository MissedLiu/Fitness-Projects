package com.trkj.dao.liucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryLiucz.UserQueryVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 账户表 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface UserMapper extends BaseMapper<User> {
    //按条件查询并且分页
    IPage<User> selectXmlPage3(IPage<User> page, @Param("query") UserQueryVo query);
     //根据账户id查询员工姓名
    User checkEmp(Long id);

    //根据用户名进行查询
    User findUserByUserName (String username);
    //根据账户id进行查询
    User findUserByUserId(Long id);
    /*
    * 根据账户id修改账户名和密码
    * */
    int UpdateUserByUserId(User user);
    //删除原来的用户与角色的关系
    @Delete("delete from sys_user_role where user_id=#{userId}")
    void deleteUserRole(Long userId);
    //保存用户角色关系
    int saveUserRole(Long userId, List<Long> roleIds);
    /*
     * 根据员工id查询账号信息
     * */
    List<User> findUserByEmpId(Long id);
    /*
    * 将选择的员工id添加到账户表上
    * */
    int updateUser(@Param("userId") Long userId, @Param("empId") Long empId);
///*
//* 根据员工id查询是否存在相关账号信息
//* */
//    User EmpcheckUser(Long empId);

    User EmpcheckUser2(@Param("empId") Long empId);


}
