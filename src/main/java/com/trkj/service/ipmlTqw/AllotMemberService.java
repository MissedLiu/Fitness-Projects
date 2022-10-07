package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.AllotMember;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.MemberAndAllotQueryVo;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;

import java.util.List;


/**
*
*/
public interface AllotMemberService extends IService<AllotMember> {
    //分页查询所有需要回访会员
    IPage<MemberAndAllotQueryVo> findMemberByEmpId(EmpQueryVo empQueryVo);
    //通过员工id查询该员工下的会员
    List<MemberAndAllotQueryVo> findMemberByEmpIds(Long empId);
    //移除会员分配
    boolean deleteAllocationMember(Long empId, Long memberId);

}
