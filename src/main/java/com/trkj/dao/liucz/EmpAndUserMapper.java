package com.trkj.dao.liucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.EmpAndUser;
import com.trkj.vo.queryLiucz.EmpAndUserQueryVo;
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
