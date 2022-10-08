package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import java.util.Date;


@Data
public class LoseQueryVo extends PageVo2 {
    /**
     *id
     */
    private Long id;

    /**
     *物品名称
     */
    private String itemName;

    /**
     * 时间
     */
    private Date createTtime;

    /**
     * 状态(是否招领)
     */
    private String state;

    /**
     *
     */
    private String uname;

    /**
     *
     */
    private String phone;

    /**
     * 领取时间
     */
    private Date addTime;
}
