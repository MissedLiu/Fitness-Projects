package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Flyer;
import com.trkj.vo.queryLiucz2.FlyerVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张鑫
 * @description 针对表【flyer(宣传活动记录表)】的数据库操作Mapper
 * @createDate 2022-09-27 09:37:08
 * @Entity com.trkj.entity.Flyer
 */
public interface FlyerMapper extends BaseMapper<Flyer> {
    /*活动添加*/
    @Insert(value = "insert into flyer (flyer_name,flyer_address,flyer_num,flyer_staff,num,create_time)" +
                             " value (#{flyerName},#{flyerAddress},#{flyerNum},#{flyerStaff},#{num},now())")
      Boolean addFlyer(Flyer flyer);
    /**
     * @description:
     * 按条件动态查询并且分页
     * @author: Liucz
     * @date: 2022/9/29 19:44
     * @param:
     * @return:
     **/
    IPage<Flyer> findAllByFlyerAddressFlyerIPage(Page<Flyer> page, @Param("query") FlyerVo query);
}
