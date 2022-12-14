package com.trkj.entity.liucz;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User implements Serializable , UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 账户编号
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 员工编号
     */
    private Long empId;

    /**
     * 登录名称(用户名)
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 帐户是否过期(1-未过期，0-已过期)
     */
    private boolean isAccountNonExpired =true;

    /**
     * 帐户是否被锁定(1-未过期，0-已过期)
     */
    private boolean isAccountNonLocked =true;

    /**
     * 密码是否过期(1-未过期，0-已过期)
     */
    private boolean isCredentialsNonExpired =true;

    /**
     * 帐户是否可用(1-可用，0-禁用)
     */
    private boolean isEnabled =true;

    /**
     * 所属部门ID
     */
    private Long departmentId;

    /**
     * 所属部门名称
     */
    private String departmentName;

    /**
     * 是否是管理员(1-管理员)
     */
    private Integer isAdmin;
    /**
     * @description:
     * 创建账户id
     * @author: Liucz
     * @date: 2022/10/19 20:07
     * @param:
     * @return:
     **/
    private  Long createUser;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除(0-未删除，1-已删除)
     */
    private Integer isDelete;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;
    /**
     * 查询用户权限列表
     */
    @TableField(exist = false)
    private List<Permission> permissionList;

    @TableField(exist = false)
    private Emp emp;

}
