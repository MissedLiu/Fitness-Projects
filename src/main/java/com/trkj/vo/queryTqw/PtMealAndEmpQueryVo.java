package com.trkj.vo.queryTqw;

import com.trkj.entity.liucz.Emp;
import lombok.Data;

import java.util.Date;

@Data
public class PtMealAndEmpQueryVo extends Emp {
    private long ptId;                  //私教套餐编号',
    private String ptTime;        //套餐时长(月卡,周卡)',
    private Date ptDate;               //套餐生效时间',
    private long ptPrice;              //套餐价格,
    private int ptIs;                  //是否禁用(0-禁用,1-使用)',
    private String ptName;             //套餐名字
}
