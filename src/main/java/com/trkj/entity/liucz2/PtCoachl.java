package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 私教套餐的教练关系表
 * @TableName pt_coach
 */
@TableName(value ="pt_coach")
@Data
public class PtCoachl implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long ptId;

    /**
     * 
     */
    private Long empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private List<PtMeal> ptMeals;
}