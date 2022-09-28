package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
    private Long scheduleId;

    /**
     * 物品名称
     */
    private String poName;

    /**
     * 物品数量
     */
    private Long poNum;

    /**
     * 单价
     */
    private Long poPrice;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 供货地址
     */
    private String scheduleAddress;

    /**
     * 供货名称
     */
    private String scheduleSupplier;

    /**
     * 创建时间
     */
    private Date poTime;

    /**
     * 物品类型
     */
    private String poType;

    private String poState;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}