package com.trkj.dao.liucz2;

import com.trkj.entity.liucz2.CaigouShenhe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.trkj.entity.liucz2.CaigouShenhe
 */
public interface CaigouShenheMapper extends BaseMapper<CaigouShenhe> {
    /**
     * @description:
     * 添加审核信息
     * @author: Liucz
     * @date: 2022/10/5 14:31
     * @param:
     * @return:
     **/
    int addCaigouSh( Long scheduleId, List<Long> shenheempId);
    //修改状态为同意
    int UpdateState(CaigouShenhe caigouShenhe);
    //修改状态为拒绝
    int UpdateRefuseState(CaigouShenhe caigouShenhe);
    //修改状态为5删除
    int delete5(CaigouShenhe caigouShenhe);
}




