package com.trkj.dao.liucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.queryLiucz.UserQueryVo;
import org.apache.ibatis.annotations.Param;

public interface UserAndEmpMapper {
    //按条件查询并且分页
    IPage<UserQueryVo> selectXmlPage2(IPage<UserQueryVo> page, @Param("query") UserQueryVo query);


}
