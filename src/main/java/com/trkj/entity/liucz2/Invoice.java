package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 发票记录表(商品收入统计)
 * @TableName invoice
 */
@TableName(value ="invoice")
@Data
public class Invoice implements Serializable {
    /**
     * 发票编号
     */
    @TableId(type = IdType.AUTO)
    private Long invoiceId;

    /**
     * 商品销售记录编号
     */
    private Long salesId;

    /**
     * 购买人姓名
     */
    private String invoiceName;

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
    private Long price;

    /**
     * 销售人员编号
     */
    private Long empId;

    /**
     * 创建时间
     */
    private Date createTime;
    //品牌
    private String brand;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}