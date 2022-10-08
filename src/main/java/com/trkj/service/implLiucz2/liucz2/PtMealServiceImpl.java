package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.PtMealMapper;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.service.implLiucz2.PtMealService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PtMealServiceImpl extends ServiceImpl<PtMealMapper, PtMeal> implements PtMealService {
    @Resource
    private PtMealMapper ptMealVoMapper;
    @Override
    /**
     * @description:
     * 查询所有私教套餐
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.vo.queryLiucz2.PtMealVo>
     **/
    public IPage<PtMeal> selectAllPtMeal(PageVo pageVo) {
        Page<PtMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<PtMeal> ptMealAll = ptMealVoMapper.findPtMealAll(page, pageVo);
        return ptMealAll;
    }
    /**
     * @description:
     * 查询所有私教套餐,状态为0开启的
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.vo.queryLiucz2.PtMealVo>
     **/
    public IPage<PtMeal> selectAllPtMealState(PageVo pageVo) {
        Page<PtMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<PtMeal> ptMealAll = ptMealVoMapper.findPtMealAllSteta(page, pageVo);
        return ptMealAll;
    }
    /**
     * @description:
     * 判断当前需要添加的私教套餐名有没有被使用
     * @author: Liucz
     * @date: 2022/10/2 14:53
     * @param:
     * @return:
     **/
    @Override
    public PtMeal findAllByPtname(PtMeal ptMeal) {
        QueryWrapper<PtMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pt_name",ptMeal.getPtName());
        PtMeal ptMeal1 = baseMapper.selectOne(queryWrapper);
        return ptMeal1;
    }
    /**
     * @description:
     * 分配私教项目给私教套餐
     * @author: Liucz
     * @date: 2022/10/2 17:19
     * @param: [ptId, ptpId]
     * @return: boolean
     **/
    @Override
    public boolean savePtMealPtProject(Long ptId, List<Long> ptpId) {
        //分配之前先删除原本有的
        baseMapper.deletePtMealPtProject(ptId);
        //在重新添加

        return   baseMapper.savePtMealPtProject(ptId,ptpId)>0;
    }


}
