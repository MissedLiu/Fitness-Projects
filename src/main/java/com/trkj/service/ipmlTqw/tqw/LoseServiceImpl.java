package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.LoseMapper;
import com.trkj.entity.tqw.Lose;
import com.trkj.service.ipmlTqw.LoseService;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
*
*/
@Service
public class LoseServiceImpl extends ServiceImpl<LoseMapper, Lose> implements LoseService {
    //查询
    public IPage<Lose> selectLose(LoseQueryVo loseQueryVo){
        Page<Lose> page=new Page<>(loseQueryVo.getPageNo(),loseQueryVo.getPageSize());
        System.out.println(loseQueryVo);
        IPage<Lose> iPage=baseMapper.selectLose(page,loseQueryVo);
        return iPage;
    }
    //新增
    @Override
    public boolean addLose(Lose lose) {
        lose.setState("未领取");
        lose.setCreateTtime(new Date());
        if(baseMapper.insert(lose)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateLoseState(Lose lose) {
        //修改失物状态
        lose.setState("已领取");
        lose.setAddTime(new Date());
        if(baseMapper.updateById(lose)>0) {
            return true;
        }
        return false;
    }
}
