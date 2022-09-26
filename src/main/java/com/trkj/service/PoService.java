package com.trkj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.Po;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PoQueryVo;

/**
* @author oyzz
* @description 针对表【po(物品已购表)】的数据库操作Service
* @createDate 2022-09-22 11:33:17
*/
public interface PoService extends IService<Po> {
    IPage<Po> findAllPo(IPage page, PoQueryVo poQueryVo);
    boolean updatePoState(PoQueryVo poQueryVo);
}
