package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.Flyer;
import com.trkj.vo.queryLiucz2.FlyerVo;


import java.util.List;

/**
* @author 张鑫
* @description 针对表【flyer(宣传活动记录表)】的数据库操作Service
* @createDate 2022-09-27 09:37:08
*/
public interface FlyerService extends IService<Flyer> {
    /**
     * @description:
     * 按条件查询并且分页
     * @author: Liucz
     * @date: 2022/9/29 19:37
     * @param: [flyer]
     * @return: java.util.List<com.trkj.entity.liucz2.Flyer>
     **/
    IPage<Flyer> selectAllFlyer(FlyerVo flyerVo);
    /**
     * @description:添加
     * @author: Liucz
     * @date: 2022/9/29 19:37
     * @param: [flyer]
     * @return: java.lang.Boolean
     **/
    Boolean addFlyer(Flyer flyer);

}
