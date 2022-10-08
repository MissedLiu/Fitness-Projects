package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Edetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.vo.queryOuyang.EdetailsQueryVo;

/**
 * @author oyzz
 * @description 针对表【equipment_details】的数据库操作Service
 * @createDate 2022-09-29 14:06:32
 */
public interface EdetailsService extends IService<Edetails> {
    /**
     * 获取器材使用记录
     * @param page
     * @param edetailsQueryVo
     * @return
     */
    IPage<Edetails> findDetailsPage(IPage page, EdetailsQueryVo edetailsQueryVo);

    /**
     *
     * @param edetails
     * @return
     */
    boolean addDetails(Edetails edetails);

    /**
     *
     * @param edetails
     * @return
     */
    Long getSumDetails(Edetails edetails);

    Long CountDetailsByEdCode(Edetails edetails);

    Long CountDetailsByEdCodeAndName(Edetails edetails);
}
