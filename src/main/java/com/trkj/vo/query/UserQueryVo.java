package com.trkj.vo.query;


import lombok.Data;

@Data
public class UserQueryVo extends PageVo {
    private Long id;
    private String username;
    private String departmentName;
    private String empName;

}
