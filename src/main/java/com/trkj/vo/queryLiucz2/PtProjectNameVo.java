package com.trkj.vo.queryLiucz2;

import com.trkj.entity.liucz2.PtProject;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * 私教项目类型表
 * @TableName pt_project
 */

@Data
public class PtProjectNameVo extends PtProject {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量
    private Long ptId;//私教套餐Id

}