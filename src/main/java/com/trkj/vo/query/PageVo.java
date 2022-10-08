package com.trkj.vo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageVo {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
    private String username; //账户名;
    private String ptpName; //私教项目名
    private Long ptId;//私教套餐id
    private String tpName; //团操项目名
    private String cmName;//普通套餐名称
    private String stockingName;//商品名称
    private String invoicedName;//购买人姓名
    private Long saempId ;//当前销售人id用于判断查询该账户下的商品记录
    private String teamName;//团操套餐名
    private String ptName;//私教套餐名
    private String mealName;//课程销售套餐名
    private String memberName;//课程销售会员名
    private String type;//课程销售类型
    private  Long salesmanId;//当前销售人id用于判断查询该账户下的课程记录
    private Long shenheempId;//当前审批采购人id
    private Long empId;//当前教练id


}
