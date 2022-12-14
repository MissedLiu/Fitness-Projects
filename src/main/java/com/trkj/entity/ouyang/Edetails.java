package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @TableName equipment_details
 */
@TableName(value ="equipment_details")
@Data
public class Edetails implements Serializable {
    /**
     * 器材使用详情id
     */
    @TableId(type = IdType.AUTO)
    private Long edId;

    /**
     * 物品id
     */
    @NotNull(message = "物品id不能为空")
    @Min(value = 0,message = "物品id不能小于0")
    private Long stockinId;

    /**
     * 器材名
     */
    @NotNull(message = "器材名不能为空")
    private String edName;

    /**
     * 器材编码
     */
    @NotNull(message = "器材编码不能为空")
    private String edCode;

    /**
     * 开始使用时间
     */
    private Date edTime;

    /**
     * 器材状态
     */
    private Long edState;

    /**
     * 备注
     */
    private String beizhu;

    private String brand;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}