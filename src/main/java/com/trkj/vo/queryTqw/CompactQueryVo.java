package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.MemberMeal;
import lombok.Data;

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

}
