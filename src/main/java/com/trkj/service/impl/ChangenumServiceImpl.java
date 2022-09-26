package com.trkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.Changenum;
import com.trkj.service.ChangenumService;
import com.trkj.dao.ChangenumMapper;
import com.trkj.vo.query.PoQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author oyzz
* @description 针对表【changenum(报损报溢表)】的数据库操作Service实现
* @createDate 2022-09-23 19:43:53
*/
@Service
public class ChangenumServiceImpl extends ServiceImpl<ChangenumMapper, Changenum>
    implements ChangenumService{

    @Resource
    private ChangenumMapper changenumMapper;
    @Override
    public Boolean toChangenum(PoQueryVo poQueryVo) {
        return changenumMapper.toChangeNum(poQueryVo);
    }

    @Override
    public List<Changenum> getChangeNumById(Long poId) {
        return changenumMapper.getChangeNumByPoId(poId);
    }
}




