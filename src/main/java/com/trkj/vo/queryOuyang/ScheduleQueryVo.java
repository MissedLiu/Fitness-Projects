package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Schedule;
import lombok.Data;

@Data
public class ScheduleQueryVo extends Schedule {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private String disburseBeizhu;//支出表中的备注
}
