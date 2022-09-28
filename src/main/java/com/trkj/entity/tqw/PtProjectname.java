package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 私教项目类型表
 * @TableName pt_projectname
 */
@TableName(value ="pt_projectname")
@Data
public class PtProjectname implements Serializable {
    /**
     * 项目编号
     */
    @TableId(type = IdType.AUTO)
    private Long ptpId;

    /**
     * 项目名称(减脂或塑形.)
     */
    private String ptpName;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Byte ptpIs;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}