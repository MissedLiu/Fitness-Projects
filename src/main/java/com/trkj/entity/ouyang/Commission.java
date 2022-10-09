package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 提成统计表
 * @TableName commission
 */
@TableName(value ="commission")
@Data
public class Commission implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long commissionId;


    /**
     * 销售人id
     */
    private Long salesmanId;

    /**
     * 销售人员姓名
     */
    private String empName;

    /**
     * 销售人员电话
     */
    private String empPhone;

    /**
     * 
     */
    private String departmentName;

    /**
     * 总提成
     */
    private Double commissionPrice;

    /**
     * 私教课程提成
     */
    private Double commissionSj;

    /**
     * 普通课程提成
     */
    private Double commissionPt;

    /**
     * 团操课程提成
     */
    private Double commissionTc;

    /**
     * 商品提成
     */
    private Double commissionSp;

    private Date commTime;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}