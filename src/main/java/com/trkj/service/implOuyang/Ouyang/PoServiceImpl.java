package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.Po;
import com.trkj.service.implOuyang.PoService;
import com.trkj.dao.ouyang.PoMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【po(物品已购表)】的数据库操作Service实现
* @createDate 2022-09-22 11:33:17
*/
@Service
@Transactional
public class PoServiceImpl extends ServiceImpl<PoMapper, Po>
    implements PoService{

    @Resource
    private PoMapper poMapper;

    @Override
    public IPage<Po> findAllPo(IPage page, PoQueryVo poQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Po> queryWrapper = new QueryWrapper<Po>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(poQueryVo.getPoName()),"po_name", poQueryVo.getPoName());
        //通过时间排序
        queryWrapper.orderByDesc("po_time");
        //获取store列表
        return  baseMapper.selectPage(page,queryWrapper);

    }

    /**
     * 修改已购物品状态（未入库、已入库）
     * @param poQueryVo
     * @return
     */
    @Transactional
    @Override
    public boolean updatePoState(PoQueryVo poQueryVo) {
        return poMapper.updatePoState(poQueryVo);
    }

    /**
     * 获取未入库的记录
     * @param page
     * @param poQueryVo
     * @return
     */
    @Override
    public IPage<Po> getNotExecuted(IPage<Po> page, PoQueryVo poQueryVo) {
        QueryWrapper<Po> queryWrapper = new QueryWrapper();
        queryWrapper.eq("po_state","未入库");
        return baseMapper.selectPage(page,queryWrapper);
    }
    /**
     * @description:
     * 根据id删除数据
     * @author: Liucz
     * @date: 2022/10/10 22:01
     * @param:
     * @return:
     **/
    @Transactional
    @Override
    public int deleteByid(Long id) {
        int i = poMapper.deleteByPoIdInt(id);
        return i;
    }
}




