package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.PtProjectname;

import java.util.List;


/**
*
*/
public interface PtProjectnameService extends IService<PtProjectname> {
    //通过套餐id查询私教项目(项目未禁用)
    List<PtProjectname> selectPtProject(Long ptId);
}
