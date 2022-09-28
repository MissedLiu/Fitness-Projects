package com.trkj.vo.query;

import lombok.Data;

@Data
public class UserRoleQueryVo {
    private Long id; //账户Id
    private String username;//账户名字
    private String roleName;//拥有的角色名称
}
