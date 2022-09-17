package com.trkj.service.impl;

import com.trkj.entity.Emp;
import com.trkj.dao.EmpMapper;
import com.trkj.entity.User;
import com.trkj.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 员工 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private UserService userService;
    //获取员工信息根据账户id获取员工信息
    @Override
    public Emp findEmpByUserid(String username) {
        User user=userService.findUserByUserName(username);
        Emp emp=baseMapper.selectById(user.getId());
        return emp;
    }
}
