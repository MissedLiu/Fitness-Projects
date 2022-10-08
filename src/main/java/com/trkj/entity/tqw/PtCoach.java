package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 私教套餐的教练关系表
 * @TableName pt_coach
 */
@TableName(value ="pt_coach")
@Data
public class PtCoach implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long ptId;

    /**
     * 
     */
    private Long empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}