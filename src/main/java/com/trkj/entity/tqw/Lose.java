package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 失物招领表
 * @TableName lose
 */
@TableName(value ="lose")
@Data
public class Lose implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
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