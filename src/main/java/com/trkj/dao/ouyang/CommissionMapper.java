package com.trkj.dao.ouyang;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trkj.entity.ouyang.Commission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author oyzz
 * @description 针对表【commission(提成统计表)】的数据库操作Mapper
 * @createDate 2022-10-05 09:41:43
 * @Entity com.trkj.entity.ouyang.Commission
 */
public interface CommissionMapper extends BaseMapper<Commission> {

    //获取普通套餐提成
    @Select(value = "select commission_pt from commission where salesman_id=#{salesmanId}")
    Double getByCommissionPt(Commission commission);

    //获取私教套餐提成
    @Select(value = "select commission_sj from commission where salesman_id=#{salesmanId}")
    Double getByCommissionSj(Commission commission);

    //获取团操套餐提成
    @Select(value = "select commission_tc from commission where salesman_id=#{salesmanId}")
    Double getByCommissionTc(Commission commission);

    //获取商品销售提成
    @Select(value = "select commission_sp from commission where salesman_id=#{salesmanId}")
    Double getByCommissionSp(Commission commission);

    //修改总提成
    @Update(value = "update commission set commission_price=#{commissionPrice} where salesman_id=#{salesmanId}")
    Boolean updateCommissionPrice(Commission commission);

    //修改商品销售提成
    @Update(value = "update commission set commission_sp=#{commissionSp} where salesman_id=#{salesmanId}")
    boolean updateCommissionSp(Commission commission);

    /**
     * 修改每个课程销售的提成数
     *
     * @param commission
     * @return
     */
    Boolean updateCommission(@Param("commission") Commission commission);


}




