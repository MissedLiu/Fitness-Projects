package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Emaintenance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import com.trkj.vo.queryOuyang.EmaintenanceQueryVo;

/**
* @author oyzz
* @description 针对表【equipment_maintenance(器材维修表)】的数据库操作Service
* @createDate 2022-09-29 09:49:10
*/
public interface EmaintenanceService extends IService<Emaintenance> {
    IPage<EmaintenanceQueryVo> getEmList(IPage page,EmaintenanceQueryVo emaintenanceQueryVo);

    /**
     * @description:
     * 添加
     * @author: Liucz
     * @date: 2022/10/6 16:32
     * @param:
     * @return:
     **/
    int add(Emaintenance emaintenance);
}
