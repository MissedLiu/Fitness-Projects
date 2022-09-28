package com.trkj.vo.queryLiucz;

import lombok.Data;

@Data
public class UserVo {
    /**
     * 登录名称(用户名)
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;
    /**
     * 所属部门ID
     */
    private Long departmentId;

    /**
     * 所属部门名称
     */
    private String departmentName;
}
