package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Eeamage;
import lombok.Data;

@Data
public class EeamageQueryVo extends Eeamage {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
    private String empName;
    private String resuIts;
    private Long emMethods;
}
