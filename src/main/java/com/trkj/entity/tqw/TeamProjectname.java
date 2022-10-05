package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 团操项目类型表
 * @TableName team__projectname
 */
@TableName(value ="team_projectname")
@Data
public class TeamProjectname implements Serializable {
    /**
     * 项目编号
     */
    @TableId(type = IdType.AUTO)
    private Long tpId;

    /**
     * 项目名称(动感单车或瑜伽...)
     */
    private String tpName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Byte tpIs;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}