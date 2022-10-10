package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ComsuneMapper;
import com.trkj.entity.tqw.Comsune;
import com.trkj.service.ipmlTqw.ComsuneService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class ComsuneServiceImpl extends ServiceImpl<ComsuneMapper, Comsune>
implements ComsuneService {

    @Resource
    private ComsuneMapper comsuneMapper;
    //查询
    @Override
    public IPage<Comsune> selectComsuneList(ComsuneQueryVo comsuneQueryVo) {
        Page<Comsune> page = new Page<>(comsuneQueryVo.getPageNo(),comsuneQueryVo.getPageSize());
        IPage<Comsune> iPage=baseMapper.selectComsuneList(page,comsuneQueryVo);
        return iPage;
    }

    @Override
    public Long sumPrice(PageVo pageVo) {
        Long sump=0l;
        switch (pageVo.getTypee()){
            case "近七天":
                sump=comsuneMapper.SumWeekPrice(pageVo);
                break;
            case "近一个月":
                sump=comsuneMapper.SumMonthPrice(pageVo);
                break;
            case "本季度":
                sump=comsuneMapper.SumQuarterPrice(pageVo);
                break;
            case "上季度":
                sump=comsuneMapper.SumLastQuarterPrice(pageVo);
                break;
            case "本年":
                sump=comsuneMapper.SumYearPrice(pageVo);
                break;
        }
        System.out.println("--------------------"+sump);
        return sump;
    }
    /**
     * @description:
     * 统计套餐消费次数
     * @author: Liucz
     * @date: 2022/10/10 17:10
     * @param:
     * @return:
     **/
    @Override
    public List<TeamMemerberNumVo> findNum() {
        List<TeamMemerberNumVo> num = comsuneMapper.findNum();
        return num;
    }


}
