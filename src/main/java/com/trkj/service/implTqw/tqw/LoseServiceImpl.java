package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.LoseMapper;
import com.trkj.entity.tqw.Lose;
import com.trkj.service.implTqw.LoseService;
import com.trkj.vo.queryTqw.LoseQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class LoseServiceImpl extends ServiceImpl<LoseMapper, Lose> implements LoseService {
    /**
     * @title:  查询
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:58
    */
    public IPage<Lose> selectLose(LoseQueryVo loseQueryVo){
        //删除两个月前的失物招领记录
        //两个月前时间
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH ,-2);
        System.out.println("ttttt"+rightNow.getTime());
        //删除两个月前的数据
        QueryWrapper<Lose> wrapper=new QueryWrapper<>();
        wrapper.le("create_ttime",rightNow.getTime());
        baseMapper.delete(wrapper);

        Page<Lose> page=new Page<>(loseQueryVo.getPageNo(),loseQueryVo.getPageSize());
        System.out.println(loseQueryVo);
        IPage<Lose> iPage=baseMapper.selectLose(page,loseQueryVo);
        return iPage;
    }

    /**
     * @title:  新增
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:57
    */
    @Override
    public boolean addLose(Lose lose) {
        lose.setState("未领取");
        if(baseMapper.insert(lose)>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  新增领取人
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 8:57
    */
    @Override
    public int updateLoseState(Lose lose) {
        System.out.println();
        if(baseMapper.selectById(lose.getId()).getState().equals("已领取")){
            return 0;
        }
        //修改失物状态
        lose.setState("已领取");
        lose.setAddTime(new Date());
        if(baseMapper.updateById(lose)>0) {
            return 1;
        }
        return 2;
    }

    /**
     * @title:  删除
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:38
    */
    @Override
    public boolean deleteLose(Long id) {
        if(baseMapper.deleteById(id)>0){
            return true;
        }
        return false;
    }
}
