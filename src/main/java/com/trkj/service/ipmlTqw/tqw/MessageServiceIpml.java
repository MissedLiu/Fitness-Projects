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
        int a=0;
        int b=0;
        for(int i=0;i<memberMessageQueryVo.getMemberId().size();i++){
            //修改会员状态为2
            UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
            wrapper.eq("member_id", memberMessageQueryVo.getMemberId().get(i));
            wrapper.set("member_state", 2);
            a=memberMapper.update(null, wrapper);
            //新增会员客服分分配表数据
            AllotMember allotMember=new AllotMember();
            allotMember.setEmpId(memberMessageQueryVo.getEmpId());
            allotMember.setMemberId(memberMessageQueryVo.getMemberId().get(i));
            b=allotMemberMapper.insert(allotMember);
            if(a==0 || b==0){
                return false;
            }
        }
        System.out.println("a:b"+a+","+b);
        if(a>0 && b>0){
            return true;
        }
        return false;
    }

    //分配潜在用户
    @Override
    public boolean allocationProspect(MemberMessageQueryVo memberMessageQueryVo) {
        int a=0;
        int b=0;
        for(int i=0;i<memberMessageQueryVo.getMemberId().size();i++){
            //修改潜在用户状态为1
            UpdateWrapper<Prospect> wrapper = new UpdateWrapper<>();
            wrapper.eq("prospect_id", memberMessageQueryVo.getMemberId().get(i));
            wrapper.set("prospect_is", 1);
            a=prospectMapper.update(null, wrapper);
            //新增会员客服分分配表数据
            AllotProspect allotProspect=new AllotProspect();
            allotProspect.setEmpId(memberMessageQueryVo.getEmpId());
            allotProspect.setProspectId(memberMessageQueryVo.getMemberId().get(i));
            b=allotProspectMapper.insert(allotProspect);
            if(a==0 || b==0){
                return false;
            }
        }
        System.out.println("a:b"+a+","+b);
        if(a>0 && b>0){
            return true;
        }
        return false;
    }
}
