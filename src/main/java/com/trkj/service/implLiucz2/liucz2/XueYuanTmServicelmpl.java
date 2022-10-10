package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.XueYuanPtMapper;
import com.trkj.dao.liucz2.XueYuanTmMapper;
import com.trkj.service.implLiucz2.XueYuanTmService;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.queryLiucz2.JiaolianNumVo;
import com.trkj.vo.queryLiucz2.XueYuanPtVo;
import com.trkj.vo.queryLiucz2.XueYuanTmVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}