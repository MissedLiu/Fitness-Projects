package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.Eeamage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【equipment_eamage(器材损坏上报表)】的数据库操作Mapper
* @createDate 2022-09-28 15:36:21
* @Entity com.trkj.entity.ouyang.EquipmentEamage
*/
public interface EeamageMapper extends BaseMapper<Eeamage> {
    @Update(value = "update equipment_eamage set beizhu ='修理完成' where ee_id = #{eeId}")
    boolean updateBeizhu(EeamageQueryVo eeamageQueryVo);

    @Insert(value = "insert into equipment_eamage " +
            "(ed_code,ee_name,ee_content, beizhu, sname) " +
            "VALUES (#{edCode},#{eeName},#{eeContent},#{beizhu},#{sname})")
    boolean addRepair(Eeamage eeamage);
}




