package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.Interview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;

/**
 *
 */
public interface InterviewService extends IService<Interview> {
    /**
     * @description:
     * 分页并且动态查询
     * @author: Liucz
     * @date: 2022/10/9 8:55
     * @param:
     * @return:
     **/
    IPage<Interview> findAllByEmpId(PageVo pageVo);
    /**
     * @description:
     * 分页并且动态查询
     * @author: Liucz
     * @date: 2022/10/9 8:55
     * @param:
     * @return:
     **/
    IPage<Interview> findAllByEmpIdStation(PageVo pageVo);

}
