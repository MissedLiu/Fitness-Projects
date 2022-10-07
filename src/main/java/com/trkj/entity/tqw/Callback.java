package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 客服回访记录表
 * @TableName callback
 */
@TableName(value ="callback")
@Data
public class Callback implements Serializable {
    /**
     * 回访编号
     */
    @TableId(type = IdType.AUTO)
    private Long callbackId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 内容
     */
    private String callbackContent;

    /**
     * 时间
     */
    private Date columnTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}