package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
*会员表
*
*/
public interface MemberMapper extends BaseMapper<Member> {

    //动态条件查询并分页(会员)
    IPage<Member> findMemberAll(Page<Member> page ,@Param("query") MemberQueryVo memberQueryVo);
    //动态条件查询无分页
    List<Member> listAllNoPage(@Param("query") Member member);

    int updateByMemberIs(List<Long> memberId);
    //修改潜在用户状态为1
    int updateByProspectIs(List<Long> memberId);

}

