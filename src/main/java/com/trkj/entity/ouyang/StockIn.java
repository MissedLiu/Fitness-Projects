package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 物品入库表
 * @TableName stock_in
 */
@TableName(value ="stock_in")
@Data
public class StockIn implements Serializable {
    /**
     * 入库编号
     */
    @TableId
    private Long inId;

    /**
     * 物品编号
     */
    @Min(value = 0,message = "物品编号不能小于0")
    @NotNull(message = "物品编号不能为空")
    private Long poId;

    /**
     * 物品名称
     */
    @NotNull(message = "物品名不能为空")
    private String inName;

    /**
     * 物品数量
     */
    @NotNull(message = "数量不能为空")
    @Min(value = 0,message = "数量不能小于0")
    private Long inNum;

    /**
     * 入库时间
     */
    private Date inTime;

    /**
     * 物品类型
     */
    @NotNull(message = "物品类型不能为空")
    private String inType;

    /**
     * 品牌
     */
    @NotNull(message = "品牌不能为空")
    private String brand;

    /**
     * 是否入库(0-否,1-是)
     */
    private Integer inIs;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}