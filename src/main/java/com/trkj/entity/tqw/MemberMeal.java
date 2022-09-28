package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/*
*
*会员办理套餐
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("member_meal")
public class MemberMeal {
    /*
    *
    *套餐办理编号
    *
    */
    @TableId(value = "mm_Id", type = IdType.AUTO)
    private long mmId;
    /*
    *
    *会员编号
    *
    */
    private long memberId;
    /*
    *
    *所选套餐编号
    *
    */
    private long mealId;
    /*
    *
    *所选套餐类型(私教,团操,普通)
    *
    */
    private String mealType;
    /*
    *
    *套餐办理时间
    *
    */
    private Date mmTime;
    /*
    *
    *套餐到期时间
    *
    */
    private Date mmDate;
}
