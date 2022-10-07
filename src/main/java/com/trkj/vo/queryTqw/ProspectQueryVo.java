package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Prospect;
import com.trkj.vo.query.PageVo;
import lombok.Data;

@Data
public class ProspectQueryVo extends Prospect {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
}
