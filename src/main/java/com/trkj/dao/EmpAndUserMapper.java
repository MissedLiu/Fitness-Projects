package com.trkj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.Emp;
import com.trkj.entity.EmpAndUser;
import com.trkj.vo.query.EmpAndUserQueryVo;
import com.trkj.vo.query.EmpQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 员工 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface EmpAndUserMapper  {
    /*
    * 根据员工id查询账户名,并按条件查询
    * */

    IPage<EmpAndUser> selectEmpUserNamePage3(IPage<EmpAndUser> page, @Param("query") EmpAndUserQueryVo query);
}
