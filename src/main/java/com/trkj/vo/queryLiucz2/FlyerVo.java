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
 * 宣传活动记录表
 * @TableName flyer
 */

@Data
public class FlyerVo extends PageVo {
    /**
     * 活动记录编号
     */
    private Long flyerId;

    /**
     * 负责人姓名
     */
    private String flyerName;

    /**
     * 活动地址
     */
    private String flyerAddress;

    /**
     * 发放数量
     */
    private Long flyerNum;

    /**
     * 参与员工
     */
    private String flyerStaff;

    /**
     * 收获潜在用户数量
     */
    private Long num;

    /**
     * 时间
     */
    private Date createTime;


}