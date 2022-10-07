package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 维修工分配
 * @TableName weixg
 */
@TableName(value ="weixg")
@Data
public class Weixg implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 维修工编号
     */
    private Long weixgId;

    /**
     * 维修工姓名
     */
    private String weixgName;

    /**
     * 上报编号
     */
    private Long eeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}