package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.CaigouShenheMapper;
import com.trkj.entity.liucz2.CaigouShenhe;

import com.trkj.service.implLiucz2.CaigouShenheService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class CaigouShenheServiceImpl extends ServiceImpl<CaigouShenheMapper, CaigouShenhe>
    implements CaigouShenheService {
    @Resource
    private CaigouShenheMapper caigouShenheMapper;
    /**
     * @description:
     * 根据采购编号查询结果
     * @author: Liucz
     * @date: 2022/10/5 15:07
     * @param:
     * @return:
     **/
    @Override
    public List<CaigouShenhe> checkShenqing(Long id) {
        QueryWrapper<CaigouShenhe> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("schedule_id",id);
        List<CaigouShenhe> caigouShenhes = baseMapper.selectList(queryWrapper);
        return caigouShenhes;
    }
    //同意事件,修改状态=1
    @Override
    public int updateAgress(CaigouShenhe caigouShenhe) {
        int i = caigouShenheMapper.UpdateState(caigouShenhe);
        return i;
    }
    //拒绝事件,修改状态=2
    @Override
    public int updateRefuse(CaigouShenhe caigouShenhe) {
        int i = caigouShenheMapper.UpdateRefuseState(caigouShenhe);
        return i;

    }
    /**
     * @description:
     * 根据采购编号查询审核状态
     * @author: Liucz
     * @date: 2022/10/5 19:07
     * @param:
     * @return:
     **/
    @Override
    public List<CaigouShenhe> findAllState(Long id) {
        QueryWrapper<CaigouShenhe> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("schedule_id" ,id);
        List<CaigouShenhe> caigouShenhes = baseMapper.selectList(queryWrapper);
        return caigouShenhes;
    }
    /**
     * @description:
     * 删除事件,修改状态=5
     * @author: Liucz
     * @date: 2022/10/5 19:49
     * @param:
     * @return:
     **/

    @Override
    public int delete5(CaigouShenhe caigouShenhe) {
        int i = caigouShenheMapper.delete5(caigouShenhe);
        return i;
    }
    /**
     * @description:
     * 删除审核记录事件
     * @author: Liucz
     * @date: 2022/10/5 19:49
     * @param:
     * @return:
     **/
    @Override
    public int delete6(Long id) {
        QueryWrapper<CaigouShenhe> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("schedule_id" ,id);
        int i = baseMapper.delete(queryWrapper);
        return i;
    }

}




