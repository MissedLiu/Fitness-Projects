package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 会员体检报告
 * @TableName healthform
 */
@TableName(value ="healthform")
@Data
public class Healthform implements Serializable {
    /**
     * 体检编号
     */
    @TableId(type = IdType.AUTO)
    private Long healthformId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 体检人编号
     */
    private Long empId;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 臀围
     */
    private Integer hipline;

    /**
     * 肩围
     */
    private Integer shoulderWai;

    /**
     * 腹围
     */
    private Integer belly;

    /**
     * 胸围
     */
    private Integer bw;

    /**
     * 上臂围
     */
    private Integer upbicepLeft;

    /**
     * 前臂围
     */
    private Integer beforebicepRight;

    /**
     * 大腿围
     */
    private Integer bigtrousersLeft;

    /**
     * 小腿围
     */
    private Integer littletrousersRight;

    /**
     * 腰围
     */
    private Integer waistline;

    /**
     * 脂肪
     */
    private Integer fat;

    /**
     * 体重指数BIM
     */
    private Integer weightnbim;

    /**
     * 基础代谢
     */
    private Integer uimsatz;

    /**
     * 腹肌耐力
     */
    private Integer endurance;

    /**
     * 柔韧度测试
     */
    private Integer flexibility;

    /**
     * 俯卧撑测试
     */
    private Integer pushup;

    /**
     * 血压测量
     */
    private Integer obpm;

    /**
     * 心率
     */
        private Integer hrrest;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}