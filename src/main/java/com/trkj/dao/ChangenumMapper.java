package com.trkj.dao;

import com.trkj.entity.Changenum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PoQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author oyzz
* @description 针对表【changenum(报损报溢表)】的数据库操作Mapper
* @createDate 2022-09-23 19:43:53
* @Entity com.trkj.entity.Changenum
*/
public interface ChangenumMapper extends BaseMapper<Changenum> {
    @Insert(value = "insert into changenum(shopping_id, change_lose, change_more) value (#{poId},#{changeLose},#{changeMore})")
    public Boolean toChangeNum(PoQueryVo poQueryVo);

    @Select(value = "select change_lose,change_more from changenum where shopping_id=#{id}")
    List<Changenum> getChangeNumByPoId(Long id);
}




