package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 普通会员套餐表
 * @TableName common_meal
 */
@TableName(value ="common_meal")
@Data
public class CommonMeal implements Serializable {
    /**
     * 普通套餐编号
     */
    @TableId(type = IdType.AUTO)
    private Long cmId;

    /**
     * 套餐时长(月卡,周卡)
     */
    private String cmTime;

    /**
     * 套餐生效时间
     */
    private Date cmDate;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 套餐价格
     */
    private Long cmPrice;

    /**
     * 是否禁用(1-禁用,0-使用)
     */
    private Byte cmIs;

    /**
     * 套餐名
     */
    private String cmName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}