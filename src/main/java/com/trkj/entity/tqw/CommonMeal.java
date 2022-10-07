package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/*
*
*普通套餐
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_meal")
public class CommonMeal {
    private static final long serialVersionUID = 1L;
    @TableId(value = "cm_id", type = IdType.AUTO)
    private int cmId;                  //普通套餐编号',
    private String cmTime;        //套餐时长(月卡,周卡)',
    private Date cmDate;               //套餐生效时间',
    private long cmPrice;              //套餐价格,
    private int cmIs;                  //是否禁用(0-禁用,1-使用)',
    private String cmName;             //套餐名字
}
