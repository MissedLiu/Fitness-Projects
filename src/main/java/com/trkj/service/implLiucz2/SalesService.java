package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Sales;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.ouyang.Commission;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 */
public interface SalesService extends IService<Sales> {
    /**
     * @description:
     * 动态分页查询
     * @author: Liucz
     * @date: 2022/10/3 14:55
     * @param:
     * @return:
     **/
    IPage<Sales> findAllSalesPage(PageVo pageVo);

    /**
     * 通过课程销售记录中的会员名字和电话查询会员Id
     * @param sales
     * @return
     */
    Long getMemberIdByNameAndPhone(Sales sales);

    /**
     * 通过getMemberIdByNameAndPhone()查询到的会员id和通过课程销售记录中的套餐id查询套餐办理id
     * @param MbId
     * @param MlId
     * @return
     */
    Long getMmIdByMemberIdAndMlId(Long MbId,Long MlId);

    /**
     * 通过getMmIdByMemberIdAndMlId()查询到的套餐办理id和通过课程销售记录中项目Id查询
     * @param MmId
     * @param PjId
     * @return
     */
    Long getCpIdByMmIdAndprojectId(Long MmId,Long PjId);

    /**
     * 通过销售人员id查询他的详细信息
     * @param sales
     * @return
     */
    Commission getEmpById(Sales sales);

    /**
     * 当套餐销售记录表有新数据时 同时更新提成表的数据
     * @param commission
     * @return
     */
    boolean toCommission(Commission commission);

    /**
     * 判断提成表中是否有当前销售人员的信息
     * @param sales
     * @return
     */
    Long CountEmp(Sales sales);

    /**
     * 通过销售Id和课程类型查找课程销售记录
     * @param pageVo
     * @return
     */
    IPage<Sales> findSalesPageByTypeAndId(IPage page,PageVo pageVo);

    /**
     * 查询状态为1的某个销售人员某个套餐类型所有记录的金额总和
     * @param pageVo
     * @return
     */
    Long sumPrice(PageVo pageVo);

    /**
     * 修改某销售人员单个套餐类型的提成值
     * @param commission
     * @return
     */
    boolean updateCommissionOne(Commission commission);

    /**
     * 统计完提成之后将其状态修改为2（已统计）
     * @param pageVo
     * @return
     */
    boolean updateSalesState(PageVo pageVo);
}
