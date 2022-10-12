package com.trkj.vo.queryLiucz;

import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.vo.queryLiucz
 * @Author: LiuCZ
 * @CreateTime: 2022-10-12  21:13
 * @Description: TODO
 * @Version: 5.0
 */
@Data
public class CountTongJi {
    private String name;//教练
    private Long pvalue;//私教人数
    private Long tvalue;//团操人数
//    private List<Long> value;//总人数

}