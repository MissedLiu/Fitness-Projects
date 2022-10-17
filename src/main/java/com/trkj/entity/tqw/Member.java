package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;

/*
 * 会员
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`member`")
public class Member {
    private static final long serialVersionUID = 1L;
    //会员编号
    @TableId(value = "member_Id", type = IdType.AUTO)
    private Long memberId;
    //会员姓名
    @NotNull(message = "名字不能为空")
    private String memberName;
    //会员性别
    @NotNull(message = "性别不能为空")
    @Range(min = 0, max = 1, message = "性别选择错误")
    private int memberSex;
    //出生日期
    @NotNull(message = "出生日期不能为空")
    private Date memberDate;
    //电话
    @NotNull(message = "电话不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$",message = "电话输入有误")
    private String memberPhone;
    //年龄
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄输入错误")
    @Max(value = 100, message = "年龄输入错误")
    private int memberAge;
    //住址
    @NotNull(message = "住址不能为空")
    @Pattern(regexp = "^[\u4e00-\u9fa5]{0,20}$",message = "地址输入有误")
    private String memberAddress;
    //会员状态(是否禁用)
    private int memberState;
    //会员类型(0-体验,1-会员)
    private int memberType;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
