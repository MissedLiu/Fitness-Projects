package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教练会员访谈记录表
 * @TableName interview
 */
@TableName(value ="interview")
@Data
public class Interview implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long interviewId;

    /**
     * 教练编号
     */
    private Long empId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 会员姓名
     */
    private  String memberName;
    /**
     * 会员类型(0-体验会员,1-会员)
     */
    private Byte memberType;

    /**
     * 访谈日期
     */
    private Date createTime;

    /**
     * 访谈内容
     */
    private String interview;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}