package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Comsune;
import com.trkj.utils.Result;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;

/**
*
*/
public interface ComsuneService extends IService<Comsune> {
    //查询
    IPage<Comsune> selectComsuneList(ComsuneQueryVo comsuneQueryVo);

    Long sumPrice(PageVo pageVo);
}
