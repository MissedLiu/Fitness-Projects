package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import com.trkj.vo.queryTqw.CompactQueryVo;

import java.util.List;

/**
*
*/
public interface CompactService extends IService<Compact> {
    //分页查询
    IPage<Member> findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo);
    //查询会员下办了套餐却没有签订合同的套餐
    List<CompactQueryVo> findMemberMeal(Member member);
    //添加合同数据
    boolean addCompact(Compact compact);
    //删除记录
    boolean delDetial(Long compactId);
    //根据会员id查询已签订的合同套餐信息
    List<CompactQueryVo> findCompact(Long memberId);
}
