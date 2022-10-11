package com.trkj.service.implTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Locker;
import com.trkj.vo.queryTqw.LockerQueryVo;

public interface LockerService extends IService<Locker> {
    //查询方法（包含分页）
    IPage<LockerQueryVo> findLockerList(LockerQueryVo lockerQueryVo);
    //新增储物柜
    int addLocker(long lockerId);
    //添加会员储物柜
    int addLockerByMemberId(LockerQueryVo lockerQueryVo);
    //删除会员储物柜
    boolean deleteLockerByMemberId(long memberId,long lockerId);
    //删除储物柜
    int deleteLocker(long lockerId);
    //修改储物柜
    boolean updateLocker(LockerQueryVo lockerQueryVo);
}
