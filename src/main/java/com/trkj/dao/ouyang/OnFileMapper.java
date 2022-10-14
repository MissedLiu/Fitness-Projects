package com.trkj.dao.ouyang;

import com.trkj.entity.ouyang.OnFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.OnFileQueryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
* @author oyzz
* @description 针对表【on_file(归档信息表)】的数据库操作Mapper
* @createDate 2022-10-12 15:20:49
* @Entity com.trkj.entity.ouyang.OnFile
*/
public interface OnFileMapper extends BaseMapper<OnFile> {

    @Select(value = "SELECT COUNT( * ) FROM on_file   WHERE date LIKE concat('%',#{changeTime},'%') and type=#{onFileType}")
    Long countOnFileByDate(OnFileQueryVo onFileQueryVo);

    //通过时间累加当月所有的支出
    @Select(value = "select sum(disburse_price) from disburse where disburse_time like concat('%',#{changeTime},'%')")
    Long SumDisbursePrice(OnFileQueryVo onFileQueryVo);

    //通过时间累加当月所有的商品收入
    @Select(value = "select sum(price) from invoice where create_time like concat('%',#{changeTime},'%')")
    Long SumInvoicePrice(OnFileQueryVo onFileQueryVo);

    //通过时间累加当月所有的套餐收入
    @Select(value = "select sum(proceeds_price) from proceeds where proceeds_time like concat('%',#{changeTime},'%')")
    Long SumProceedsPrice(OnFileQueryVo onFileQueryVo);

    //添加归档记录
    @Insert(value = "insert into on_file(money, type, date)values(#{sumPrice},#{onFileType},#{changeTime}) ")
    boolean toOnFile(OnFileQueryVo onFileQueryVo);
}




