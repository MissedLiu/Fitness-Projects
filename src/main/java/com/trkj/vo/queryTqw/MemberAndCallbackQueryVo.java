package com.trkj.vo.queryTqw;

import com.trkj.vo.query.PageVo;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import java.util.Date;

@Data
public class MemberAndCallbackQueryVo extends PageVo2 {
    /*
     *
     *会员编号
     *
     */
    private long memberId;
    /*
     *
     *会员姓名
     *
     */
    private String memberName;
    /*
     *
     *会员性别
     *
     */
    private int memberSex;
    /*
     *
     *出生日期
     *
     */
    private Date memberDate;
    /*
     *
     *电话
     *
     */
    private String memberPhone;
    /*
     *
     *年龄(0-女,1-男)
     *
     */
    private int memberAge;
    /*
     *
     *住址
     *
     */
    private String memberAddress;
    /*
     *
     *会员状态(是否禁用)
     *
     */
    private int memberState;
    /*
     *
     *会员类型(0-体验,1-会员)
     *
     */
    private int memberType;
    /*
     *
     *更新时间
     *
     */
    private Date updateTime;
    /*
     *
     *创建时间
     *
     */
    private Date createTime;
    /**
     * 内容
     */
    private String callbackContent;

    /**
     * 时间
     */
    private Date columnTime;
    /*
    *
    *回访记录id
    *
    */
    private Long callbackId;
    /*
    *
    *员工id
    *
    */
    private Long empId;
}
