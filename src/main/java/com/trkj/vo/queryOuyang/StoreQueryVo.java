package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Store;
import lombok.Data;

@Data
public class StoreQueryVo extends Store {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private Long outStockNum = 0L;//出库数
    private String empName;//领取人
}
