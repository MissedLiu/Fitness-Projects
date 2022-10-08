package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.XueYuanMapper;
import com.trkj.service.implLiucz2.XueYuanService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.XueYuanVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.service.implLiucz2.liucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-08  17:15
 * @Description: TODO
 * @Version: 5.0
 */
@Service
public class XueYuanServicelmpl extends ServiceImpl<XueYuanMapper, XueYuanVo>
        implements XueYuanService {
    @Resource
    private XueYuanMapper xueYuanMapper;
    /**
     * @description:
     * 分页动态查询学员列表
     * @author: Liucz
     * @date: 2022/10/8 17:17
     * @param:
     * @return:
     **/
    @Override
    public IPage<XueYuanVo> findAllList(PageVo pageVo) {
        Page<XueYuanVo> page=new Page<>(pageVo.getPageNo() ,pageVo.getPageSize());
        IPage<XueYuanVo> all = xueYuanMapper.findAll(page, pageVo);
        return all;
    }
}