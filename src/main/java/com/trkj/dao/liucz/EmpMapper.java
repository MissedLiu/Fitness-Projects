package com.trkj.dao.liucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryLiucz.CountEmpVo;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工 Mapper 接口
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface EmpMapper extends BaseMapper<Emp> {
    /*
    * 根据员工id查询账户名,并按条件查询
    * */

    IPage<Emp> selectEmpUserNamePage(IPage<Emp> page, @Param("query") EmpQueryVo query);

    /*
     * 分页查询员工信息（根据员工岗位）
     * */
    IPage<Emp> selectEmpListByStation(Page<Emp> pageStr,@Param("query") EmpQueryVo empQueryVo);
    //查询每个部门下的人数
    List<CountEmpVo> findCountEmpBydeptId();
}
