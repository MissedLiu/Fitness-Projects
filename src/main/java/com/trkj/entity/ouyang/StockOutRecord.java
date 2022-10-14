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
 * 物品出库记录表
 * @TableName stock_out_record
 */
@TableName(value ="stock_out_record")
@Data
public class StockOutRecord implements Serializable {
    /**
     * 物品出库编号
     */
    @TableId(type = IdType.AUTO)
    private Long outId;

    /**
     * 库存编号
     */
    @NotNull(message = "库存编号不能为空")
    @Min(value = 0, message = "库存编号不能小于0")
    private Long storeId;

    /**
     * 物品编号
     */
    @NotNull(message = "物品编号不能为空")
    @Min(value = 0, message = "物品编号不能小于0")
    private Long stockinId;

    /**
     * 
     */
    @NotNull(message = "物品名不能为空")
    private String stockinName;


    /**
     * 物品出库数量
     */
    @NotNull(message = "出库数量不能为空")
    @Min(value = 0, message = "出库数量不能小于0")
    private Long outNum;

    /**
     * 是否出库(0-否,1-是)
     */
    private Integer outIs;

    /**
     * 物品类型
     */
    @NotNull(message = "物品类型不能为空")
    private String stockinType;

    /**
     * 出库时间
     */
    private Date stockoutTime;

    /**
     * 品牌
     */
    @NotNull(message = "品牌不能为空")
    private String brand;

    /**
     * 领取人（员工名）
     */
    @NotNull(message = "领取人姓名不能为空")
    private String empName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}