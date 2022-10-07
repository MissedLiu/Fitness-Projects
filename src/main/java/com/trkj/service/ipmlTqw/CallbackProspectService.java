package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.CallbackProspect;
import com.trkj.vo.queryTqw.ProspectAndCallbackQueryVo;

/**
*
*/
public interface CallbackProspectService extends IService<CallbackProspect> {

    //新增回访潜在用户记录
    Boolean addCallbackProspect(CallbackProspect callbackProspect);

    //查询潜在用户回访记录
    IPage<ProspectAndCallbackQueryVo> selectCallBackList(ProspectAndCallbackQueryVo prospectAndAllotQueryVo);
}
