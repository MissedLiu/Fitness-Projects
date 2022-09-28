package com.trkj.vo.queryLiucz;


import com.trkj.entity.liucz.Emp;
import lombok.Data;

@Data
public class EmpQueryVo extends Emp {
    private Long pageNo =1L ;//当前页码
    private Long pageSize=10L ;//每页显示数量

}
