package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Comsune;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;

import java.util.List;

/**
*
*/
public interface ComsuneService extends IService<Comsune> {
    //查询
    IPage<Comsune> selectComsuneList(ComsuneQueryVo comsuneQueryVo);

    Long sumPrice(PageVo pageVo);
    /**
     * @description:
     * 统计套餐消费次数
     * @author: Liucz
     * @date: 2022/10/10 17:10
     * @param:
     * @return:
     **/
    List<TeamMemerberNumVo> findNum();
}
