package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Lose;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.springframework.data.domain.Page;

/**
*
*/
public interface LoseService extends IService<Lose> {
    //查询
    IPage<Lose> selectLose(LoseQueryVo loseQueryVo);
    //新增失物
    boolean addLose(Lose lose);
    //
    boolean updateLoseState(Lose lose);
}
