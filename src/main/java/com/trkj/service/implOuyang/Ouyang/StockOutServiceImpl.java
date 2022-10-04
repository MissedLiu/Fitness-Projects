package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.StockOut;
import com.trkj.service.implOuyang.StockOutService;
import com.trkj.dao.ouyang.StockOutMapper;
import com.trkj.vo.queryOuyang.StockOutQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【stock_out(物品出库表)】的数据库操作Service实现
* @createDate 2022-09-27 10:39:53
*/
@Service
public class StockOutServiceImpl extends ServiceImpl<StockOutMapper, StockOut>
    implements StockOutService{
    @Resource
    private StockOutMapper stockOutMapper;
    @Override
    public IPage<StockOut> findStockOut(IPage<StockOut> page, StockOutQueryVo stockOutQueryVo) {
        //创建条件构造器对象
        QueryWrapper<StockOut> queryWrapper = new QueryWrapper<StockOut>();
        //添加条件
        queryWrapper.like(!ObjectUtils.isEmpty(stockOutQueryVo.getStockinName()), "stockin_name", stockOutQueryVo.getStockinName());
        //获取store列表
        return baseMapper.selectPage(page, queryWrapper);
    }
    /**
     * @description:
     * 查询出库数
     * @author: Liucz
     * @date: 2022/10/1 19:36
     * @param:
     * @return:
     **/
    @Override
    public Long findStockOutNum(Long id) {
        QueryWrapper<StockOut> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("out_id" ,id);
        StockOut stockOut = baseMapper.selectOne(queryWrapper);
        return stockOut.getOutNum();
    }
    /**
     * @description:
     * 查询物品数
     * @author: Liucz
     * @date: 2022/10/1 19:36
     * @param:
     * @return:
     **/
    @Override
    public Long findStockNum(Long id) {
        QueryWrapper<StockOut> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("out_id" ,id);
        StockOut stockOut = baseMapper.selectOne(queryWrapper);
        return stockOut.getStoreNum();
    }
    /**
     * @description:
     * 修改商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    @Override
    public int updateStockStoerNum(Long stockinId, Long storeNum) {
        QueryWrapper<StockOut> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("stockin_id" ,stockinId);
        StockOut stockOut = baseMapper.selectOne(queryWrapper);
        System.out.println("wwwwwwwwwwwwwwww"+stockOut);
        System.out.println("stockinId=="+stockinId);
        System.out.println("storeNum=="+storeNum);
        int i = stockOutMapper.updateOutNum(stockinId, stockOut.getStoreNum()-storeNum);
        return i;
    }
    /**
     * @description:
     * 修改商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    @Override
    public int updateStockStoerNum2(Long outId, Long storeNum) {
        QueryWrapper<StockOut> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("out_id" ,outId);
        StockOut stockOut = baseMapper.selectOne(queryWrapper);
        int i = stockOutMapper.updateOutNum2(outId, stockOut.getStoreNum()-storeNum);
        return i;
    }
    /**
     * @description:
     * 归还已购的商品数
     * @author: Liucz
     * @date: 2022/10/1 20:42
     * @param: [stockinId, storeNum]
     * @return: int
     **/
    @Override
    public int updateAddStockStoerNum(Long outId, Long storeNum) {

        int i = stockOutMapper.updateOutNum2(outId, storeNum);
        return i;

    }
}




