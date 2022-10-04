package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtChoose;
import com.trkj.entity.liucz2.TeamChoose;

public interface PtChooseSerivce extends IService<PtChoose> {
    /*
    * 根据私教项目编号查询套餐id
    * */
    boolean findPtChoose(Long id);

}
