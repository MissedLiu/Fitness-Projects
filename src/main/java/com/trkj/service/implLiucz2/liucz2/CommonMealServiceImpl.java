package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.CommonMealMapper;
import com.trkj.entity.liucz2.CommonMeal;
import com.trkj.service.implLiucz2.CommonMealService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Service实现
* @createDate 2022-09-22 21:34:27
*/
@Service
public class CommonMealServiceImpl extends ServiceImpl<CommonMealMapper, CommonMeal>
    implements CommonMealService {

    @Resource
    private CommonMealMapper commonMealMapper;
    @Override
    /*查询所有普通套餐*/
    public IPage<CommonMeal> selectAllCommonMeal(PageVo pageVo) {
        Page<CommonMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<CommonMeal> allByCmNameCommonMealIPage = commonMealMapper.findAllByCmNameCommonMealIPage(page, pageVo);
        return allByCmNameCommonMealIPage;
    }
    /**
     * @description:动态按条件查询普通套餐,状态为1的数据列表
     * @author: Liucz
     * @date: 2022/9/30 10:29
     * @param: [commonMeal]
     * @return: java.util.List<com.trkj.entity.liucz2.CommonMeal>
     **/
    @Override
    public IPage<CommonMeal> selectAllCommonMealState(PageVo pageVo) {
        Page<CommonMeal> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<CommonMeal> allByCmNameCommonMealIPage = commonMealMapper.findAllByCmNameCommonMealIPage(page, pageVo);
        return allByCmNameCommonMealIPage;
    }
/**
 * @description:
 * 判断当前输入的套餐名是否存在
 * @author: Liucz
 * @date: 2022/9/30 14:10
 * @param: [name]
 * @return: boolean
 **/
    @Override
    public CommonMeal checkCommonMeal(String name) {
        QueryWrapper<CommonMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cm_name",name);
        CommonMeal commonMeal = baseMapper.selectOne(queryWrapper);
        return commonMeal;
    }

    @Override
    /*添加套餐*/
    public Boolean addCommonMeal(CommonMeal commonMeal) {
        return commonMealMapper.addCommonMeal(commonMeal);
    }
}






