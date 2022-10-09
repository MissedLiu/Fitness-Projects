package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.Commission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.CommissionQueryVo;

/**
 * @author oyzz
 * @description 针对表【commission(提成统计表)】的数据库操作Service
 * @createDate 2022-10-05 09:41:43
 */
public interface CommissionService extends IService<Commission> {
    IPage<Commission> getList(IPage page, CommissionQueryVo commissionQueryVo);


    //查询提成统计表中普通套餐的提成
    Double getByCommissionPt(Commission commission);

    //查询提成统计表中私教套餐的提成
    Double getByCommissionSj(Commission commission);

    //查询提成统计表中团操套餐的提成
    Double getByCommissionTc(Commission commission);

    //查询提成统计表中商品的提成
    Double getByCommissionSp(Commission commission);

    //修改提成总值
    Boolean updateCommissionPrice(Commission commission);

    //修改商品提成
    Boolean updateCommSp(Commission commission);
}
