package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品销售记录表
 * @TableName sales_article
 */
@TableName(value ="sales_article")
@Data
public class SalesArticle implements Serializable {
    /**
     * 商品销售记录编号
     */
    @TableId(type = IdType.AUTO)
    private Long saId;

    /**
     * 销售人员编号
     */
    private Long saempId;

    /**
     * 物品出库编号
     */
    private Long stockoutId;

    /**
     * 物品名称
     */
    private String stockinName;

    /**
     * 物品数量
     */
    private Long stockinNum;

    /**
     * 金额
     */
    private Long salesPrice;

    /**
     * 创建时间
     */
    private Date salesTime;
    //品牌
    private String brand;

    @TableField(exist = false)
    private Invoice invoice;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}