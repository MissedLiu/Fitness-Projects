package com.trkj.vo.query;

import com.trkj.entity.StockOut;
import lombok.Data;

@Data
public class StockOutQueryVo  extends StockOut {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
}
