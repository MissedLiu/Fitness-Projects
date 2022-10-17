package com.trkj.vo.queryOuyang;

import com.trkj.entity.ouyang.StockOutRecord;
import lombok.Data;

/**
 * @ClassName StockOutRecordQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/12 10:01
 * @Version 1.0
 **/
@Data
public class StockOutRecordQueryVo extends StockOutRecord {
    private Long pageNo = 1l;
    private Long pageSize = 10L;
    private String empName;
}
