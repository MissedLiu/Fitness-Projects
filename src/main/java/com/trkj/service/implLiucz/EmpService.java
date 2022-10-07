package com.trkj.service.implLiucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz.EmpAndUser;
import com.trkj.vo.queryLiucz.EmpAndUserQueryVo;
import com.trkj.vo.queryLiucz.EmpQueryVo;

/**
 * <p>
 * 员工 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface EmpService extends IService<Emp> {
    /*
    *获取员工信息根据账户id获取员工信息
    * */

    Emp findEmpByEmpId(Long id);

    /*
     * 分页查询员工信息2
     * */

    IPage<Emp> findEmpListByPage2(EmpQueryVo empQueryVo);

    /*
     * 分页查询员工信息3
     * */

    IPage<EmpAndUser> findEmpListByPage3(EmpAndUserQueryVo empAndUserQueryVo);
/*
* 根据员工id删除员工文件
* */
    public boolean deleteById(Long id);

    /*
     * 分页查询员工信息（根据员工岗位）
     * */
    IPage<Emp> findEmpListByStation(EmpQueryVo empQueryVo);
}
