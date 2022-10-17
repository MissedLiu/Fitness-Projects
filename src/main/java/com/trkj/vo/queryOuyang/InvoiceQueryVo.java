package com.trkj.vo.queryOuyang;

import com.trkj.entity.liucz2.Invoice;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName InvoiceQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/7 14:38
 * @since JDK 8
 **/
@Data
public class InvoiceQueryVo extends Invoice {
    private Long pageNo = 1l;
    private Long pageSize = 10l;
    private Long tjType;
    private String changeTime;
}
