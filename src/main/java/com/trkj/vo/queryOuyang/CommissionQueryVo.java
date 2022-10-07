package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Commission;
import lombok.Data;

/**
 * @ClassName commissionQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/5 9:36
 * @since JDK 8
 **/
@Data
public class CommissionQueryVo extends Commission {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
}
