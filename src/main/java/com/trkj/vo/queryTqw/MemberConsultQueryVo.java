package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.MemberConsult;
import lombok.Data;

@Data
public class MemberConsultQueryVo extends MemberConsult {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
}
