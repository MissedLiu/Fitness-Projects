package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Prospect;
import com.trkj.vo.queryTqw.ProspectQueryVo;

import java.util.List;

/**
*
*/
public interface ProspectService extends IService<Prospect> {

    //通过分配状态查询潜在用户
    List<Prospect> findProspectByProspectIs(long pros);
    //分页查询潜在用户
    IPage<ProspectQueryVo> findProspectList(ProspectQueryVo prospectQueryVo);
    //新增潜在用户
    boolean addProspect(Prospect prospect);
    //删除潜在用户
    boolean deleteProspect(Long prospectId);
    //修改潜在用户
    boolean updProspecr(Prospect prospect);


}
