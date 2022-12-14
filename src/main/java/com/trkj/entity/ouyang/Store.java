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
 * 物品库存表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 库存编号
     */
    @TableId(type = IdType.AUTO)
    private Long storeId;

    /**
     * 物品编号
     */
    @NotNull(message = "物品编号不能为空")
    @Min(value = 0, message = "物品编号不能小于0")
    private Long poId;

    /**
     * 物品名称
     */
    @NotNull(message = "物品名不能为空")
    private String stockinName;

    /**
     * 物品数量
     */
    @NotNull(message = "最近入库数不能为空")
    @Min(value = 0, message = "最近入库数不能小于0")
    private Long stockinNum;

    /**
     * 库存数量
     */
    @NotNull(message = "库存数不能为空")
    @Min(value = 0, message = "库存数不能小于0")
    private Long storeNum;

    /**
     * 物品类型
     */
    @NotNull(message = "物品类型不能为空")
    private String stockinType;

    /**
     * 品牌
     */
    @NotNull(message = "品牌不能为空")
    private String brand;

    //最后修改时间
    private Date stockinTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}