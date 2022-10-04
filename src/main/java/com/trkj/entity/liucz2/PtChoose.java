package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 私教套餐项目关联表
 * @TableName pt_choose
 */
@TableName(value ="pt_choose")
@Data
public class PtChoose implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 私教套餐编号
     */
    private Long ptId;

    /**
     * 项目编号
     */
    private Long ptpId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}