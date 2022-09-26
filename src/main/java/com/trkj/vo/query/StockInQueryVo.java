package com.trkj.vo.query;

import com.trkj.entity.StockIn;
import lombok.Data;

@Data
public class StockInQueryVo extends StockIn {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private Long changeNum = 1L;

}
