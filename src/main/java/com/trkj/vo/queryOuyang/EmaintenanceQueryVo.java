package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Emaintenance;
import lombok.Data;

/**
 * @ClassName EmaintenanceQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/9/30 15:54
 * @since JDK 8
 **/
@Data
public class EmaintenanceQueryVo extends Emaintenance {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
}
