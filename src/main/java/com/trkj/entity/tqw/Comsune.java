package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comsune
 */
@TableName(value ="comsune")
@Data
public class Comsune implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long comsuneId;

    /**
     * 会员编号
     */
    private Long memberId;
    /**
     * 会员名称
     */
    private Long memberName;

    /**
     * 套餐编号
     */
    private Long mealId;

    /**
     * 套餐名称
     */
    private String mealName;

    /**
     * 套餐类型
     */
    private String mealType;

    /**
     * 项目编号
     */
    private Long ptpId;

    /**
     * 项目名称
     */
    private String ptpName;

    /**
     * 消费金额
     */
    private Long comsunePrice;

    /**
     * 消费时间
     */
    private Date comsuneDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}