package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.liucz2.Proceeds;
import com.trkj.service.implOuyang.ProceedsService;
import com.trkj.dao.ouyang.ProceedsMapper;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.ProceedsQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【proceeds(套餐收入统计报表)】的数据库操作Service实现
 * @createDate 2022-10-11 09:27:23
 */
@Service
@Transactional
public class ProceedsServiceImpl extends ServiceImpl<ProceedsMapper, Proceeds>
        implements ProceedsService {

    @Resource
    private ProceedsMapper proceedsMapper;

    @Override
    public IPage<Proceeds> getList(IPage page, PageVo pageVo) {
        return proceedsMapper.selectPage(page, new QueryWrapper<>());
    }

    @Override
    public Long sumPrice(PageVo pageVo) {
        Long sump=0l;
        switch (pageVo.getTypee()){
            case "近七天":
                sump=proceedsMapper.SumWeekPrice(pageVo);
                break;
            case "近一个月":
                sump=proceedsMapper.SumMonthPrice(pageVo);
                break;
            case "本季度":
                sump=proceedsMapper.SumQuarterPrice(pageVo);
                break;
            case "上季度":
                sump=proceedsMapper.SumLastQuarterPrice(pageVo);
                break;
            case "本年":
                sump=proceedsMapper.SumYearPrice(pageVo);
                break;
        }
        System.out.println("--------------------"+sump);
        return sump;
    }
}




