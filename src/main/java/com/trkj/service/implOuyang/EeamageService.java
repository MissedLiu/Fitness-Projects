package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Eeamage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.EeamageQueryVo;

import java.util.List;

/**
* @author oyzz
* @description 针对表【equipment_eamage(器材损坏上报表)】的数据库操作Service
* @createDate 2022-09-28 15:36:21
*/
public interface EeamageService extends IService<Eeamage> {
    IPage<Eeamage> findRepairList(IPage page, EeamageQueryVo eeamageQueryVo);
    /**
     * @description:
     * 分页多表
     * @author: Liucz
     * @date: 2022/10/6 14:54
     * @param: [page, eeamageQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.ouyang.Eeamage>
     **/
    IPage<Eeamage> findRepairListIpage( EeamageQueryVo eeamageQueryVo);
    /**
     * @description:
     * 分页多表按维修工id
     * @author: Liucz
     * @date: 2022/10/6 14:54
     * @param: [page, eeamageQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.ouyang.Eeamage>
     **/
    IPage<Eeamage> findRepairListIpageByEmpId( EeamageQueryVo eeamageQueryVo);
    boolean updateBeizhu(EeamageQueryVo eeamageQueryVo);
    boolean addRepair(Eeamage eeamage);
    /**
     * @description:
     * 根据器材器材编号,器材名称 查询状态
     * @author: Liucz 
     * @date: 2022/10/6 10:54
     * @param: 
     * @return: 
     **/
    List<Eeamage> findStateByNameById(Eeamage eeamage);
    /**
     * @description:
     * 根据上报编号, 查询状态
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    Eeamage findStateById(Long id);
    /**
     * @description:
     * 根据上报编号, 修改状态为2-维修中
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    int UpdateStateById(Long id);
    /**
     * @description:
     * 根据上报编号, 修改状态为3-维修中
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    int UpdateStateById3(Long id);
    /**
     * @description:
     * 根据上报编号, 修改状态为4-维修中
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    int UpdateStateById4(Long id);


}
