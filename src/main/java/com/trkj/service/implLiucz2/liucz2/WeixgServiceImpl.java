package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.WeixgMapper;
import com.trkj.entity.liucz2.Weixg;


import com.trkj.service.implLiucz2.WeixgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service

public class WeixgServiceImpl extends ServiceImpl<WeixgMapper, Weixg>
    implements WeixgService {
    /**
     * @description:
     * 根据上报编号查询分配表中是否已存在
     * @author: Liucz
     * @date: 2022/10/6 13:48
     * @param:
     * @return:
     **/
    @Override
    public Weixg findAllWeixiu(Long id) {
        QueryWrapper<Weixg> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("ee_id" ,id);
        Weixg weixg = baseMapper.selectOne(queryWrapper);
        return weixg;
    }
}




