package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 支出统计报表
 * @TableName disburse
 */
@TableName(value ="disburse")
@Data
public class Disburse implements Serializable {
    /**
     * 编号
     */
    @TableId
    private Long disburseId;

    /**
     * 支出项目类型(商品,器材,其他)
     */
    private String disburseType;

    /**
     * 创建时间
     */
    private Date disburseTime;

    /**
     * 支出金额
     */
    private Long disbursePrice;

    /**
     * 备注
     */
    private String beizhu;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}