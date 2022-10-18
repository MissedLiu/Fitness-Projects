package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ComsuneMapper;
import com.trkj.entity.tqw.Comsune;
import com.trkj.service.implTqw.ComsuneService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.ComsuneQueryVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComsuneServiceImpl extends ServiceImpl<ComsuneMapper, Comsune>
implements ComsuneService {

    @Resource
    private ComsuneMapper comsuneMapper;

    /**
     * @title:  查询
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:45
    */
    @Override
    public IPage<Comsune> selectComsuneList(ComsuneQueryVo comsuneQueryVo) {
        Page<Comsune> page = new Page<>(comsuneQueryVo.getPageNo(),comsuneQueryVo.getPageSize());
        IPage<Comsune> iPage=baseMapper.selectComsuneList(page,comsuneQueryVo);
        return iPage;
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
