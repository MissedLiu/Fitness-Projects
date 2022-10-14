package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.PtProjectMapper;
import com.trkj.entity.liucz2.PtProject;
import com.trkj.service.implLiucz2.PtMealService;
import com.trkj.service.implLiucz2.PtProjectService;
import com.trkj.vo.queryLiucz2.PtProjectVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 张鑫
* @description 针对表【pt_project(私教项目类型表)】的数据库操作Service实现
* @createDate 2022-09-26 10:08:04
*/
@Service

public class PtProjectServiceImpl extends ServiceImpl<PtProjectMapper, PtProject>
    implements PtProjectService {
    @Resource
    private  PtProjectMapper ptProjectMapper;
    @Resource
    private PtMealService ptMealService;
    /**
     * @description:
     * 查询私教项目列表
     * @author: Liucz
     * @date: 2022/10/2 15:28
     * @param: [ptProjectVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.PtProject>
     **/
    @Override
    public IPage<PtProject> selectPtProject(PtProjectVo ptProjectVo) {
        Page<PtProject> page=new Page<>(ptProjectVo.getPageNo(),ptProjectVo.getPageSize());
        IPage<PtProject> ptProject = ptProjectMapper.findPtProject(page, ptProjectVo);
        return  ptProject;
    }
    /**
     * @description:
     * 查询私教项目列表,用于弹窗的,并且私教项目状态为启用的
     * @author: Liucz
     * @date: 2022/10/2 15:28
     * @param: [ptProjectVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.PtProject>
     **/
    @Override
    public IPage<PtProject> selectPtProjectState(PtProjectVo ptProjectVo) {
        Page<PtProject> page=new Page<>(ptProjectVo.getPageNo(),ptProjectVo.getPageSize());
        IPage<PtProject> ptProject = ptProjectMapper.findPtProjectState(page, ptProjectVo);
        return  ptProject;
    }

    /*
* 添加私教项目
* */
    @Transactional
    @Override
    public Boolean addPtProject(PtProject ptProject) {
        PtProject ptAllByPtpName = ptProjectMapper.findPtAllByPtpName(ptProject.getPtpName());
        System.out.println("ptAllByPtpName=="+ptAllByPtpName);
        if (ptAllByPtpName!=null){
            //不为空则存在,不能添加
            return false;
        }
        return true;
    }
    /*
     * 根据传入的项目名称查询id
     * */
    @Override
    public PtProject findPtIdByPtpName(String name) {
        QueryWrapper<PtProject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("ptp_name",name);
        PtProject ptProject = ptProjectMapper.selectOne(queryWrapper);
        if (ptProjectMapper.selectOne(queryWrapper) == null){
            return null;
        }
        return ptProject;
    }
    /**
     * @description:
     * 根据私教套餐id查找该私教套餐的项目id
     * @author: Liucz
     * @date: 2022/10/2 15:29
     * @param:
     * @return:
     **/
    @Override
    public List<Long> findPtpIdByPtId(Long ptId) {
        return   baseMapper.findPtpIdByPtId(ptId);
    }

    /*
     * 查询所有的私教套餐名
     * */
    @Override
    public List<PtProject> findAllName( Long ptId) {
        List<Long> ptpIdByPtId = baseMapper.findPtpIdByPtId(ptId);
        List<PtProject> list=new ArrayList<>();
        for (Long ptpIdByPtIds: ptpIdByPtId) {
            List<PtProject> allName = ptProjectMapper.findAllName(ptpIdByPtIds);
            for (PtProject allNames: allName) {
                list.add(allNames);
            }
        }
        return list;
    }
}




