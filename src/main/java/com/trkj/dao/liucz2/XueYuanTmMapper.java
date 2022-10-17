package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.JiaolianNumVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import com.trkj.vo.queryLiucz2.XueYuanTmVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Mapper
* @createDate 2022-09-22 21:34:27
* @Entity com.trkj.entity.CommonMeal
*/
public interface XueYuanTmMapper extends BaseMapper<XueYuanPtVo> {
    /**
     * @description:
     * 动态查询所有信息并分页
     * @author: Liucz
     * @date: 2022/10/8 17:02
     * @param:
     * @return:
     **/
    IPage<XueYuanTmVo> findAll(Page<XueYuanTmVo> page, @Param("query") PageVo pageVo);
    /**
     * @description:
     * 查询个个教练下的会员数量
     * @author: Liucz
     * @date: 2022/10/10 20:22
     * @param:
     * @return:
     **/
    List<JiaolianNumVo> findNUm();
    /**
     * @description:
     * 查询教练下团操学员的人数
     * @author: Liucz
     * @date: 2022/10/10 20:54
     * @param:
     * @return:
     **/
    List<JiaolianNumVo> findjiaolainNUm();
    /**
     * @description:
     * 查询当前教练下不重复的会员
     * @author: Liucz
     * @date: 2022/10/17 8:59
     * @param:
     * @return:
     **/
    IPage<XueYuanTmVo> findAllByEmpId(Page<XueYuanTmVo> page ,@Param("query") PageVo pageVo);

    XueYuanTmVo findAllTmbymmId(@Param("empId") Long empId,@Param("mmId") Long mmId);
}




