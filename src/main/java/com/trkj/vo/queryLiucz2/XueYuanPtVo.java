package com.trkj.vo.queryLiucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.vo.queryLiucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  16:42
 * @Description: TODO
 * @Version: 5.0
 */
@Data
public class XueYuanPtVo extends PageVo {
    /*
     *
     *会员编号
     *
     */
    private long memberId;
    /*
     *
     *会员姓名
     *
     */
    private String memberName;
    /*
     *
     *会员性别
     *
     */
    private int memberSex;
    /*
     *
     *出生日期
     *
     */
    private Date memberDate;
    /*
     *
     *电话
     *
     */
    private String memberPhone;
    /*
     *
     *年龄(0-女,1-男)
     *
     */
    private int memberAge;
    /*
     *
     *住址
     *
     */
    private String memberAddress;
    /*
     *
     *会员状态(是否禁用)
     *
     */
    private int memberState;
    /*
     *
     *会员类型(0-体验,1-会员)
     *
     */
    private int memberType;
    /*
     *
     *创建时间
     *
     */
    private Date createTime;
    /*
     *
     *更新时间
     *
     */
    private Date updateTime;
    /*
     *
     *套餐办理编号
     *
     */
    private long mmId;
    /*
     *
     *所选套餐编号
     *
     */
    private long mealId;
    /*
     *
     *所选套餐类型(私教,团操,普通)
     *
     */
    private String mealType;
    /*
     *
     *套餐办理时间
     *
     */
    private Date mmTime;
    /*
     *
     *套餐到期时间
     *
     */
    private Date mmDate;
    /*
     *
     *所选项目编号
     *
     */
    private long cpId;
    /*
     *
     *项目编号
     *
     */
    private long ptpId;
    /*
     *
     *教练编号
     *
     */
    private Long empId;
    /*
     *
     *套餐编号
     *
     */
    private long chooseId;
    /**
     * 私教套餐编号
     */
    private Long ptId;

    /**
     *
     */
    private String ptTime;

    /**
     * 套餐生效时间
     */
    private Date ptDate;

    /**
     * 套餐价格
     */
    private Long ptPrice;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Integer ptIs;

    /**
     * 套餐名
     */
    private String ptName;


    /**
     * 项目名称(减脂或塑形.)
     */
    private String ptpName;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Integer ptpIs;


}