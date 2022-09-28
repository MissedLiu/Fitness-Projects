package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.PtProjectname;

import java.util.List;


/**
* @Entity com.trkj.domain.PtProjectnameentity
*/
public interface PtProjectnameMapper extends BaseMapper<PtProjectname> {
    //通过套餐id查询私教项目(项目未禁用)
    List<PtProjectname> selectPtProjectByPtId(Long ptId);
}
