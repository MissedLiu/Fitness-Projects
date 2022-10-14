package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Disburse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;

/**
 * @author oyzz
 * @description 针对表【disburse(支出统计报表)】的数据库操作Service
 * @createDate 2022-10-04 14:27:46
 */
public interface DisburseService extends IService<Disburse> {
    /**
     * 获取支出报表
     *
     * @return
     */
    IPage<Disburse> getList(IPage page, DisburseQueryVo disburseQueryVo);

    /**
     * 添加支出记录
     *
     * @param scheduleQueryVo
     * @return
     */
    boolean toDisburse(ScheduleQueryVo scheduleQueryVo);




}
