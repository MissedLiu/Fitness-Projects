package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Eeamage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.EeamageQueryVo;

/**
* @author oyzz
* @description 针对表【equipment_eamage(器材损坏上报表)】的数据库操作Service
* @createDate 2022-09-28 15:36:21
*/
public interface EeamageService extends IService<Eeamage> {
    IPage<Eeamage> findRepairList(IPage page, EeamageQueryVo eeamageQueryVo);
    boolean updateBeizhu(EeamageQueryVo eeamageQueryVo);
    boolean addRepair(Eeamage eeamage);

}
