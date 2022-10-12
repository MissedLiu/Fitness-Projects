package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 采购计划审核
 * @TableName caigou_shenhe
 */
@TableName(value ="caigou_shenhe")
@Data
public class CaigouShenhe implements Serializable {
    /**
     * 编号
     */
    @TableId
    private Long id;

    /**
     * 采购编号
     */
    private Long scheduleId;

    /**
     * 审核人id
     */
    private Long shenheempId;

    /**
     * 审核结果(0-待审,2-拒绝,1-同意)
     */
    private Byte state;
    private String result;
    @TableField(exist = false)
    private String empName;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}