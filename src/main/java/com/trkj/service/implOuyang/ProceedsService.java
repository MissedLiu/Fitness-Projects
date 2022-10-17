package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Proceeds;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.ProceedsQueryVo;

/**
* @author oyzz
* @description 针对表【proceeds(套餐收入统计报表)】的数据库操作Service
* @createDate 2022-10-11 09:27:23
*/
public interface ProceedsService extends IService<Proceeds> {
    IPage<Proceeds> getList(IPage page,PageVo pageVo);

    /**
     * 根据前端不同的参数获取不同的时间段的收入总和
     * @param pageVo
     * @return
     */
    Long sumPrice(PageVo pageVo);
}
