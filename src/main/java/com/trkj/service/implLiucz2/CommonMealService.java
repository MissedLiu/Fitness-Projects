package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.CommonMeal;
import com.trkj.vo.query.PageVo;

/**
* @author 张鑫
* @description 针对表【common_meal(普通会员套餐表)】的数据库操作Service
* @createDate 2022-09-22 21:34:27
*/
public interface CommonMealService extends IService<CommonMeal> {
      /**
       * @description:动态按条件查询普通套餐
       * @author: Liucz
       * @date: 2022/9/30 10:29
       * @param: [commonMeal]
       * @return: java.util.List<com.trkj.entity.liucz2.CommonMeal>
       **/
      IPage<CommonMeal> selectAllCommonMeal(PageVo pageVo);
      /**
       * @description:动态按条件查询普通套餐,状态为1的数据列表
       * @author: Liucz
       * @date: 2022/9/30 10:29
       * @param: [commonMeal]
       * @return: java.util.List<com.trkj.entity.liucz2.CommonMeal>
       **/
      IPage<CommonMeal> selectAllCommonMealState(PageVo pageVo);
      /**
       * @description:
       * 判断当前输入的套餐名是否存在
       * @author: Liucz
       * @date: 2022/9/30 14:09
       * @param: [commonMeal]
       * @return: java.lang.Boolean
       **/
      CommonMeal checkCommonMeal(String name);
      /*t添加普通套餐*/
      Boolean addCommonMeal(CommonMeal commonMeal);

}
