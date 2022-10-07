package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;

import java.util.List;

/**
*
*/
public interface CompactService extends IService<Compact> {
    //分页查询
    IPage<CompactAndMemberQueryVo> findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo);
    //查询会员下办了套餐却没有签订合同的套餐
    List<MemberMeal> findMemberMeal(Member member);
    //添加合同数据
    boolean addCompact(Compact compact);
}
