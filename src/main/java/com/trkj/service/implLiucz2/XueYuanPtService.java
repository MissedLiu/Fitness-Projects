package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import com.trkj.vo.queryLiucz2.XueYuanTmVo;

import java.util.List;

public interface XueYuanPtService extends IService<XueYuanPtVo> {
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    IPage<XueYuanPtVo> findAllList(PageVo pageVo);
    /**
     * @description:
     * 分页动态查询学员列表所有
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    IPage<XueYuanPtVo> findAllListAll(PageVo pageVo);
    /**
     * @description:
     * 根据会员id查询私教套餐和项目信息
     * @author: Liucz
     * @date: 2022/10/17 9:36
     * @param:
     * @return:
     **/
    List<XueYuanPtVo> findAllptMeal(PageVo pageVo);


}
