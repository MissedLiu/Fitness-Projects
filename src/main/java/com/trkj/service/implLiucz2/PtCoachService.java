package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.PtCoach;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.entity.liucz2.TeamCoach;
import com.trkj.vo.query.PageVo;

import java.util.List;

/**
 *
 */
public interface PtCoachService extends IService<PtCoach> {
    /**
     * @description:
     * 根据教练id查询套餐列表
     * @author: Liucz
     * @date: 2022/10/8 12:11
     * @param:
     * @return:
     **/
    List<PtMeal>  findPtIdByCoachId(PageVo pageVo);
}
