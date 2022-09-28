package com.trkj.entity.liucz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Data
public class EmpAndUser {
    /**
     * 员工编号
     */
    private Long empId;

    /**
     * 姓名
     */
    private String empName;

    /**
     * 年龄
     */
    private Integer empAge;

    /**
     * 性别
     */
    private String empSex;

    /**
     * 住址
     */
    private String empAddress;

    /**
     * 电话
     */
    private String empPhone;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String emil;

    /**
     * qq
     */
    private String qq;

    /**
     * 微信
     */
    private String weix;

    /**
     * 所属部门ID
     */
    private Long departmentId;

    /**
     * 所属部门名称
     */
    private String departmentName;


    /**
     * 岗位
     */
    private String station;

    /**
     * 简介
     */
    private String synopsis;
/*
* 账户名
* */
    private String username;
    /*
    * 账户id
    * */
    private Long id;

}