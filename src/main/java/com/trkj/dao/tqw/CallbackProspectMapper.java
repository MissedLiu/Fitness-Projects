package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.CallbackProspect;
import com.trkj.vo.queryTqw.ProspectAndAllotQueryVo;
import com.trkj.vo.queryTqw.ProspectAndCallbackQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.trkj.entity.CallbackProspect
*/
public interface CallbackProspectMapper extends BaseMapper<CallbackProspect> {

    //分页查询访问
    IPage<ProspectAndCallbackQueryVo> selectCallbackProspect(Page<ProspectAndCallbackQueryVo> page,@Param("query") ProspectAndCallbackQueryVo prospectAndAllotQueryVo);
}
