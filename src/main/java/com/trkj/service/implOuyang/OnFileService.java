package com.trkj.service.implOuyang;

import com.trkj.entity.ouyang.OnFile;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryOuyang.DisburseQueryVo;
import com.trkj.vo.queryOuyang.OnFileQueryVo;

/**
* @author oyzz
* @description 针对表【on_file(归档信息表)】的数据库操作Service
* @createDate 2022-10-12 15:20:49
*/
public interface OnFileService extends IService<OnFile> {
    /**
     * 根据时间和类型查询归档记录表中是否已存在当前输入的时间的归档记录
     *
     * @param onFileQueryVo
     * @return
     */
    Long getFileNumByDate(OnFileQueryVo onFileQueryVo);

    /**
     * 获取输入的年月所有的支出金额总和
     *
     * @param onFileQueryVo
     * @return
     */
    Long SumDisbursePrice(OnFileQueryVo onFileQueryVo);

    /**
     * 获取输入的年月所有的商品收入总和
     * @param onFileQueryVo
     * @return
     */
    Long SumInvoicePrice(OnFileQueryVo onFileQueryVo);

    /**
     * 获取输入的年月所有的套餐收入总和
     * @param onFileQueryVo
     * @return
     */
    Long SumProceedsPrice(OnFileQueryVo onFileQueryVo);

    /**
     * 添加归档记录
     * @param onFileQueryVo
     * @return
     */
    boolean toOnFile(OnFileQueryVo onFileQueryVo);
}
