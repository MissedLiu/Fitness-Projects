package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/*
*
*私教团操会员vo对象
*
*/
@Data
public class MemberQueryVo2 extends PageVo2 {
    //套餐办理编号
    private Long mmId;
    //所选套餐编号
    @NotNull(message = "所选套餐id不能为空")
    private Long mealId;
    //套餐名字
    private String mealName;
    //套餐时长
    private String mealTime;
    //套餐价格
    private Long mealPrice;
    //所选套餐类型(私教,团操,普通)
    private String mealType;
    //套餐办理时间
    private Date mmTime;
    //套餐到期时间
    private Date mmDate;
    //项目编号
    @NotNull(message = "所选项目id不能为空")
    private Long projectId;
    //项目名称
    private String projectName;
    //教练编号
    @NotNull(message = "所选教练id不能为空")
    private Long empId;
    //教练名字
    private String empName;
    //教练电话
    private String empPhone;
    //会员编号
    @TableId(value = "member_Id", type = IdType.AUTO)
    private long memberId;
    //会员姓名
    @NotNull(message = "名字不能为空")
    private String memberName;
    //会员性别
    private int memberSex;
    //出生日期
    private Date memberDate;
    //电话
    @NotNull(message = "电话不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$",message = "电话输入有误")
    private String memberPhone;
    //年龄
    private int memberAge;
    //住址
    private String memberAddress;
    //会员状态(是否禁用)
    private int memberState;
    //会员类型(0-体验,1-会员)
    private int memberType;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
}
