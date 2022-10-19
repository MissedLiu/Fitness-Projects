package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import com.trkj.vo.queryTqw.CompactQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.trkj.entity.Compact
*/
public interface CompactMapper extends BaseMapper<Compact> {

    //分页查询列表
    IPage<Member> selectCompactList(Page<Member> page,@Param("query") CompactAndMemberQueryVo compactAndMemberQueryVo);

    //根据会员id查询已签订的私教合同
    List<CompactQueryVo> findPtCompact(Long memberId);

    //根据会员id查询已签订的团操合同
    List<CompactQueryVo> findTeamCompact(Long memberId);
}
