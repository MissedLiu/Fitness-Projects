package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Black;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;

public interface BlackService extends IService<Black> {
    /*
     *
     *加入黑名单
     *
     */
    boolean goUpdMemberState(long memberId,String why);
    /*
    *
    *查询黑名单列表
    *
    */
    IPage<MemberAndBlackQueryVo> findBlackMember(MemberAndBlackQueryVo memberAndBlackQueryVo);
    /*
     *
     *移出黑名单
     *
     */
    boolean outUpdMemberState(long memberId,String why);

}