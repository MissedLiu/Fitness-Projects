package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Disburse;
import lombok.Data;

/**
 * @ClassName DisburseQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/4 14:29
 * @since JDK 8
 **/
@Data
public class DisburseQueryVo extends Disburse {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
    private String changeTime;
}
