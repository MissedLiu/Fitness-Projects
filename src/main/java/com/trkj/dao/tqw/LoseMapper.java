package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Lose;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.apache.ibatis.annotations.Param;


/**
* @Entity com.trkj.entity.Lose
*/
public interface LoseMapper extends BaseMapper<Lose> {

    //查询
    IPage<Lose> selectLose(Page<Lose> page,@Param("query") LoseQueryVo loseQueryVo);
}
