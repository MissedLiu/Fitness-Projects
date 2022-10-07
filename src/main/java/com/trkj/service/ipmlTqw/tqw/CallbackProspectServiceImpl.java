package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.dao.tqw.CallbackProspectMapper;
import com.trkj.entity.liucz.User;
import com.trkj.entity.tqw.CallbackProspect;
import com.trkj.service.ipmlTqw.CallbackProspectService;
import com.trkj.vo.queryTqw.ProspectAndCallbackQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
*
*/
@Service
@Transactional
public class CallbackProspectServiceImpl extends ServiceImpl<CallbackProspectMapper, CallbackProspect>
implements CallbackProspectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;


    //新增回访潜在用户记录
    @Override
    public Boolean addCallbackProspect(CallbackProspect callbackProspect) {
        callbackProspect.setColumnTime(new Date());
        if(baseMapper.insert(callbackProspect)>0){
            return true;
        }
        return false;
    }

    //查询回访潜在用户记录
    @Override
    public IPage<ProspectAndCallbackQueryVo> selectCallBackList(ProspectAndCallbackQueryVo prospectAndAllotQueryVo) {
        //empId赋值为账户id
        //查询该账户下的员工id
        System.out.println("ssssssssssssssssssssssssssss"+prospectAndAllotQueryVo);
        User user = userMapper.selectById(prospectAndAllotQueryVo.getEmpId());
        //判断empId是谁
        //通过empId查询员工
        if(empMapper.selectById(user.getEmpId()).getStation().equals("客服")){
            prospectAndAllotQueryVo.setEmpId(user.getEmpId());
        }else {
            prospectAndAllotQueryVo.setEmpId(null);
        }
        Page<ProspectAndCallbackQueryVo> page=new Page<>(prospectAndAllotQueryVo.getPageNo(),prospectAndAllotQueryVo.getPageSize());
        IPage<ProspectAndCallbackQueryVo> IPage =baseMapper.selectCallbackProspect(page,prospectAndAllotQueryVo);
        return IPage;
    }
}
