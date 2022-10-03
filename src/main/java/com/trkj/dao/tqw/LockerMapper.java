package com.trkj.dao.tqw;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.tqw.Locker;
import com.trkj.vo.queryTqw.LockerQueryVo;
import org.apache.ibatis.annotations.Param;

public interface LockerMapper extends BaseMapper<Locker> {
    //查询
    IPage<LockerQueryVo> findlockerList( Page<LockerQueryVo> page, @Param("query") LockerQueryVo lockerQueryVo);
    //新增会员储物柜
    int addMemberLocker(@Param("lq") LockerQueryVo lockerQueryVo);
    //删除会员储物柜
    int deleteLockerByMemberId(@Param("memberId") long memberId,
                               @Param("lockerId") long lockerId);
    //查询储物柜关系表
     LockerQueryVo selectMemberLocker(long lockerId);
}
