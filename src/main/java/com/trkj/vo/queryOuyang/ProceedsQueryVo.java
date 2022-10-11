package com.trkj.vo.queryOuyang;/**
 * @ClassName ProceedsQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/11 10:14
 * @since JDK 8
 **/

import com.trkj.entity.liucz2.Proceeds;
import lombok.Data;

/**
 *@ClassName ProceedsQueryVo
 *@Description TODO
 *@Author Ouyang
 *@Date 2022/10/11 10:14
 *@Version 1.0
 **/
@Data
public class ProceedsQueryVo extends Proceeds {
    private Long pageNo;
    private Long pageSize;
}
