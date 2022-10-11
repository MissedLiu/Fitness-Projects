package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 套餐收入统计报表
 * @TableName proceeds
 */
@TableName(value ="proceeds")
@Data
public class Proceeds implements Serializable {
    /**
     * 编号
     */
    @TableId
    private Long proceedsId;

    /**
     * 套餐名称
     */
    private String mealName;

    /**
     * 项目名称
     */
    private String pName;

    /**
     * 套餐类型
     */
    private String mealType;

    /**
     * 金额
     */
    private Long proceedsPrice;

    /**
     * 创建时间
     */
    private Date proceedsTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}