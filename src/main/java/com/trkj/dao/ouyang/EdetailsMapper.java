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
    /**
     * 添加器材使用记录
     * @param edetails
     * @return
     */
    @Insert(value = "insert into equipment_details(stockin_id,ed_name,ed_code,beizhu,brand)" +
            " VALUES (#{stockinId},#{edName},#{edCode},#{beizhu},#{brand})")
    boolean addDetails(Edetails edetails);

    /**
     * 统计同器材名、品牌的器材记录条数
     * @param edetails
     * @return
     */
    @Select(value = "select count(*) from equipment_details where ed_name=#{edName} and brand=#{brand}")
    Long getSumDetails(Edetails edetails);

    /**
     * 查询是否有相同标识编码的器材
     * @param edetails
     * @return
     */
    @Select(value = "select count(*) from equipment_details where ed_code = #{edCode}")
    Long CountDetailsByEdCode(Edetails edetails);

    /**
     *
     * @param edetails
     * @return
     */
    @Select(value = "select count(*) from equipment_details where ed_code = #{edCode} and ed_name = #{edName} and ed_state=1")
    Long CountDetailsByEdCodeAndName(Edetails edetails);
}




