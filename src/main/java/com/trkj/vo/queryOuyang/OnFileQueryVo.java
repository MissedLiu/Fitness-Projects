package com.trkj.vo.queryOuyang;/**
 * @ClassName OnFileQueryVo
 * @Description TODO
 * @Author Ouyang
 * @Date 2022/10/12 21:00
 * @since JDK 8
 **/

import lombok.Data;

/**
 *@ClassName OnFileQueryVo
 *@Description TODO
 *@Author Ouyang
 *@Date 2022/10/12 21:00
 *@Version 1.0
 **/
@Data
public class OnFileQueryVo {
    private Long pageNo = 1L;
    private Long pageSize = 10L;
    private String changeTime;
    private double sumPrice;
    private String onFileType;
}
