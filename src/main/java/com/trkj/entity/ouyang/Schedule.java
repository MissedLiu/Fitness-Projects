package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.trkj.entity.liucz2.CaigouShenhe;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
     * 采购人编号
     */
    @Min(value = 0,message = "采购人编号不能小与0")
    private  Long scheduleempId;
    /**
     * 物品名称
     */
    @NotNull(message = "物品名称不能为空")
    private String scheduleName;

    /**
     * 物品类型(器材,补剂,日常用品)
     */
    @NotNull(message = "物品类型不能为空")
    private String scheduleType;

    /**
     * 供货名称
     */
    @NotNull(message = "供货商名称不能为空")
    private String scheduleSupplier;

    /**
     * 单位
     */
    @NotNull(message = "物品单位不能为空")
    private String unit;

    /**
     * 供货地址
     */
    @NotNull(message = "供货地址不能为空")
    private String scheduleAddress;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    @Min(value = 0,message = "数量不能小于0")
    private Long scheduleNum;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    @Min(value = 0,message = "单价不能小于0")
    private Long schedulePrice;

    /**
     * 品牌
     */
    @NotNull(message = "品牌不能为空")
    private String brand;

    /**
     * 创建时间
     */
    private Date scheduleTime;

    /*
    * 状态
    */
    private Byte scheduleState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private CaigouShenhe caigouShenhe;

}