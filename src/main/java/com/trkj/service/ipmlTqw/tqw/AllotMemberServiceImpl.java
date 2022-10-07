package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.dao.tqw.AllotMemberMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.entity.liucz.User;
import com.trkj.entity.tqw.AllotMember;
import com.trkj.entity.tqw.Member;
import com.trkj.service.ipmlTqw.AllotMemberService;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.MemberAndAllotQueryVo;
import com.trkj.vo.queryTqw.MemberAndBlackQueryVo;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
*/
@Service
@Transactional
public class AllotMemberServiceImpl extends ServiceImpl<AllotMemberMapper, AllotMember> implements AllotMemberService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberMapper memberMapper;
    //查询所有需要回访会员
    @Override
    public IPage<MemberAndAllotQueryVo> findMemberByEmpId(EmpQueryVo empQueryVo) {
        //empId赋值为账户id
        //查询该账户下的员工id
        User user = userMapper.selectById(empQueryVo.getEmpId());
        //判断empId是谁
        //通过empId查询员工
        if(empMapper.selectById(user.getEmpId()).getStation().equals("客服")){
            empQueryVo.setEmpId(user.getEmpId());
        }else {
            empQueryVo.setEmpId(null);
        }
        Page<MemberAndAllotQueryVo> page=new Page<>(empQueryVo.getPageNo(),empQueryVo.getPageSize());
        IPage<MemberAndAllotQueryVo> IPage = baseMapper.findMemberByEmpId(page,empQueryVo);
        return IPage;
    }

    //通过员工id查询该员工下的会员
    @Override
    public List<MemberAndAllotQueryVo> findMemberByEmpIds(Long empId) {
        return baseMapper.findMemberByEmpIds(empId);
    }


    //移除会员分配
    @Override
    public boolean deleteAllocationMember(Long empId, Long memberId) {
        //修改会员状态为0
        UpdateWrapper<Member> wrapper=new UpdateWrapper<>();
        wrapper.set("member_state",0).eq("member_id",memberId);
       int a = memberMapper.update(null,wrapper);

        //删除会员客服分配表数据
        QueryWrapper<AllotMember> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId)
                .eq("emp_id",empId);
        int b = baseMapper.delete(wrapper1);

        if(a>0&&b>0){
            return true;
        }
        return false;
    }
}
