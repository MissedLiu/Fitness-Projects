package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.dao.tqw.CallbackMemberMapper;
import com.trkj.entity.liucz.User;
import com.trkj.entity.tqw.CallbackMember;
import com.trkj.service.implTqw.CallbackMemberService;
import com.trkj.vo.queryTqw.MemberAndCallbackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class CallbackMemberServiceImpl extends ServiceImpl<CallbackMemberMapper, CallbackMember>
implements CallbackMemberService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private EmpMapper empMapper;

    /**
     * @title:  新增会员回访记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:35
    */
    @Override
    @Transactional
    public Boolean addCallbackMember(CallbackMember callbackMember) {
        callbackMember.setColumnTime(new Date());
        if(baseMapper.insert(callbackMember)>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  查询回访记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:35
    */
    @Override
    public IPage<MemberAndCallbackQueryVo> selectCallbackMember(MemberAndCallbackQueryVo memberAndCallbackQueryVo) {
        //empId赋值为账户id
        //查询该账户下的员工id
        User user = userMapper.selectById(memberAndCallbackQueryVo.getEmpId());
        //判断empId是谁
        //通过empId查询员工
        if(empMapper.selectById(user.getEmpId()).getStation().equals("客服")){
            memberAndCallbackQueryVo.setEmpId(user.getEmpId());
        }else {
            memberAndCallbackQueryVo.setEmpId(null);
        }
        Page<MemberAndCallbackQueryVo> page=new Page<>(memberAndCallbackQueryVo.getPageNo(),memberAndCallbackQueryVo.getPageSize());
        IPage<MemberAndCallbackQueryVo> IPage =baseMapper.selectCallbackMember(page,memberAndCallbackQueryVo);
        return IPage;
    }

    //删除会员回访记录
    @Override
    @Transactional
    public boolean deleteMemberCord(Long callbackId) {
        if(baseMapper.deleteById(callbackId)>0){
            return true;
        }
        return false;
    }
}
