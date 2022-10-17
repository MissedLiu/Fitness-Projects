package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 归档信息表
 * @TableName on_file
 */
@TableName(value ="on_file")
@Data
public class OnFile implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    @Min(value = 0,message = "金额不能小于0")
    private BigDecimal money;

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private String type;

    /**
     * 档案日期
     */
    @NotNull(message = "归档日期不能为空")
    private Date date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}