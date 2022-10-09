package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Changenum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import org.apache.ibatis.annotations.Insert;

/**
* @author oyzz
* @description 针对表【changenum(报损报溢表)】的数据库操作Mapper
* @createDate 2022-09-23 19:43:53
* @Entity com.trkj.entity.oy.Changenum
* @Entity com.trkj.entity.ouyang.Changenum
*/
public interface ChangenumMapper extends BaseMapper<Changenum> {
    //插入数据到报损报溢表
    @Insert(value = "insert into changenum(shopping_id, change_lose, change_more) value (#{poId},#{changeLose},#{changeMore})")
    Boolean toChangeNum(PoQueryVo poQueryVo);


}




