package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.dao.tqw.AllotProspectMapper;
import com.trkj.dao.tqw.ProspectMapper;
import com.trkj.entity.liucz.User;
import com.trkj.entity.tqw.AllotProspect;
import com.trkj.entity.tqw.Prospect;
import com.trkj.service.implTqw.AllotProspectService;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryTqw.ProspectAndAllotQueryVo;
import com.trkj.vo.queryTqw.ProspectQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllotProspectServiceImpl extends ServiceImpl<AllotProspectMapper, AllotProspect>
implements AllotProspectService {

    @Resource
    private EmpMapper empMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProspectMapper prospectMapper;


    /**
     * @title:  查询所有需要回访的潜在用户
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:33
    */
    @Override
    public IPage<ProspectAndAllotQueryVo> findProspectByEmpId(EmpQueryVo empQueryVo) {
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
        Page<ProspectAndAllotQueryVo> page=new Page<>(empQueryVo.getPageNo(),empQueryVo.getPageSize());
        IPage<ProspectAndAllotQueryVo> IPage = baseMapper.findProspectByEmpId(page,empQueryVo);
        return IPage;
    }

    /**
     * @title:  通过员工id查询该员工下的潜在用户
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:33
    */
    @Override
    public List<ProspectQueryVo> findProspectByEmpIds(Long empId) {
        return baseMapper.findProspectByEmpIds(empId);
    }

    /**
     * @title:  移除潜在用户分配
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 10:33
    */
    @Override
    @Transactional
    public boolean deleteAllocationProspect(Long empId, Long prospectId) {
        //修改潜在用户状态为0
        UpdateWrapper<Prospect> wrapper=new UpdateWrapper<>();
        wrapper.set("prospect_is",0).eq("prospect_id",prospectId);
        int a = prospectMapper.update(null,wrapper);
        //删除会员客服分配表数据
        QueryWrapper<AllotProspect> wrapper1=new QueryWrapper<>();
        wrapper1.eq("prospect_id",prospectId)
                .eq("emp_id",empId);
        int b = baseMapper.delete(wrapper1);
        if(a>0&&b>0){
            return true;
        }
        return false;
    }
}
