package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import java.util.Date;

/*
*
*会员和黑名单
*
*/
@Data
public class MemberAndBlackQueryVo extends PageVo2 {
    private long id;//黑名单编号
    private Date createTime;//拉黑时间
    private String why;//原因
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
}
