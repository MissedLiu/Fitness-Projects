package com.trkj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物品采购计划表
 * @TableName schedule
 */
@TableName(value ="schedule")
@Data
public class Schedule implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long scheduleId;

    /**
     * 物品名称
     */
    private String scheduleName;

    /**
     * 物品类型(器材,补剂,日常用品)
     */
    private String scheduleType;

    /**
     * 供货名称
     */
    private String scheduleSupplier;

    /**
     * 单位
     */
    private String unit;

    /**
     * 供货地址
     */
    private String scheduleAddress;

    /**
     * 数量
     */
    private Long scheduleNum;

    /**
     * 单价
     */
    private Long schedulePrice;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 创建时间
     */
    private Date scheduleTime;

    /*
    * 状态
    */
    private String scheduleState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}