package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName allot_member
 */
@TableName(value ="allot_member")
@Data
public class AllotMember implements Serializable {
    /**
     * 分配编号
     */
    @TableId(type = IdType.AUTO)
    private Long allotId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 客服编号
     */
    private Long empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}