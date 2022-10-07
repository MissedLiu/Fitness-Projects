package com.trkj.dao.tqw;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.CallbackMember;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @Entity  com.trkj.entity.CallbackMember
*/
public interface CallbackMemberMapper extends BaseMapper<CallbackMember> {


    //查询回访记录
    IPage<MemberAndCallbackQueryVo> selectCallbackMember(Page<MemberAndCallbackQueryVo> page, @Param("query") MemberAndCallbackQueryVo memberAndCallbackQueryVo);
}
