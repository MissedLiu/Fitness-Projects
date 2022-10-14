package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.CommonMeall;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

@Data
public class BlackMemberMealQueryVo extends MemberMeal {
    //套餐名称
    private String mealName;
    //套餐金额
    private long mealPrice;
}
