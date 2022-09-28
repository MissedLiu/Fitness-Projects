package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Member;
import lombok.Data;

import java.util.Date;

/*
*
*添加会员vo对象
*
*/
@Data
public class MemberQueryVo extends Member {
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
     *套餐名字
     *
     */
    private String mealName;
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
     *项目编号
     *
     */
    private Long projectId;
    /*
     *
     *项目名称
     *
     */
    private String projectName;
    /*
     *
     *教练编号
     *
     */
    private Long empId;
    /*
     *
     *教练名字
     *
     */
    private String empName;

}
