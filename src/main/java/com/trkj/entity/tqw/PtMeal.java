package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/*
*
*私教套餐
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pt_meal")
public class PtMeal {
    private static final long serialVersionUID = 1L;
    @TableId(value = "pt_id", type = IdType.AUTO)
    private int ptId;                  //私教套餐编号',
    private String ptTime;        //套餐时长(月卡,周卡)',
    private Date ptDate;               //套餐生效时间',
    private long ptPrice;              //套餐价格,
    private int ptIs;                  //是否禁用(0-禁用,1-使用)',
    private String ptName;             //套餐名字
}
