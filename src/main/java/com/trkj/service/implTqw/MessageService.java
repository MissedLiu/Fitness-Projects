package com.trkj.service.implTqw;

import com.trkj.vo.queryTqw.MemberMessageQueryVo;

public interface MessageService {
    //分配会员
    boolean allocationMember(MemberMessageQueryVo memberMessageQueryVo);
    //分配潜在用户
    boolean allocationProspect(MemberMessageQueryVo memberMessageQueryVo);
}
