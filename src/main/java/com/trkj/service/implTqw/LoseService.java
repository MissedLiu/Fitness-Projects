package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Lose;
import com.trkj.vo.queryTqw.LoseQueryVo;

public interface LoseService extends IService<Lose> {
    //查询
    IPage<Lose> selectLose(LoseQueryVo loseQueryVo);
    //新增失物
    boolean addLose(Lose lose);
    //新增领取人
    int updateLoseState(Lose lose);
    //删除
    boolean deleteLose(Long id);
}
