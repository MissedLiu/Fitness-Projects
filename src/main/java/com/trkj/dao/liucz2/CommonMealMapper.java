package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.CommonMeal;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Mapper
* @createDate 2022-09-22 21:34:27
* @Entity com.trkj.entity.CommonMeal
*/
public interface CommonMealMapper extends BaseMapper<CommonMeal> {
    /*普通套餐添加*/
    @Insert(value = "insert into common_meal (cm_name,cm_time,cm_date,cm_is,cm_price)" +
            " value (#{cmName},#{cmTime},now(),#{cmIs},#{cmPrice})")
        public Boolean addCommonMeal(CommonMeal commonMeal);
    /**
     * @description:动态按条件查询普通套餐
     * @author: Liucz
     * @date: 2022/9/30 10:29
     * @param: [commonMeal]
     * @return: java.util.List<com.trkj.entity.liucz2.CommonMeal>
     **/
    IPage<CommonMeal> findAllByCmNameCommonMealIPage(Page<CommonMeal> page , @Param("query") PageVo  query);
    /**
     * @description:动态按条件查询普通套餐,状态为1的数据列表
     * @author: Liucz
     * @date: 2022/9/30 10:29
     * @param: [commonMeal]
     * @return: java.util.List<com.trkj.entity.liucz2.CommonMeal>
     **/
    IPage<CommonMeal> findAllByCmNameCommonMealIPageState(Page<CommonMeal> page , @Param("query") PageVo  query);
}




