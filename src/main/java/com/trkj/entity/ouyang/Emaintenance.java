package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 器材维修表
 * @TableName equipment_maintenance
 */
@TableName(value ="equipment_maintenance")
@Data
public class Emaintenance implements Serializable {
    /**
     * 维修编号
     */
    @TableId(type = IdType.AUTO)
    private Long emId;

    /**
     * 维修人姓名
     */
    @NotNull(message = "维修人姓名不能为空")
    private String empName;

    /**
     * 上报编号
     */
    @NotNull(message = "上报编号不能为空")
    @Min(value = 0,message = "上报编号不能小于0")
    private Long eeId;

    /**
     * 维修日期
     */
    private Date emTime;

    /**
     * 维修情况
     */
    @NotNull(message = "维修情况不能为空")
    private String resuIts;

    /**
     * 问题解决方式(0-自修,1-换件,2,外修)
     */
    @NotNull(message = "问题解决方式不能为空")
    @Min(value = 0,message = "问题解决方式有误")
    @Max(value = 2,message = "问题解决方式有误")
    private Integer methods;

    @NotNull(message = "器材名不能为空")
    private String edName;

    @NotNull(message = "器材标识编码不能为空")
    private String edCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}