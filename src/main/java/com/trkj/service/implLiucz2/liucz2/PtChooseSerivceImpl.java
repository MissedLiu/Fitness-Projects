package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.PtChooseMapper;
import com.trkj.entity.liucz2.PtChoose;
import com.trkj.service.implLiucz2.PtChooseSerivce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class PtChooseSerivceImpl extends ServiceImpl<PtChooseMapper, PtChoose> implements PtChooseSerivce {
    @Resource
    private PtChooseMapper ptChooseMapper;
    /*
     * 根据私教项目编号查询套餐id
     * */
    @Override
    public boolean findPtChoose(Long id) {
        QueryWrapper<PtChoose> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("ptp_id" ,id);
        //当查询数据存在,不能删除 返回false;
        List<PtChoose> ptChooses = baseMapper.selectList(queryWrapper);
        ptChooses.forEach(System.out::println);
        if (ptChooses.size() !=0){
            return false;
        }
        return true;
    }
}
