package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.PtCoachMapper;
import com.trkj.entity.liucz2.PtCoach;

import com.trkj.entity.liucz2.PtMeal;
import com.trkj.service.implLiucz2.PtCoachService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class PtCoachServiceImpl extends ServiceImpl<PtCoachMapper, PtCoach>
    implements PtCoachService {
    @Resource
    private PtCoachMapper ptCoachMapper;
    /**
     * @description:
     * 根据教练id查询套餐列表
     * @author: Liucz
     * @date: 2022/10/8 12:11
     * @param:
     * @return:
     **/
    @Override
    public List<PtMeal> findPtIdByCoachId(PageVo pageVo) {
        Page<PtCoach> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<PtCoach> ptMeamByCoachId = ptCoachMapper.findPtMeamByCoachId(page, pageVo);
        List<PtMeal> list=null;
        ptMeamByCoachId.getRecords().forEach(ptCoach -> {
            System.out.println("ee="+ ptCoach.getPtMeals());
            ptCoach.getPtMeals().forEach(ptMeal -> {
                list.add(ptMeal);
            });

        });
        System.out.println("ssss="+ptMeamByCoachId.getRecords());
        return list;
    }
}




