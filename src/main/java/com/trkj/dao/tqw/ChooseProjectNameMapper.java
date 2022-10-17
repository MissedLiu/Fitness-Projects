package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.entity.tqw.ChooseProjectName;
import com.trkj.entity.tqw.MemberMeal;

import java.util.List;

/*
*
*所选项目表
*
*/
public interface ChooseProjectNameMapper extends BaseMapper<ChooseProjectName> {
    //删除所选项目表数据
    int deleteChooseProject(List<MemberMeal> list);
}
