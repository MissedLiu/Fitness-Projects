package com.trkj.service.implOuyang.Ouyang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.entity.ouyang.StockOutRecord;
import com.trkj.service.implOuyang.StockOutRecordService;
import com.trkj.dao.ouyang.StockOutRecordMapper;
import com.trkj.vo.queryOuyang.StockOutRecordQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
* @author oyzz
* @description 针对表【stock_out_record(物品出库记录表)】的数据库操作Service实现
* @createDate 2022-10-12 09:59:51
*/
@Service
public class StockOutRecordServiceImpl extends ServiceImpl<StockOutRecordMapper, StockOutRecord>
    implements StockOutRecordService{

    @Resource
    private StockOutRecordMapper stockOutRecordMapper;

    /**
     * 分页获取出库记录
     * @param page
     * @param queryVo
     * @return
     */
    @Override
    public IPage<StockOutRecord> getList(IPage page, StockOutRecordQueryVo queryVo) {
        QueryWrapper queryWrapper=new QueryWrapper();
        //根据物品名模糊查询
        queryWrapper.like(!ObjectUtils.isEmpty(queryVo.getStockinName()),"stockin_name",queryVo.getStockinName());
        //根据领取人查询
        queryWrapper.eq(!ObjectUtils.isEmpty(queryVo.getEmpName()),"emp_name",queryVo.getEmpName());
        //根据出库时间降序
        queryWrapper.orderByDesc("stockout_time");
        return stockOutRecordMapper.selectPage(page,queryWrapper);
    }
}




