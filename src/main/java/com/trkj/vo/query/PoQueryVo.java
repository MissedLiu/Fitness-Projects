package com.trkj.vo.query;

import com.trkj.entity.Po;
import lombok.Data;

@Data
public class PoQueryVo extends Po {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private Long changeLose = 0L;//报损数
    private Long changeMore = 0L;//报溢数
    private Long storeNum = 0l;//库存数
}