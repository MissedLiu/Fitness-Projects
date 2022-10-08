package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 教练教学授课信息表
 * @TableName schoolteaching
 */
@TableName(value ="schoolteaching")
@Data
public class Schoolteaching implements Serializable {
    /**
     * 教练教学信息编号
     */
    @TableId(type = IdType.AUTO)
    private Long stId;

    /**
     * 教练编号
     */
    private Long empId;

    /**
     * 教练姓名
     */
    private String empName;

    /**
     * 套餐编号(团操套餐编号,私教套餐编号)
     */
    private Long mealId;

    /**
     * 套餐名称
     */
    private String mealName;

    /**
     * 套餐类型(私教,团操)
     */
    private String mealType;

    /**
     * 项目编号
     */
    private Long projectnameId;

    /**
     * 项目名称
     */
    private String projectName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}