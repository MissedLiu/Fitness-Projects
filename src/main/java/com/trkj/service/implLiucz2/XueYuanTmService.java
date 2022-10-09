package com.trkj.service.implLiucz2;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanTmVo;

public interface XueYuanTmService  {
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    IPage<XueYuanTmVo> findAllList(PageVo pageVo);
}
