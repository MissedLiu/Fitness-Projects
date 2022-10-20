package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Healthform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.trkj.entity.liucz2.Healthform
 */
public interface HealthformMapper extends BaseMapper<Healthform> {
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:05
     * @param:
     * @return:
     **/
    IPage<Healthform> findAllIpage(Page<Healthform> page,@Param("query") PageVo pageVo);
    /**
     * @description:
     * 查询所有体检列表
     * @author: Liucz
     * @date: 2022/10/8 23:05
     * @param:
     * @return:
     **/
    IPage<Healthform> findAllIpageStation(Page<Healthform> page,@Param("query") PageVo pageVo);
}




