package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.vo.queryLiucz2.PtProjectVo;


import java.util.List;

/**
* @author 张鑫
* @description 针对表【pt_project(私教项目类型表)】的数据库操作Service
* @createDate 2022-09-26 10:08:04
*/
public interface PtProjectService extends IService<PtProject> {
    /**
     * @description:
     * 查询私教项目列表
     * @author: Liucz
     * @date: 2022/10/2 15:28
     * @param: [ptProjectVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.PtProject>
     **/
    IPage<PtProject> selectPtProject(PtProjectVo ptProjectVo);
    /**
     * @description:
     * 查询私教项目列表,用于弹窗的
     * @author: Liucz
     * @date: 2022/10/2 15:28
     * @param: [ptProjectVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.PtProject>
     **/
    IPage<PtProject> selectPtProjectState(PtProjectVo ptProjectVo);

    /**
     * @description:
     * t添加私教项目
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param: [ptProject]
     * @return: java.lang.Boolean
     **/
    Boolean addPtProject(PtProject ptProject);
   /**
    * @description:
    * 根据传入的项目名称查询id
    * @author: Liucz
    * @date: 2022/10/2 15:29
    * @param: [name]
    * @return: com.trkj.entity.liucz2.PtProject
    **/
    PtProject findPtIdByPtpName(String name);

    /**
     * @description:
     * 根据私教套餐id查找该私教套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    List<Long> findPtpIdByPtId(Long ptId);
    /*
     * 查询所有的私教套餐名
     * */
    List<PtProject> findAllName (Long ptId);


}
