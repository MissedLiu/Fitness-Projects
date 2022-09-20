package com.trkj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 物品库存表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 库存编号
     */
    @TableId
    private Long storeId;

    /**
     * 物品编号
     */
    private Long poId;

    /**
     * 物品名称
     */
    private String stockinName;

    /**
     * 物品数量
     */
    private Long stockinNum;

    /**
     * 库存数量
     */
    private Long storeNum;

    /**
     * 物品类型
     */
    private String stockinType;

    /**
     * 品牌
     */
    private String brand;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}