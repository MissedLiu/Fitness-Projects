package com.trkj.entity.tqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("locker")
public class Locker {
    //储物柜编号
    @TableId(value = "locker_Id")
    private long lockerId;
    //储物柜状态(0-已使用,1-未使用,3-不可用)
    private int lockerState;
}
