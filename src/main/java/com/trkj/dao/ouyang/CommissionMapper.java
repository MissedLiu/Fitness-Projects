package com.trkj.dao.ouyang;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trkj.entity.ouyang.Commission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【commission(提成统计表)】的数据库操作Mapper
* @createDate 2022-10-05 09:41:43
* @Entity com.trkj.entity.ouyang.Commission
*/
public interface CommissionMapper extends BaseMapper<Commission> {

    @Select(value = "select commission_pt from commission where salesman_id=#{salesmanId}")
    Double getByCommissionPt(Commission commission);

    @Select(value = "select commission_sj from commission where salesman_id=#{salesmanId}")
    Double getByCommissionSj(Commission commission);

    @Select(value = "select commission_tc from commission where salesman_id=#{salesmanId}")
    Double getByCommissionTc(Commission commission);

    @Select(value = "select commission_sp from commission where salesman_id=#{salesmanId}")
    Double getByCommissionSp(Commission commission);

    @Update(value = "update commission set commission_price=#{commissionPrice} where salesman_id=#{salesmanId}")
    Boolean updateCommissionPrice(Commission commission);

    @Update(value = "update commission set commission_sp=#{commissionSp} where salesman_id=#{salesmanId}")
    boolean updateCommission(Commission commission);


}




