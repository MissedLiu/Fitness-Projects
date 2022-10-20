package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.XueYuanPtMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.service.implLiucz2.XueYuanPtService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.service.implLiucz2.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  17:15
 * @Description: TODO
 * @Version: 5.0
 */
@Service

public class XueYuanPtServicelmpl extends ServiceImpl<XueYuanPtMapper, XueYuanPtVo>
        implements XueYuanPtService {
    @Resource
    private XueYuanPtMapper xueYuanMapper;
    @Resource
    private MemberMealMapper memberMealMapper;
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @Override
    public IPage<XueYuanPtVo> findAllList(PageVo pageVo) {
        Page<XueYuanPtVo> page=new Page<>(pageVo.getPageNo() ,pageVo.getPageSize());
        IPage<XueYuanPtVo> all = xueYuanMapper.findAllbyEmpId(page, pageVo);
        return all;
    }
    /**
     * @description:
     * 分页动态查询学员列表所有
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @Override
    public IPage<XueYuanPtVo> findAllListAll(PageVo pageVo) {
        Page<XueYuanPtVo> page=new Page<>(pageVo.getPageNo() ,pageVo.getPageSize());
        IPage<XueYuanPtVo> all = xueYuanMapper.findAllbyEmpIdAll(page, pageVo);
        return all;
    }
    /**
     * @description:
     * 根据会员id查询套餐和项目信息
     * @author: Liucz
     * @date: 2022/10/17 9:36
     * @param:
     * @return:
     **/
    @Override
    public List<XueYuanPtVo> findAllptMeal(PageVo pageVo) {
        QueryWrapper<MemberMeal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("member_id" ,pageVo.getMemberIds());
        List<MemberMeal> MemberMeal = memberMealMapper.selectList(queryWrapper);
        List<XueYuanPtVo> list=new ArrayList<>();
        //根据每一个套餐id循环查询所选项目以及套餐
        for (MemberMeal MemberMeals: MemberMeal) {
            XueYuanPtVo allbymmId = xueYuanMapper.findAllbymmId(pageVo.getEmpId(), MemberMeals.getMmId());
            if (allbymmId!=null)
            {
                list.add(allbymmId);
            }

        }
        return list;
    }
}