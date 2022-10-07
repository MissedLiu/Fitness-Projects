package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Black;

import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import org.apache.ibatis.annotations.Param;

/*
*
*黑名单表
*
*/
public interface BlackMapper extends BaseMapper<Black>{
    //动态条件查询并分页(会员)
    IPage<MemberAndBlackQueryVo> findBlackMemberAll(Page<MemberAndBlackQueryVo> page , @Param("query") MemberAndBlackQueryVo memberAndBlackQueryVo);
    //查询黑名单通过电话查询
    MemberAndBlackQueryVo findMemberByPhone(String memberPhone);
}
