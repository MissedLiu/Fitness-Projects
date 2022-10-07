package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.AllotProspect;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.ProspectAndAllotQueryVo;
import com.trkj.vo.queryTqw.ProspectQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.trkj.entity.AllotProspect
*/
public interface AllotProspectMapper extends BaseMapper<AllotProspect> {


    IPage<ProspectAndAllotQueryVo> findProspectByEmpId(Page<ProspectAndAllotQueryVo> page, @Param("query") EmpQueryVo empQueryVo);

    //通过员工id查询该员工下的潜在用户
    List<ProspectQueryVo> findProspectByEmpIds(Long empId);
}
