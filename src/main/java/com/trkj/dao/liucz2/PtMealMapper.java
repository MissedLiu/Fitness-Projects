package com.trkj.dao.liucz2;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**<p>
 * 私教套餐表 Mapper 接口
 * </p>
 * @author 张鑫
 * @since 2022-09-23
 */
@Mapper
public interface PtMealMapper extends BaseMapper<PtMeal> {
    /*查询私教套餐*/
    IPage<PtMeal> findPtMealAll(Page<PtMeal> page, @Param("query") PageVo query);
    /**
     * @description:
     * 查询所有私教套餐,状态为0开启的
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.vo.queryLiucz2.PtMealVo>
     **/
    IPage<PtMeal> findPtMealAllSteta(Page<PtMeal> page, @Param("query") PageVo query);
    /**
     * @description:
     * 删除私教套餐与私教项目的关系
     * @author: Liucz 
     * @date: 2022/10/2 17:23
     * @param: [ptId]
     * @return: void
     **/
    @Delete("delete from pt_choose where pt_id=#{ptId}")
    int deletePtMealPtProject(Long ptId);

    /*
     * 添加私教套餐与私教项目关系
     * */
    int savePtMealPtProject(Long ptId, List<Long> ptpId);

}
