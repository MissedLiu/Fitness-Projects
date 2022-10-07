package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName allot_prospect
 */
@TableName(value ="allot_prospect")
@Data
public class AllotProspect implements Serializable {
    /**
     * 分配编号
     */
    @TableId(type = IdType.AUTO)
    private Long allotId;

    /**
     * 潜在客户记录编号
     */
    private Long prospectId;

    /**
     * 客服编号
     */
    private Long empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}