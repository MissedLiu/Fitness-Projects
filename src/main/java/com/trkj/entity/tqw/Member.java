package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.query.PageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 会员
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`member`")
public class Member{
    private static final long serialVersionUID = 1L;
    /*
    *
    *会员编号
    *
    */
    @TableId(value = "member_Id", type = IdType.AUTO)
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
    *创建时间
    *
    */
    private Date createTime;
    /*
    *
    *更新时间
    *
    */
    private Date updateTime;


}
