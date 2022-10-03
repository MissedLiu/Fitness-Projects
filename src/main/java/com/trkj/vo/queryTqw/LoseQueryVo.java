package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import lombok.Data;

import java.util.Date;


@Data
public class LoseQueryVo extends PageVo {
    /**
     *
     */
    private Long id;

    /**
     *
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
