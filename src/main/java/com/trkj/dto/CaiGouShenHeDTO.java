package com.trkj.dto;

import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * 用于添加采购审核
 * @BelongsPackage: com.trkj.dto
 * @Author: LiuCZ
 * @CreateTime: 2022-10-05  14:24
 * @Description: TODO
 * @Version: 5.0
 */
@Data
public class CaiGouShenHeDTO {
    private Long scheduleId;//采购编号
    private List<Long> id;//账号id


}