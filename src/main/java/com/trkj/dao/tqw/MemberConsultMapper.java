package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.MemberConsult;
import com.trkj.vo.queryTqw.MemberConsultQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.trkj.entity.MemberConsult
*/
public interface MemberConsultMapper extends BaseMapper<MemberConsult> {

    //分页查询列表
    IPage<MemberConsultQueryVo> selectMemberConsultList(Page<MemberConsultQueryVo> page,@Param("query") MemberConsultQueryVo memberConsultQueryVo);
}
