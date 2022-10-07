package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

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
    private Long memberId;

    /*
    *
    *签订日期
    *
    */
    private Date createDate;

    /*
    *
    *结束日期
    *
    */
    private Date endDate;
    /*
    *
    *合同类型
    *
    */
    private String compactType;

    /**
     * 签订套餐编号
     */
    private Long mmId;

    /**
     * 合同原件图片地址
     */
    private String photoAddress;

    /**
     * 业务员
     */
    private String salesman;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}