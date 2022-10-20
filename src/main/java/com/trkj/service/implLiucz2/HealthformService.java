package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Healthform;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;

/**
 *
 */
public interface HealthformService extends IService<Healthform> {
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:05
     * @param:
     * @return:
     **/
    IPage<Healthform> findAllIpage(PageVo pageVo);
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:05
     * @param:
     * @return:
     **/
    IPage<Healthform> findAllIpageStation(PageVo pageVo);
    /**
     * @description:
     * 根据会员编号查询
     * @author: Liucz 
     * @date: 2022/10/8 23:37
     * @param: 
     * @return: 
     **/
    Healthform checkFind(Long memberId);
    /**
     * @description:
     * 根据体检id查询数据
     * @author: Liucz
     * @date: 2022/10/13 18:57
     * @param:
     * @return:
     **/
    Healthform healthform(Long id);
}
