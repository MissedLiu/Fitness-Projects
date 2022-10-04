package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程销售记录表
 * @TableName sales
 */
@TableName(value ="sales")
@Data
public class Sales implements Serializable {
    /**
     * 课程销售记录编号
     */
    @TableId(type = IdType.AUTO)
    private Long salesId;

    /**
     * 销售人员编号
     */
    private Long salesmanId;

    /**
     * 套餐编号
     */
    private Long mealId;

    /**
     * 套餐名称
     */
    private String mealName;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 会员电话
     */
    private String memberPhone;
    /**
     * 时长
     */
    private  String mealTime;
    /**
     * 项目编号
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 类型
     */
    private String type;



    /**
     * 金额
     */
    private Long salesPrice;

    /**
     * 是否购买从成功(0-未购买,1-已购买)
     */
    private Byte state;

    /**
     * 创建时间
     */
    private Date salesTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}