package com.trkj.vo.query;

import com.trkj.entity.Schedule;
import lombok.Data;

@Data
public class ScheduleQueryVo extends Schedule {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
}
