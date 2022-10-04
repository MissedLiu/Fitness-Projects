package com.trkj.vo.queryLiucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 私教项目类型表
 * @TableName pt_project
 */

@Data
public class PtProjectVo extends PageVo {
    /**
     * 项目编号
     */

    private Long ptpId;

    /**
     * 项目名称(减脂或塑形.)
     */
    private String ptpName;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Integer ptpIs;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}