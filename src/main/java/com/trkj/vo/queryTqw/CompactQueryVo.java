package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.MemberMeal;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

//合同管理显示未签订的套餐
@Data
public class CompactQueryVo extends MemberMeal {
    //合同id
    private Long compactId;
    //套餐名字
    private String mealName;
    //项目名字
    private String projectName;
    //教练名字
    private String empName;
    //签订日期
    private Date createDate;
    //结束日期
    private Date endDate;
    //业务员
    private String salesman;
    //合同原件图片地址
    private String photoAddress;
    //合同原件图片地址2
    private String photoAddress2;
    //合同原件图片地址3
    private String photoAddress3;
    //合同原件图片地址4
    private String photoAddress4;
     //合同原件图片地址5
    private String photoAddress5;

}
