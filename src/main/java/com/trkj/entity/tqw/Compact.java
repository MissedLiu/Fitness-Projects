package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 
 * @TableName compact
 */
@TableName(value ="compact")
@Data
public class Compact implements Serializable {
    /**
     * 合同编号
     */
    @TableId(type = IdType.AUTO)
    private Long compactId;

    /*
    *
    *会员编号
    *
    */
    @NotNull(message = "会员编号不能为空")
    private Long memberId;

    /*
    *
    *签订日期
    *
    */
    @NotNull(message = "签订日期不能为空")
    private Date createDate;

    /*
    *
    *结束日期
    *
    */
    @NotNull(message = "结束日期不能为空")
    private Date endDate;
    /*
    *
    *合同类型
    *
    */
    @NotNull(message = "合同类型不能为空")
    private String compactType;

    /**
     * 签订套餐编号
     */
    @NotNull(message = "套餐签订编号不能为空")
    private Long mmId;

    /**
     * 合同原件图片地址
     */
    @NotNull(message = "原件图片1不能为空")
    private String photoAddress;

    /**
     * 合同原件图片地址2
     */
    @NotNull(message = "原件图片2不能为空")
    private String photoAddress2;

    /**
     * 合同原件图片地址3
     */
    @NotNull(message = "原件图片3不能为空")
    private String photoAddress3;

    /**
     * 合同原件图片地址4
     */
    private String photoAddress4;

    /**
     * 合同原件图片地址5
     */
    private String photoAddress5;

    /**
     * 业务员
     */
    @NotNull(message = "业务员不能为空")
    private String salesman;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}