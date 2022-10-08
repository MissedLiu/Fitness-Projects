package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtMeal;
import com.trkj.vo.query.PageVo;

import java.util.List;


/**
* @author 张鑫
* @description 针对表【pt_meal(私教会员套餐表)】的数据库操作Service
* @createDate 2022-09-23 14:31:38
*/
public interface PtMealService extends IService<PtMeal> {
    /**
     * @description:
     * 查询所有私教套餐
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.vo.queryLiucz2.PtMealVo>
     **/
    IPage<PtMeal> selectAllPtMeal(PageVo pageVo);
    /**
     * @description:
     * 查询所有私教套餐,状态为0开启的
     * @author: Liucz
     * @date: 2022/10/2 14:29
     * @param: [ptMealVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.vo.queryLiucz2.PtMealVo>
     **/
    IPage<PtMeal> selectAllPtMealState(PageVo pageVo);
    /**
     * @description:
     * 判断当前需要添加的私教套餐名有没有被使用
     * @author: Liucz
     * @date: 2022/10/2 14:53
     * @param:
     * @return:
     **/
    PtMeal findAllByPtname(PtMeal ptMeal);
    /**
     * @description:
     * 分配私教项目给私教套餐
     * @author: Liucz
     * @date: 2022/10/2 17:19
     * @param: [ptId, ptpId]
     * @return: boolean
     **/
    boolean savePtMealPtProject(Long ptId, List<Long> ptpId);
}
