package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.PtCoach;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.PtCoach
 */
public interface PtCoachMapper extends BaseMapper<PtCoach> {

    /**
     * @description:
     * 根据教练id动态查询套餐信息
     * @author: Liucz
     * @date: 2022/10/8 12:48
     * @param:
     * @return:
     **/
    IPage<PtCoach> findPtMeamByCoachId(Page<PtCoach> page , @Param("query") PageVo query);
}




