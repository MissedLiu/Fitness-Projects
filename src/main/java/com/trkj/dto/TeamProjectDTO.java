package com.trkj.dto;

import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.vo.queryLiucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-02  17:14
 * @Description: TODO
 * @Version: 5.0
 * 保存私教套餐与私教项目的关系
 */
@Data
public class TeamProjectDTO {
    private Long teamId;
    private List<Long> tpId;

}