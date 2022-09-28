package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.Po;
import lombok.Data;

@Data
public class PoQueryVo extends Po {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
    private Long changeLose ;//报损数
    private Long changeMore ;//报溢数
    private Long storeNum = 0l;//库存数
}