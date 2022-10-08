package com.trkj.dao.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Emaintenance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import com.trkj.vo.queryOuyang.EmaintenanceQueryVo;
import org.apache.ibatis.annotations.Insert;

/**
* @author oyzz
* @description 针对表【equipment_maintenance(器材维修表)】的数据库操作Mapper
* @createDate 2022-09-29 09:49:10
* @Entity com.trkj.ouyang.entity.ouyang.EquipmentMaintenance
*/
public interface EmaintenanceMapper extends BaseMapper<Emaintenance> {
    /**
     * 插入器材维修记录表
     * @param eeamageQueryVo
     * @return
     */
    @Insert(value = "insert into equipment_maintenance " +
            "(emp_name,ee_id,resu_its,methods,ed_code,ed_name) values " +
            "(#{empName},#{eeId},#{resuIts},#{emMethods},#{edCode},#{eeName});")
    boolean toEm(EeamageQueryVo eeamageQueryVo);

}




