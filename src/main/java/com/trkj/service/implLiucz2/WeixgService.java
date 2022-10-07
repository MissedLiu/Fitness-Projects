package com.trkj.service.implLiucz2;

import com.trkj.entity.liucz2.Weixg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface WeixgService extends IService<Weixg> {
    /**
     * @description:
     * 根据上报编号查询分配表中是否已存在
     * @author: Liucz
     * @date: 2022/10/6 13:48
     * @param:
     * @return:
     **/
    Weixg findAllWeixiu(Long id);
}
