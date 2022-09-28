package com.trkj.vo.query;


import com.trkj.entity.Emp;
import lombok.Data;

@Data
public class EmpQueryVo extends Emp {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量

}
