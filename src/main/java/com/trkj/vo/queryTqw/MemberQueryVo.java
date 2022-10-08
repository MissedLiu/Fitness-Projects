package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import java.util.Date;

/*
*
*添加会员vo对象
*
*/
@Data
public class MemberQueryVo extends PageVo2 {
    //套餐办理编号
    private long mmId;
    //所选套餐编号
    private long mealId;
    //套餐名字
    private String mealName;
    //所选套餐类型(私教,团操,普通)
    private String mealType;
    //套餐办理时间
    private Date mmTime;
    //套餐到期时间
    private Date mmDate;
    //项目编号
    private Long projectId;
    //项目名称
    private String projectName;
    //教练编号
    private Long empId;
    //教练名字
    private String empName;

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




}
