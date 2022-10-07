package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Compact;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Data;

@Data
public class CompactAndMemberQueryVo extends Compact {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
    /*
     *
     *会员姓名
     *
     */
    private String memberName;
    /*
     *
     *电话
     *
     */
    private String memberPhone;
    
}
