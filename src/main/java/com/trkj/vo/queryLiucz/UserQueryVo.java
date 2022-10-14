package com.trkj.vo.queryLiucz;


import com.trkj.vo.query.PageVo;
import lombok.Data;

@Data
public class UserQueryVo extends PageVo {
    private Long id;
    private String username;
    private String departmentName;
    private String departmentId;
    private String empName;

}
