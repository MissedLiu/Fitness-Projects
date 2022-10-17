package com.trkj.service.implOuyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.ouyang.StockOutRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.StockOutRecordQueryVo;

/**
* @author oyzz
* @description 针对表【stock_out_record(物品出库记录表)】的数据库操作Service
* @createDate 2022-10-12 09:59:51
*/
public interface StockOutRecordService extends IService<StockOutRecord> {
    IPage<StockOutRecord> getList(IPage page,StockOutRecordQueryVo stockOutRecordQueryVo);
}
