package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 潜在用户记录表
 * @TableName prospect
 */
@TableName(value ="prospect")
@Data
public class Prospect implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long prospectId;

    /**
     * 
     */
    private String prospectName;

    /**
     * 
     */
    private String prospectPhone;

    /**
     * 
     */
    private String prospectAddress;

    /**
     * 
     */
    private String prospectSex;

    /**
     * 
     */
    private Integer prospectAge;

    /**
     * （普通意向客户，重点意向客户，无意向）
     */
    private String type;

    /**
     * 是否分配(0-无分配
            ,1-已分配)
     */
    private Byte prospectIs;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}