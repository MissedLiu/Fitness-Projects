package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.OnFile;
import com.trkj.service.implOuyang.OnFileService;
import com.trkj.dao.ouyang.OnFileMapper;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryOuyang.CountQueryVo;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.OnFileQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;

/**
 * @author oyzz
 * @description 针对表【on_file(归档信息表)】的数据库操作Service实现
 * @createDate 2022-10-12 15:20:49
 */
@Service
public class OnFileServiceImpl extends ServiceImpl<OnFileMapper, OnFile>
        implements OnFileService {

    @Resource
    private OnFileMapper onFileMapper;

    @Override
    public Long getFileNumByDate(OnFileQueryVo onFileQueryVo) {
        return onFileMapper.countOnFileByDate(onFileQueryVo);
    }

    /**
     * 获取属于的年月所有的支出金额总和
     *
     * @param onFileQueryVo
     * @return
     */
    @Override
    public Long SumDisbursePrice(OnFileQueryVo onFileQueryVo) {
        Long Sumprice;
        //判断是否为空 不做此判断，如果返回结果为空就会报错
        if (ObjectUtils.isEmpty(onFileMapper.SumDisbursePrice(onFileQueryVo))) {
            Sumprice = 0l;
        } else {
            Sumprice = onFileMapper.SumDisbursePrice(onFileQueryVo);
        }
        return Sumprice;
    }

    /**
     * 获取前端传入的年月的商品收入总和
     *
     * @param onFileQueryVo
     * @return
     */
    @Override
    public Long SumInvoicePrice(OnFileQueryVo onFileQueryVo) {
        Long Sumprice;
        //判断是否为空 不做此判断，如果返回结果为空就会报错
        if (ObjectUtils.isEmpty(onFileMapper.SumInvoicePrice(onFileQueryVo))) {
            Sumprice = 0l;
        } else {
            Sumprice = onFileMapper.SumInvoicePrice(onFileQueryVo);
        }
        return Sumprice;
    }

    /**
     * 获取前端传入的年月的套餐收入总和
     *
     * @param onFileQueryVo
     * @return
     */

    @Override
    public Long SumProceedsPrice(OnFileQueryVo onFileQueryVo) {
        Long Sumprice;
        //判断是否为空 不做此判断，如果返回结果为空就会报错
        if (ObjectUtils.isEmpty(onFileMapper.SumProceedsPrice(onFileQueryVo))) {
            Sumprice = 0l;
        } else {
            Sumprice = onFileMapper.SumProceedsPrice(onFileQueryVo);
        }
        return Sumprice;
    }

    /**
     * 添加归档记录
     *
     * @param onFileQueryVo
     * @return
     */
    @Transactional
    @Override
    public boolean toOnFile(OnFileQueryVo onFileQueryVo) {
        return onFileMapper.toOnFile(onFileQueryVo);
    }

    @Override
    public IPage<CountQueryVo> getOnFile(IPage page, PageVo pageVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq(!ObjectUtils.isEmpty(pageVo.getType()),"type", pageVo.getType());
        queryWrapper.like(!ObjectUtils.isEmpty(pageVo.getChangeTime()),"date",pageVo.getChangeTime());
        queryWrapper.orderByDesc("date");
        return baseMapper.selectPage(page,queryWrapper);
    }
}




