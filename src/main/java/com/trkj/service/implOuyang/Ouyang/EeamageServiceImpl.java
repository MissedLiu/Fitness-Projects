package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.service.implOuyang.EeamageService;
import com.trkj.dao.ouyang.EeamageMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

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

    @Override
    public boolean updateBeizhu(EeamageQueryVo eeamageQueryVo) {
        return eeamageMapper.updateBeizhu(eeamageQueryVo);
    }

    @Override
    public boolean addRepair(Eeamage eeamage) {
        return eeamageMapper.addRepair(eeamage);
    }
}




