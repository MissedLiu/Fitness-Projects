package com.trkj.vo.queryTqw;

import com.trkj.entity.tqw.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberMessageQueryVo {
    private long empId;
    private List<Long> memberId;
}
