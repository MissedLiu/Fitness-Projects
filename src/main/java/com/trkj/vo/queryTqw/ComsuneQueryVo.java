package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class ComsuneQueryVo extends PageVo {
    /**
     * 编号
     */
    private Long comsuneId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 会员电话
     */
    private String memberPhone;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 套餐编号
     */
    private Long mealId;

    /**
     * 套餐名称
     */
    private String mealName;

    /**
     * 套餐类型
     */
    private String mealType;

    /**
     * 项目编号
     */
    private Long ptpId;

    /**
     * 项目名称
     */
    private String ptpName;

    /**
     * 消费金额
     */
    private Long comsunePrice;

    /**
     * 消费时间
     */
    private Date comsuneDate;
}
