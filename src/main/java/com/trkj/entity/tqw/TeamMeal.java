package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 团操会员套餐表
 * @TableName team_meal
 */
@TableName(value ="team_meal")
@Data
public class TeamMeal implements Serializable {
    /**
     * 团操套餐编号
     */
    @TableId(type = IdType.AUTO)
    private Long teamId;

    /**
     * 套餐时长(一节,两节)
     */
    private String teamTime;

    /**
     * 套餐生效时间
     */
    private Date teamDate;

    /**
     * 套餐价格
     */
    private Long teamPrice;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Byte teamIs;

    /**
     * 套餐名
     */
    private String teamName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}