package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 团操套餐的教练关系表
 * @TableName team_coach
 */
@TableName(value ="team_coach")
@Data
public class TeamCoach implements Serializable {
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
     * 员工编号（教练编号）
     */
    private Long empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}