package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Prospect;
import com.trkj.vo.queryTqw.ProspectQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.trkj.entity.Prospect
*/
public interface ProspectMapper extends BaseMapper<Prospect> {

    //分页查询潜在用户列表
    IPage<ProspectQueryVo> selectProspectList(Page<ProspectQueryVo> page,@Param("query") ProspectQueryVo prospectQueryVo);
}
