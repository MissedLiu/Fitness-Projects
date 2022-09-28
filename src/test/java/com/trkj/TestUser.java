package com.trkj;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.UserAndEmpMapper;
import com.trkj.entity.User;
import com.trkj.entity.UserAndEmp;
import com.trkj.service.UserService;
import com.trkj.vo.query.UserQueryVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
public class TestUser {
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private UserAndEmpMapper userAndEmpMapper;


    //加密操作
    @Test
    public void tset() {
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }



    @Autowired
    private UserService userService;
//    @Test
//    public void testXmlQuery3Service(){
//        //模拟前端传输数据：
//        UserQueryVo userQueryVo = new UserQueryVo();
//        //当前页
//        userQueryVo.setPageNo(1L);
//        //每页数量
//        userQueryVo.setPageSize(4L);
////        Page<UserAndEmp> page=new Page<>(userQueryVo.getPageNo(),userQueryVo.());
//        IPage<UserQueryVo> userAndEmp = userService.findUserAndEmp(userQueryVo);
//        System.out.println(userAndEmp.getRecords());
//    }
//    @Test
//    public void testXmlQuery4Service(){
//        //模拟前端传输数据：
//        UserQueryVo userQueryVo = new UserQueryVo();
//        //当前页
//        userQueryVo.setPageNo(1L);
//        //每页数量
//        userQueryVo.setPageSize(4L);
////        Page<UserAndEmp> page=new Page<>(userQueryVo.getPageNo(),userQueryVo.());
//        IPage<User> userAndEmp = userService.findUserAndEmp2(userQueryVo);
//        System.out.println(userAndEmp.getRecords());
//    }
}
