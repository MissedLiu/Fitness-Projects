package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Emaintenance;
import com.trkj.service.implOuyang.EmaintenanceService;
import com.trkj.dao.ouyang.EmaintenanceMapper;
import com.trkj.vo.queryOuyang.EeamageQueryVo;
import com.trkj.vo.queryOuyang.EmaintenanceQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【equipment_maintenance(器材维修表)】的数据库操作Service实现
* @createDate 2022-09-29 09:49:10
*/
@Service
public class EmaintenanceServiceImpl extends ServiceImpl<EmaintenanceMapper, Emaintenance>
    implements EmaintenanceService {

    @Resource
    private EmaintenanceMapper emaintenanceMapper;

    @Override
    public boolean toEm(EeamageQueryVo eeamageQueryVo) {
        return emaintenanceMapper.toEm(eeamageQueryVo);
    }

    @Override
    public IPage<EmaintenanceQueryVo> getEmList(IPage page,EmaintenanceQueryVo emaintenanceQueryVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like(!ObjectUtils.isEmpty(emaintenanceQueryVo.getEdName()), "ed_name", emaintenanceQueryVo.getEdName());
        queryWrapper.orderByDesc("em_time");
        return baseMapper.selectPage(page, queryWrapper);
    }
}




