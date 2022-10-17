package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @Min(0)
    @NotNull(message="销售人编号不能为空")
    private Long salesmanId;

    /**
     * 销售人员姓名
     */
    @NotNull(message="销售人员姓名不能为空")
    private String empName;

    /**
     * 销售人员电话
     */
    @NotNull(message = "电话不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$",message = "电话输入有误")
    private String empPhone;

    /**
     * 部门名
     */
    @NotNull(message="部门名称不能为空")
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