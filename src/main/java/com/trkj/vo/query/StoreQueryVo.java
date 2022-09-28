package com.trkj.vo.query;

import com.trkj.entity.Store;
import lombok.Data;

@Data
public class StoreQueryVo extends Store {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private Long outStockNum = 0L;//出库数
}
