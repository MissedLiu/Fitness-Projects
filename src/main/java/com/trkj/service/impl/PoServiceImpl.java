package com.trkj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.Po;
import com.trkj.service.PoService;
import com.trkj.dao.PoMapper;
import com.trkj.vo.query.PoQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【po(物品已购表)】的数据库操作Service实现
* @createDate 2022-09-22 11:33:17
*/
@Service
public class PoServiceImpl extends ServiceImpl<PoMapper, Po>
    implements PoService{

    @Resource
    private PoMapper poMapper;
    @Override
    public IPage<Po> findAllPo(IPage page, PoQueryVo poQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Po> queryWrapper = new QueryWrapper<Po>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(poQueryVo.getPoName()),"po_name", poQueryVo.getPoName());
        //获取store列表
        return  baseMapper.selectPage(page,queryWrapper);

    }

    @Override
    public boolean updatePoState(PoQueryVo poQueryVo) {
        return poMapper.updatePoState(poQueryVo);
    }

}




