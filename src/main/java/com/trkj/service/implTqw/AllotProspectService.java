package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.AllotProspect;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.ProspectAndAllotQueryVo;
import com.trkj.vo.queryTqw.ProspectQueryVo;

import java.util.List;

/**
*
*/
public interface AllotProspectService extends IService<AllotProspect> {

    //查询所有需要回访的潜在用户
    IPage<ProspectAndAllotQueryVo> findProspectByEmpId(EmpQueryVo empQueryVo);
    //通过员工id查询该员工下的潜在用户
    List<ProspectQueryVo> findProspectByEmpIds(Long empId);
    //移除潜在用户分配
    boolean deleteAllocationProspect(Long empId, Long prospectId);
}
