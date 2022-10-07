package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户咨询表
 * @TableName member_consult
 */
@TableName(value ="member_consult")
@Data
public class MemberConsult implements Serializable {
    /**
     * 咨询编号
     */
    @TableId(type = IdType.AUTO)
    private Long consultId;

    /**
     * 姓名
     */
    private String consultName;

    /**
     * 年龄
     */
    private Integer consultAge;

    /*
    *
    *电话
    *
    */
    private String consultPhone;

    /**
     * 性别(0-女,1-男)
     */
    private Byte consultSex;

    /**
     * 咨询内容
     */
    private String consultContent;

    /**
     * 时间
     */
    private Date consultTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}