package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
     * 维修人编号
     */
    private String empName;

    /**
     * 上报编号
     */
    private Long eeId;

    /**
     * 维修日期
     */
    private Date emTime;

    /**
     * 维修情况
     */
    private String resuIts;

    /**
     * 问题解决方式(0-自修,1-换件,2,外修)
     */
    private Integer methods;

    private String edName;
    private String edCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}