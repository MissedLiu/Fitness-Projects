package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 物品已购表
 * @TableName po
 */
@TableName(value ="po")
@Data
public class Po implements Serializable {
    /**
     * 物品编号
     */
    @TableId(type = IdType.AUTO)
    private Long poId;

    /**
     * 编号
     */
    @NotNull(message = "采购计划编号不能为空")
    @Min(value = 0,message = "采购计划编号不能小于0")
    private Long scheduleId;

    /**
     * 物品名称
     */
    @NotNull(message = "物品名不能为空")
    private String poName;

    /**
     * 物品数量
     */
    @NotNull(message = "数量不能为空")
    @Min(value = 0,message = "数量不能小于0")
    private Long poNum;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    @Min(value = 0,message = "单价不能小于0")
    private Long poPrice;

    /**
     * 品牌
     */
    @NotNull(message = "品牌不能为空")
    private String brand;

    /**
     * 供货地址
     */
    @NotNull(message = "供货地址不能为空")
    private String scheduleAddress;

    /**
     * 供货名称
     */
    @NotNull(message = "供货名称不能为空")
    private String scheduleSupplier;

    /**
     * 创建时间
     */
    private Date poTime;

    /**
     * 物品类型
     */
    @NotNull(message = "物品类型不能为空")
    private String poType;

    private String poState;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}