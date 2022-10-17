package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
*会员表
*
*/
public interface MemberMapper extends BaseMapper<Member> {

    //动态条件查询会员并分页
    IPage<Member> findMemberList(Page<Member> page ,@Param("query") MemberSelectQueryVo memberSelectQueryVo);

    //动态条件查询无分页
    List<Member> listAllNoPage(@Param("query") Member member);

    int updateByMemberIs(List<Long> memberId);
    //修改潜在用户状态为1
    int updateByProspectIs(List<Long> memberId);

    //查询普通套餐
    List<MemberQueryVo> selectCommon( @Param("memberId") long memberId);
    //查询私教套餐
    List<MemberQueryVo> selectPt(@Param("memberId") long memberId);
    //查询团操套餐
    List<MemberQueryVo> selectTeam(@Param("memberId") long memberId);

}

