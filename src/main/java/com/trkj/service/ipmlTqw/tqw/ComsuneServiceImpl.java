package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ComsuneMapper;
import com.trkj.entity.tqw.Comsune;
import com.trkj.service.ipmlTqw.ComsuneService;
import com.trkj.vo.queryTqw.ComsuneQueryVo;

import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class ComsuneServiceImpl extends ServiceImpl<ComsuneMapper, Comsune>
implements ComsuneService {
    //查询
    @Override
    public IPage<Comsune> selectComsuneList(ComsuneQueryVo comsuneQueryVo) {
        Page<Comsune> page = new Page<>(comsuneQueryVo.getPageNo(),comsuneQueryVo.getPageSize());
        IPage<Comsune> iPage=baseMapper.selectComsuneList(page,comsuneQueryVo);
        return iPage;
    }
}
