package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Disburse;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.service.implOuyang.DisburseService;
import com.trkj.dao.ouyang.DisburseMapper;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【disburse(支出统计报表)】的数据库操作Service实现
 * @createDate 2022-10-04 14:27:46
 */
@Service
public class DisburseServiceImpl extends ServiceImpl<DisburseMapper, Disburse>
        implements DisburseService {

    @Resource
    private DisburseMapper disburseMapper;
    @Override
    public IPage<Disburse> getList(IPage page, DisburseQueryVo disburseQueryVo) {
        QueryWrapper<Disburse> queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("disburse_time");
        queryWrapper.like(!ObjectUtils.isEmpty(disburseQueryVo.getChangeTime()),
                "disburse_time",disburseQueryVo.getChangeTime());
        return baseMapper.selectPage(page, queryWrapper);

    }

    @Override
    public boolean toDisburse(ScheduleQueryVo scheduleQueryVo) {
        String beizhu=String.join("","购入",
                scheduleQueryVo.getScheduleName(),
                scheduleQueryVo.getSchedulePrice().toString(),
                "*",scheduleQueryVo.getScheduleNum().toString(),
                scheduleQueryVo.getUnit());
        scheduleQueryVo.setDisburseBeizhu(beizhu);
        return disburseMapper.toDisburse(scheduleQueryVo);
    }
}




