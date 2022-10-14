package com.trkj.dao.ouyang;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trkj.entity.ouyang.Disburse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.ouyang.Schedule;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.ScheduleQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
* @author oyzz
* @description 针对表【disburse(支出统计报表)】的数据库操作Mapper
* @createDate 2022-10-04 14:27:46
* @Entity com.trkj.entity.ouyang.Disburse
*/
public interface DisburseMapper extends BaseMapper<Disburse> {
    //插入支出表数据
    @Insert(value = "insert into disburse (disburse_type,disburse_price,beizhu)" +
            " value (#{scheduleType},#{scheduleNum}*#{schedulePrice},#{disburseBeizhu})")
    Boolean toDisburse(ScheduleQueryVo scheduleQueryVo);

}




