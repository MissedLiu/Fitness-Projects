package com.trkj.vo.queryTqw;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class LockerQueryVo extends PageVo {
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
     *电话
     *
     */
    private String memberPhone;
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
    *创建时间
    *
    */
    private Date createTime;
    /*
    *
    *到期时间
    *
    */
    private Date endTime;
    /*
    *
    *储物柜编号
    *
    */
    private long lockerId;
    /*
    *
    *储物柜状态(0-已使用,1-未使用,3-不可用)
    *
    */
    private String lockerState;
}
