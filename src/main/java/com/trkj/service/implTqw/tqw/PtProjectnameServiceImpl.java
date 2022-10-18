package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.PtProjectnameMapper;
import com.trkj.entity.tqw.PtProjectname;
import com.trkj.service.implTqw.PtProjectnameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*私教项目
*/
@Service
public class PtProjectnameServiceImpl extends ServiceImpl<PtProjectnameMapper, PtProjectname>
implements PtProjectnameService {
    //通过套餐id查询私教项目(项目未禁用)
    @Override
    public List<PtProjectname> selectPtProject(Long ptId) {
        return baseMapper.selectPtProjectByPtId(ptId);
    }

}
