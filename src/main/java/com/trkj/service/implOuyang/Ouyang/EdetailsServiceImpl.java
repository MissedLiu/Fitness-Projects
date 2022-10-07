package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.dao.ouyang.EdetailsMapper;
import com.trkj.entity.ouyang.Eeamage;
import com.trkj.service.implOuyang.EdetailsService;
import com.trkj.vo.queryOuyang.EdetailsQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【equipment_details】的数据库操作Service实现
* @createDate 2022-09-29 14:06:32
*/
@Service
public class EdetailsServiceImpl extends ServiceImpl<EdetailsMapper, Edetails>
    implements EdetailsService {
@Resource
private EdetailsMapper edetailsMapper;
    @Override
    public IPage<Edetails> findDetailsPage(IPage page, EdetailsQueryVo edetailsQueryVo) {
        QueryWrapper<Edetails>queryWrapper=new QueryWrapper();
        queryWrapper.like(!ObjectUtils.isEmpty(edetailsQueryVo.getEdName()),"ed_name",edetailsQueryVo.getEdName());
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean addDetails(Edetails edetails) {
        return edetailsMapper.addDetails(edetails);
    }

    @Override
    public Long getSumDetails(Edetails edetails) {
        return edetailsMapper.getSumDetails(edetails);
    }

    @Override
    public Long CountDetailsByEdCode(Edetails edetails) {
        return edetailsMapper.CountDetailsByEdCode(edetails);
    }

    @Override
    public Long CountDetailsByEdCodeAndName(Edetails edetails) {
        return edetailsMapper.CountDetailsByEdCodeAndName(edetails);
    }
}



