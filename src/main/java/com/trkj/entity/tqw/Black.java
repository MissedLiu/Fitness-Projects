package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blacklist")
public class Black {
    @TableId(value = "cp_id", type = IdType.AUTO)
    private long id;//编号
    @NotNull(message = "会员id为空")
    private long memberId;//会员id
    private Date createTime;//拉黑时间
    @NotNull(message = "拉黑原因不能为空")
    private String why;//原因

}
