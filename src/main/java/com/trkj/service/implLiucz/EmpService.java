package com.trkj.service.implLiucz;

import com.trkj.entity.liucz.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface EmpService extends IService<Emp> {
    //获取员工信息根据账户id获取员工信息
    Emp findEmpByUserid(String username);
}
