package com.trkj;

import com.trkj.dao.liucz.UserAndEmpMapper;
import com.trkj.dao.liucz2.PtProjectMapper;
import com.trkj.dao.liucz2.SalesArticleMapper;
import com.trkj.entity.liucz2.Invoice;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.entity.liucz2.SalesArticle;
import com.trkj.service.implLiucz.UserService;
import com.trkj.service.implLiucz2.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private PtProjectMapper ptProjectMapper;
    @Resource
    private InvoiceService invoiceService;
    @Resource
    private SalesArticleMapper salesArticleMapper;
    @Autowired
    private UserService userService;
//    @Test
//    public void testXmlQuery3Service(){
//        List<SalesArticle> salesArticles = salesArticleMapper.findInvoiceAndSalesAll();
//        salesArticles.forEach(System.out::println);
//    }
//    @Test
//    public void testXmlQuery4Service(){
//
//        List<Long> list=new ArrayList<>();
//        list.add(4L);
//        Long[] x =new  [4,6];
//       ptProjectMapper.findAllName(List);
//    }
}
