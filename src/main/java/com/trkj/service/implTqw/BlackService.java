package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Black;
import com.trkj.vo.queryTqw.BlackMemberMealQueryVo;
import com.trkj.vo.queryTqw.DisburseAndMemberQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;

import java.util.List;

public interface BlackService extends IService<Black> {

    //加入黑名单
    boolean goBlack(long memberId,String why);

    //查询黑名单列表
    IPage<MemberAndBlackQueryVo> findBlackMember(MemberSelectQueryVo memberSelectQueryVo);

    //移出黑名单
    boolean outUpdMemberState(long memberId,String why);

    //查询黑名单会员下的套餐
    List<BlackMemberMealQueryVo> findBlackMemberMeal(Long memberId);

    //退费
    int delMemberAllMeal(DisburseAndMemberQueryVo disburseAndMemberQueryVo);

}
