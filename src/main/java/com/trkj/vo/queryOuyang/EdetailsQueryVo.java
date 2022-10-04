package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Edetails;
import lombok.Data;

@Data
public class EdetailsQueryVo extends Edetails {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
}
