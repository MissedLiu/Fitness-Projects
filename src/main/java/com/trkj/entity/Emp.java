package com.trkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_emp")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
      @TableId(value = "emp_id", type = IdType.AUTO)
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 岗位
     */
    private String station;

    /**
     * 简介
     */
    private String synopsis;


}
