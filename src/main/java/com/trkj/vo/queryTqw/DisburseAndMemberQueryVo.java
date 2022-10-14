package com.trkj.vo.queryTqw;

import com.trkj.entity.ouyang.Disburse;
import lombok.Data;

@Data
public class DisburseAndMemberQueryVo extends Disburse {
    //会员id
    private Long memberId;
}
