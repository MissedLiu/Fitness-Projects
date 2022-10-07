package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Eeamage;
import lombok.Data;

import java.util.Date;

@Data
public class EeamageQueryVo extends Eeamage {
    private Long pageNo = 1L;
    private Long pageSize = 10L;


    private Long emMethods;
    private Long weixgId;

    /**
     * 维修人
     */
    private String empName;

    /**
     * 上报编号
     */
    private Long eeId;

    /**
     * 维修日期
     */
    private Date emTime;

    /**
     * 维修情况
     */
    private String resuIts;

    /**
     * 问题解决方式(0-自修,1-换件,2,外修)
     */
    private Integer methods;
    //器材名称
    private String edName;
    //器材编号
    private String edCode;

}
