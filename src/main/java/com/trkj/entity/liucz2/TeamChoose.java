package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 团操套餐项目关联表
 * @TableName team_choose
 */
@TableName(value ="team_choose")
@Data
public class TeamChoose implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 团操套餐编号
     */
    private Long teamId;

    /**
     * 项目编号
     */
    private Long tpId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}