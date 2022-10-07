package com.trkj.dao.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Eeamage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
    /**
     * @description:
     * 根据 id,器材器材编号,器材名称 查询状态
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    List<Eeamage> findStateByIdByName(Eeamage eeamage);
    /**
     * @description:
     * 根据 id, 查询状态
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    Eeamage findStateById(Long id);
    /**
     * @description:
     * 根据上报编号修改状态
     * @author: Liucz
     * @date: 2022/10/6 13:52
     * @param:
     * @return:
     **/
    int updateStateByEeId(Long id);
    /**
     * @description:
     * 分页查询
     * @author: Liucz
     * @date: 2022/10/6 14:48
     * @param:
     * @return:
     **/
    IPage<Eeamage> findAllIpage(Page<Eeamage> page, @Param("query") EeamageQueryVo eeamageQueryVo);
    /**
     * @description:
     * 分页查询
     * @author: Liucz
     * @date: 2022/10/6 14:48
     * @param:
     * @return:
     **/
    IPage<Eeamage> findAllIpageByEmpId(Page<Eeamage> page, @Param("query") EeamageQueryVo eeamageQueryVo);
    /**
     * @description:
     * 根据上报编号修改状态为3-修理完成
     * @author: Liucz
     * @date: 2022/10/6 13:52
     * @param:
     * @return:
     **/
    int updateStateByEeId3(Long id);
    /**
     * @description:
     * 根据上报编号修改状态为4-修理失败
     * @author: Liucz
     * @date: 2022/10/6 13:52
     * @param:
     * @return:
     **/
    int updateStateByEeId4(Long id);
}




