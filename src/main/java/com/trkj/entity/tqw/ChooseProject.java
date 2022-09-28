package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("choose_projectname")
public class ChooseProject {
    /*
    *
    *编号
    *
    */
    @TableId(value = "cp_id", type = IdType.AUTO)
    private long cpId;
    /*
    *
    *套餐办理编号
    *
    */
    private long mmId;
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
    private long empId;
    /*
    *
    *套餐编号
    *
    */
    private long chooseId;


}
