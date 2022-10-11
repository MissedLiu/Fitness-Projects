package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.CallbackMember;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;

/**
*
*/
public interface CallbackMemberService extends IService<CallbackMember> {
    //新增会员回访记录
    Boolean addCallbackMember(CallbackMember callbackMember);
    //查询回访记录
    IPage<MemberAndCallbackQueryVo> selectCallbackMember(MemberAndCallbackQueryVo memberAndCallbackQueryVo);
    //删除回访记录
    boolean deleteMemberCord(Long callbackId);
}
