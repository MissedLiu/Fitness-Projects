package com.trkj.vo.queryTqw;

import lombok.Data;

import java.util.List;

@Data
public class EmpAndPtMealQueryVo {
    //教练id
    private Long empId;
    //套餐列表
    private List<Long> ptMealId;
}
