package com.trkj.vo.queryLiucz;

import com.trkj.vo.query.PageVo;
import lombok.Data;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Data
public class EmpAndUserQueryVo extends PageVo {
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

}