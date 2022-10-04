package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Edetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.ouyang.Eeamage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
* @author oyzz
* @description 针对表【equipment_details】的数据库操作Mapper
* @createDate 2022-09-29 14:06:32
* @Entity com.trkj.ouyang.entity.ouyang.EquipmentDetails
*/
public interface EdetailsMapper extends BaseMapper<Edetails> {
    @Insert(value = "insert into equipment_details(stockin_id,ed_name,ed_code,beizhu,brand)" +
            " VALUES (#{stockinId},#{edName},#{edCode},#{beizhu},#{brand})")
    boolean addDetails(Edetails edetails);

    @Select(value = "select count(*) from equipment_details where ed_name=#{edName} and brand=#{brand}")
    Long getSumDetails(Edetails edetails);

    @Select(value = "select count(*) from equipment_details where ed_code = #{edCode}")
    Long CountDetailsByEdCode(Edetails edetails);

    @Select(value = "select count(*) from equipment_details where ed_code = #{edCode} and ed_name = #{eeName}")
    Long CountDetailsByEdCodeAndName(Eeamage eeamage);
}




