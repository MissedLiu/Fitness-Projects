package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.service.implOuyang.EeamageService;
import com.trkj.dao.ouyang.EeamageMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyzz
 * @description 针对表【equipment_eamage(器材损坏上报表)】的数据库操作Service实现
 * @createDate 2022-09-28 15:36:21
 */
@Service
public class EeamageServiceImpl extends ServiceImpl<EeamageMapper, Eeamage>
        implements EeamageService {


    @Resource
    private EeamageMapper eeamageMapper;

    @Override
    public IPage<Eeamage> findRepairList(IPage page, EeamageQueryVo eeamageQueryVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(!ObjectUtils.isEmpty(eeamageQueryVo.getEeName()), "ee_name", eeamageQueryVo.getEeName());
        return baseMapper.selectPage(page, queryWrapper);
    }
    /**
     * @description:
     * 分页多表
     * @author: Liucz
     * @date: 2022/10/6 14:54
     * @param: [page, eeamageQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.ouyang.Eeamage>
     **/
    @Override
    public IPage<Eeamage> findRepairListIpage(EeamageQueryVo eeamageQueryVo) {
        Page<Eeamage> page=new Page<>(eeamageQueryVo.getPageNo(),eeamageQueryVo.getPageSize());
        IPage<Eeamage> allIpage = eeamageMapper.findAllIpage(page, eeamageQueryVo);
        return allIpage;
    }
    /**
     * @description:
     * 分页多表按维修工id
     * @author: Liucz
     * @date: 2022/10/6 14:54
     * @param: [page, eeamageQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.ouyang.Eeamage>
     **/
    @Override
    public IPage<Eeamage> findRepairListIpageByEmpId(EeamageQueryVo eeamageQueryVo) {
        Page<Eeamage> page=new Page<>(eeamageQueryVo.getPageNo(),eeamageQueryVo.getPageSize());
        IPage<Eeamage> allIpage = eeamageMapper.findAllIpageByEmpId(page, eeamageQueryVo);
        return allIpage;
    }

    @Override
    public boolean updateBeizhu(EeamageQueryVo eeamageQueryVo) {
        return eeamageMapper.updateBeizhu(eeamageQueryVo);
    }

    @Override
    public boolean addRepair(Eeamage eeamage) {
        return eeamageMapper.addRepair(eeamage);
    }
    /**
     * @description:
     * 根据器材器材编号,器材名称 查询状态
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    @Override
    public  List<Eeamage> findStateByNameById(Eeamage eeamage) {
        List<Eeamage> stateByIdByName = eeamageMapper.findStateByIdByName(eeamage);
        return stateByIdByName;
    }

    /**
     * @description:
     * 根据上报编号, 查询状态
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    @Override
    public Eeamage findStateById(Long id) {
        Eeamage stateById = eeamageMapper.findStateById(id);
        return stateById;
    }

    /**
     * @description:
     * 根据上报编号, 修改状态为2-维修中
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    @Override
    public int UpdateStateById(Long id) {
        int i = eeamageMapper.updateStateByEeId(id);
        return i;
    }
    /**
     * @description:
     * 根据上报编号, 修改状态为3-维修完成
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    @Override
    public int UpdateStateById3(Long id) {
        int i = eeamageMapper.updateStateByEeId3(id);
        return i;
    }
    /**
     * @description:
     * 根据上报编号, 修改状态为4-维修失败
     * @author: Liucz
     * @date: 2022/10/6 10:54
     * @param:
     * @return:
     **/
    @Override
    public int UpdateStateById4(Long id) {
        int i = eeamageMapper.updateStateByEeId4(id);
        return i;
    }
}




