package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.trkj.entity.Compact
*/
public interface CompactMapper extends BaseMapper<Compact> {

    //分页查询列表
    IPage<CompactAndMemberQueryVo> selectCompactList(Page<CompactAndMemberQueryVo> page,@Param("query") CompactAndMemberQueryVo compactAndMemberQueryVo);


}
