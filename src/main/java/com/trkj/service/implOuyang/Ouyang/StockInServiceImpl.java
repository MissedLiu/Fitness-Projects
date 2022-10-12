package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.ouyang.StockInVoMapper;
import com.trkj.dto.CaiGouShenHeDTO;
import com.trkj.entity.ouyang.StockIn;
import com.trkj.service.implOuyang.StockInService;
import com.trkj.dao.ouyang.StockInMapper;
import com.trkj.vo.queryOuyang.PoQueryVo;
import com.trkj.vo.queryOuyang.StockInQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author oyzz
 * @description 针对表【stock_in(物品入库表)】的数据库操作Service实现
 * @createDate 2022-09-23 20:22:01
 */
@Service
@Transactional
public class StockInServiceImpl extends ServiceImpl<StockInMapper, StockIn>
        implements StockInService {

    @Resource
    private StockInMapper stockInMapper;

    @Resource
    private StockInVoMapper stockInVoMapper;

    //添加入库记录
    @Override
    public boolean toStock(PoQueryVo poQueryVo) {
        return stockInMapper.toInStock(poQueryVo);
    }

    @Override
    public IPage<StockInQueryVo> findAllStockIn( StockInQueryVo stockInQueryVo) {
        Page<StockInQueryVo> page=new Page<>(stockInQueryVo.getPageNo(),stockInQueryVo.getPageSize());

        return stockInVoMapper.findStockInAllAndLoseOrMore(page,stockInQueryVo);
    }


}




