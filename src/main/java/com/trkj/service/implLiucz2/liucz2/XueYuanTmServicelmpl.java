package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.XueYuanPtMapper;
import com.trkj.dao.liucz2.XueYuanTmMapper;
import com.trkj.service.implLiucz2.PtMealService;
import com.trkj.service.implLiucz2.TeamMealService;
import com.trkj.service.implLiucz2.XueYuanTmService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz.CountTongJi;
import com.trkj.vo.queryLiucz2.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.service.implLiucz2.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  20:01
 * @Description: TODO
 * @Version: 5.0
 */
@Service

public class XueYuanTmServicelmpl  implements XueYuanTmService {
    @Resource
    private XueYuanTmMapper xueYuanTmMapper;
    @Resource
    private PtMealService ptMealService;
    @Resource
    private TeamMealService teamMealService;
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @Override
    public IPage<XueYuanTmVo> findAllList(PageVo pageVo) {
        Page<XueYuanTmVo> page=new Page<>(pageVo.getPageNo() ,pageVo.getPageSize());
        IPage<XueYuanTmVo> all = xueYuanTmMapper.findAll(page, pageVo);
        return all;
    }
    /**
     * @description:
     * 查询个个教练下的会员数量
     * @author: Liucz
     * @date: 2022/10/10 20:22
     * @param:
     * @return:
     **/
    @Override
    public List<JiaolianNumVo> findNUm() {
        List<JiaolianNumVo> nUm = xueYuanTmMapper.findNUm();
        return nUm;
    }
    /**
     * @description:
     * 返回统计私教团操人数
     * @author: Liucz
     * @date: 2022/10/12 21:20
     * @param:
     * @return:
     **/
    @Override
    public List<CountTongJi> CountTongJi() {
        //查询私教套餐人数
        List<CountPtVo> countPtVos = ptMealService.CountPtNum();
        //查询团操套餐人数
        List<CountTeamVo> countTeamVos = teamMealService.CountTeamNum();
        //设置返回数据
        CountTongJi countTongJi=new CountTongJi();
        List<CountTongJi> list=new ArrayList<>();
        for (CountPtVo countPtVo: countPtVos) {
            for (CountTeamVo countTeamVo: countTeamVos) {
                if (countPtVo.getName()==countTeamVo.getName()){
                    countTongJi.setName(countPtVo.getName());
                    countTongJi.setPvalue(countPtVo.getValue());
                    countTongJi.setPvalue(countTeamVo.getValue());
                    list.add(countTongJi);
                }
            }
        }

        return list;
    }
    /**
     * @description:
     * 统计个个教练下的人数
     * @author: Liucz
     * @date: 2022/10/13 14:30
     * @param:
     * @return:
     **/
    @Override
    public List<JiaolianNumVo> findjiaolainNUm() {
        List<JiaolianNumVo> jiaolianNumVos = xueYuanTmMapper.findjiaolainNUm();
        return jiaolianNumVos;
    }

}