package com.trkj.vo.query;

import lombok.Data;

@Data
public class PageVo2 {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
    private String username; //账户名;
}
