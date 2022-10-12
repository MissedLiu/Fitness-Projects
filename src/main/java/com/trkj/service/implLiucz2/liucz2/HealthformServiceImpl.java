package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.HealthformMapper;
import com.trkj.entity.liucz2.Healthform;

import com.trkj.service.implLiucz2.HealthformService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 */
@Service
@Transactional
public class HealthformServiceImpl extends ServiceImpl<HealthformMapper, Healthform>
    implements HealthformService {
    @Resource
    private HealthformMapper healthformMapper;
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:05
     * @param:
     * @return:
     **/
    @Override
    public IPage<Healthform> findAllIpage(PageVo pageVo) {
        Page<Healthform> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<Healthform> allIpage = healthformMapper.findAllIpage(page, pageVo);
        return allIpage;
    }
    /**
     * @description:
     * 根据会员编号查询
     * @author: Liucz
     * @date: 2022/10/8 23:37
     * @param:
     * @return:
     **/
    @Override
    public Healthform checkFind(Long memberId) {
        QueryWrapper<Healthform> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("member_id",memberId);
        Healthform healthform = baseMapper.selectOne(queryWrapper);
        return healthform;
    }
}




