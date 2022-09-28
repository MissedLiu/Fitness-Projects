package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物品出库表
 * @TableName stock_out
 */
@TableName(value ="stock_out")
@Data
public class StockOut implements Serializable {
    /**
     * 物品出库编号
     */
    @TableId(type = IdType.AUTO)
    private Long outId;

    /**
     * 库存编号
     */
    private Long storeId;

    /**
     * 物品编号
     */
    private Long stockinId;

    /**
     * 物品数量
     */
    private Long storeNum;

    /**
     * 物品出库数量
     */
    private Long outNum;

    /**
     * 出库时间
     */
    private Date stockoutTime;

    /**
     * 是否出库(0-否,1-是)
     */
    private Integer outIs;

    /**
     * 物品类型
     */
    private String stockinType;

    /**
     * 物品名
     */
    private String stockinName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}