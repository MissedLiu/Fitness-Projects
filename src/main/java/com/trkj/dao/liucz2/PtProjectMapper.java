package com.trkj.dao.liucz2;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.vo.queryLiucz2.PtProjectVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 张鑫
* @description 针对表【pt_project(私教项目类型表)】的数据库操作Mapper
* @createDate 2022-09-26 10:08:04
* @Entity com.trkj.entity.PtProject
*/
public interface PtProjectMapper extends BaseMapper<PtProject> {
    /*添加私教项目*/
    @Insert(value = "insert into pt_projectname (ptp_name,create_time,update_time,ptp_is)" +
            " value (#{ptpName},now(),now(),#{ptpIs})")
    boolean addPtProject(PtProject ptProject);
    /*
    * 根据条件分页查询所有私教项目
    * */
    IPage<PtProject> findPtProject(IPage<PtProject> page , @Param("query") PtProjectVo query);
    /*
     * 根据条件分页查询所有私教项目并且状态为启用
     * */
    IPage<PtProject> findPtProjectState(IPage<PtProject> page , @Param("query") PtProjectVo query);
    /*
    * 根据项目名称查询是否存在
    * */
    PtProject findPtAllByPtpName(String name);
    /**
     * @description:
     * 根据私教套餐id查找该私教套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @Select("select ptp_id from pt_choose where pt_id = #{ptId}")
    List<Long> findPtpIdByPtId(Long ptId);
    /*
     * 查询所有的私教套餐名
     * */
    List<PtProject> findAllName ( Long ptpId);
}




