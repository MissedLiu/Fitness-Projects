package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.trkj.entity.liucz2.Weixg;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 器材损坏上报表
 * @TableName equipment_eamage
 */
@TableName(value ="equipment_eamage")
@Data
public class Eeamage implements Serializable {
    /**
     * 上报编号
     */
    @TableId(type = IdType.AUTO)
    private Long eeId;

    /**
     *
     * 器材编号(物品编号)
     */
    @NotNull(message = "器材编号不能为空")
    @Min(value = 0,message = "器材编号不能小于0")
    private String edCode;

    /**
     * 器材名称
     */
    @NotNull(message = "器材名不能为空")
    private String eeName;

    /**
     * 登记时间
     */
    private Date eeTime;

    /**
     * 故障原因
     */
    @NotNull(message = "器材名不能为空")
    private String eeContent;

    /**
     * 备注
     */
    private String beizhu;

    /**
     * 上报人
     */
    @NotNull(message = "器材名不能为空")
    private String sname;
    /**
     * 状态
     */
    private Byte state;
    @TableField(exist = false)
    private Weixg weixg;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}