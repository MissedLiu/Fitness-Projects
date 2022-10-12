package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Changenum;
import com.trkj.service.implOuyang.ChangenumService;
import com.trkj.dao.ouyang.ChangenumMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【changenum(报损报溢表)】的数据库操作Service实现
* @createDate 2022-09-23 19:43:53
*/
@Service
@Transactional
public class ChangenumServiceImpl extends ServiceImpl<ChangenumMapper, Changenum>
    implements ChangenumService{

    @Resource
    private ChangenumMapper changenumMapper;

    /**
     * 添加记录到报溢报损表
     * @param poQueryVo
     * @return
     */
    @Override
    public Boolean toChangenum(PoQueryVo poQueryVo) {
        return changenumMapper.toChangeNum(poQueryVo);
    }

}




