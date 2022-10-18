package com.trkj.service.implTqw.tqw;

import com.trkj.dao.tqw.AllotMemberMapper;
import com.trkj.dao.tqw.AllotProspectMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.ProspectMapper;
import com.trkj.service.implTqw.MessageService;
import com.trkj.vo.queryTqw.MemberMessageQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MessageServiceIpml implements MessageService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private AllotMemberMapper allotMemberMapper;


    /**
     * @title:  分配会员
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:32
    */
    @Override
    @Transactional
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

    /**
     * @title:  分配潜在用户
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:32
    */
    @Override
    @Transactional
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
