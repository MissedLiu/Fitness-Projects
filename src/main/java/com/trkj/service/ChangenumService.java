package com.trkj.service;

import com.trkj.entity.Changenum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PoQueryVo;

import java.util.List;

/**
* @author oyzz
* @description 针对表【changenum(报损报溢表)】的数据库操作Service
* @createDate 2022-09-23 19:43:53
*/
public interface ChangenumService extends IService<Changenum> {
    Boolean toChangenum(PoQueryVo poQueryVo);
}
