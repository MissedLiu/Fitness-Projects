package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/*
* 用于接收私教项目与私教套餐的关系
* */
@Data
@TableName("team_choose")
public class TeamProjectChoose {
    @TableId(type = IdType.AUTO)
    private Long id; //主键自增id
    private Long teamId;//团操套餐编号
    private Long tpId;//项目编号
}
