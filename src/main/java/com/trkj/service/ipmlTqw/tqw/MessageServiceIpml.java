package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.trkj.dao.tqw.AllotMemberMapper;
import com.trkj.dao.tqw.AllotProspectMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.ProspectMapper;
import com.trkj.entity.tqw.AllotMember;
import com.trkj.entity.tqw.AllotProspect;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.Prospect;
import com.trkj.service.ipmlTqw.MessageService;
import com.trkj.vo.queryTqw.MemberMessageQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceIpml implements MessageService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ProspectMapper prospectMapper;
    @Autowired
    private AllotMemberMapper allotMemberMapper;
    @Autowired
    private AllotProspectMapper allotProspectMapper;
    //分配会员
    @Override
    public boolean allocationMember(MemberMessageQueryVo memberMessageQueryVo) {
        //修改会员状态为2
        int a = memberMapper.updateByMemberIs(memberMessageQueryVo.getMemberId());
        //添加会员客服关系表
        int b = allotMemberMapper.addMemberAndEmp(memberMessageQueryVo.getEmpId(),memberMessageQueryVo.getMemberId());

        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    //分配潜在用户
    @Override
    public boolean allocationProspect(MemberMessageQueryVo memberMessageQueryVo) {
        //修改潜在用户状态为1
        int a = memberMapper.updateByProspectIs(memberMessageQueryVo.getMemberId());
        //添加潜在用户客服关系表
        int b = allotMemberMapper.addProspectAndEmp(memberMessageQueryVo.getEmpId(),memberMessageQueryVo.getMemberId());
        if(a>0 && b>0){
            return true;
        }
        return false;
    }
}
