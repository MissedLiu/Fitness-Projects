package com.trkj.dao.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trkj.entity.liucz2.Sales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.ouyang.Commission;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.Sales
 */
public interface SalesMapper extends BaseMapper<Sales> {
    /**
     * @description: 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    IPage<Sales> findAllSalesIPage(Page<Sales> page, @Param("query") PageVo query);

    /**
     * 查询所有的课程销售记录
     *
     * @return
     */
    List<Sales> findAllSales();

    /**
     * 通过课程销售记录中的会员名字和电话查询会员Id
     *
     * @param sales
     * @return
     */
    @Select(value = "select member_id from member where member_name = #{memberName} and member_phone=#{memberPhone}")
    Long getMemberIdByNameAndPhone(Sales sales);

    /**
     * 通过getMemberIdByNameAndPhone()查询到的会员id和通过课程销售记录中的套餐id查询套餐办理id
     *
     * @param MbId
     * @param MlId
     * @return
     */
    @Select(value = "select mm_id from member_meal where member_id=#{MbId} and meal_id = #{MlId}")
    Long getMmIdByMemberIdAndMlId(@Param("MbId") Long MbId, @Param("MlId") Long MlId);

    /**
     * 通过getMmIdByMemberIdAndMlId()查询到的套餐办理id和通过课程销售记录中项目Id查询
     *
     * @param MmId
     * @param PjId
     * @return
     */
    @Select(value = "select * from choose_projectname where mm_id=#{MmId} and ptp_id = #{PjId}")
    Long getCpIdByMmIdAndprojectId(@Param("MmId") Long MmId, @Param("PjId") Long PjId);

    /**
     * 通过sales表中的销售人员ID获取员工信息
     *
     * @param sales
     * @return
     */
    @Select(value = "select emp_name,emp_phone,department_name from sys_emp where emp_id=#{salesmanId}")
    Commission getEmpById(Sales sales);

    /**
     * 将销售人员信息插入提成统计表中
     *
     * @param commission
     * @return
     */
    @Insert(value = "insert into commission(salesman_id, emp_name, emp_phone, department_name)" +
            "values (#{salesmanId},#{empName},#{empPhone},#{departmentName})")
    boolean toCommission(Commission commission);

    /**
     * 通过销售人员id统计提成表中的条目书v
     *
     * @param sales
     * @return
     */
    @Select(value = "select count(*) from commission where salesman_id = #{salesmanId}")
    Long CountEmp(Sales sales);

    /**
     * 通过销售人员id获取状态为1的课程销售记录，并将其价格求和
     *
     * @param pageVo
     * @return
     */
    @Select(value = "select sum(sales_price) from sales where salesman_id=#{salesmanId} and type=#{type} and state=1")
    Long sumPrice(PageVo pageVo);

    /**
     * 修改每个课程销售的提成数
     *
     * @param commission
     * @return
     */
    Boolean updateCommission(@Param("commission") Commission commission);

    /**
     * 修改统计后的记录状态
     *
     * @param pageVo
     * @return
     */
    @Update(value = "update sales set state=2 where type=#{type} and salesman_id=#{salesmanId} and state=1")
    Boolean updateState(PageVo pageVo);
}




