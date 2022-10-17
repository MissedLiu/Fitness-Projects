package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 报损报溢表
 * @TableName changenum
 */
@TableName(value ="changenum")
@Data
public class Changenum implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 物品编号
     */
    @Pattern(regexp = "^[1-9]\\d*$")
    @NotNull(message="物品编号不能为空")
    private Long shoppingId;

    /**
     * 报损数
     */
    @Pattern(regexp = "^[1-9]\\d*|0$")
    @NotNull(message="报损数不能为空")
    private Long changeLose;

    /**
     * 报溢数
     */
    @Pattern(regexp = "^[1-9]\\d*|0$")
    @NotNull(message="报溢数不能为空")
    private Long changeMore;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}