package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Mapper
* @createDate 2022-09-22 21:34:27
* @Entity com.trkj.entity.CommonMeal
*/
public interface XueYuanPtMapper extends BaseMapper<XueYuanPtVo> {
    /**
     * @description:
     * 动态查询所有信息并分页
     * @author: Liucz
     * @date: 2022/10/8 17:02
     * @param:
     * @return:
     **/
    IPage<XueYuanPtVo> findAll(Page<XueYuanPtVo> page, @Param("query") PageVo pageVo);
    /**
     * @description:
     * 动态查询所有信息并分页,去重
     * @author: Liucz
     * @date: 2022/10/8 17:02
     * @param:
     * @return:
     **/
    IPage<XueYuanPtVo> findAllbyEmpId(Page<XueYuanPtVo> page, @Param("query") PageVo pageVo);
    /**
     * @description:
     * 动态查询所有套餐信息
     * @author: Liucz
     * @date: 2022/10/8 17:02
     * @param:
     * @return:
     **/
   XueYuanPtVo findAllbymmId(@Param("empId") Long empId,@Param("mmId") Long mmId);

}




