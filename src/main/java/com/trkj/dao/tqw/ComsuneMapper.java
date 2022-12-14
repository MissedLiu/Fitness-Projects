package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Comsune;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.trkj.entity.Comsune
 */
public interface ComsuneMapper extends BaseMapper<Comsune> {

    //查询
    IPage<Comsune> selectComsuneList(Page<Comsune> page, @Param("query") ComsuneQueryVo comsuneQueryVo);

    /**
     * @description: 统计套餐消费次数
     * @author: Liucz
     * @date: 2022/10/10 17:10
     * @param:
     * @return:
     **/
    List<TeamMemerberNumVo> findNum();
}
