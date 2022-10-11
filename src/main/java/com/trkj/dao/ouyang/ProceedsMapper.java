package com.trkj.dao.ouyang;

import com.trkj.entity.liucz2.Proceeds;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.CommonMeall;
import com.trkj.entity.tqw.PtMeall;
import com.trkj.entity.tqw.TeamMeall;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author oyzz
 * @description 针对表【proceeds(套餐收入统计报表)】的数据库操作Mapper
 * @createDate 2022-10-11 09:27:23
 * @Entity com.trkj.entity.liucz2.Proceeds
 */
public interface ProceedsMapper extends BaseMapper<Proceeds> {

    Long SumWeekPrice(@Param("query") PageVo pageVo);

    Long SumMonthPrice(@Param("query") PageVo pageVo);

    Long SumQuarterPrice(@Param("query") PageVo pageVo);

    Long SumLastQuarterPrice(@Param("query") PageVo pageVo);

    Long SumYearPrice(@Param("query") PageVo pageVo);
}




