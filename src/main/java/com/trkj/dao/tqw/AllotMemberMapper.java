package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.AllotMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.MemberAndAllotQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @Entity com.trkj.entity.AllotMember
 */
public interface AllotMemberMapper extends BaseMapper<AllotMember> {
    //查询所有需要回访会员
    IPage<MemberAndAllotQueryVo> findMemberByEmpId(Page<MemberAndAllotQueryVo> page, @Param("query") EmpQueryVo empQueryVo);
    //通过员工id查询该员工下的会员
    List<MemberAndAllotQueryVo> findMemberByEmpIds(Long empId);
    //添加会员客服关系表
    int addMemberAndEmp(@Param("empId") long empId,@Param("memberId") List<Long> memberId);
    //添加潜在用户客服关系表
    int addProspectAndEmp(@Param("empId") long empId,@Param("prospectId") List<Long> memberId);
}




