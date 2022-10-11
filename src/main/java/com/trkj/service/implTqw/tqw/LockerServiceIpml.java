package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.LockerMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.entity.tqw.Locker;
import com.trkj.entity.tqw.Member;
import com.trkj.service.implTqw.LockerService;
import com.trkj.vo.queryTqw.LockerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class LockerServiceIpml extends ServiceImpl<LockerMapper, Locker> implements LockerService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public IPage<LockerQueryVo> findLockerList(LockerQueryVo lockerQueryVo) {
        Page<LockerQueryVo> Page=new Page<>(lockerQueryVo.getPageNo(),lockerQueryVo.getPageSize());
        IPage<LockerQueryVo> iPage=baseMapper.findlockerList(Page,lockerQueryVo);
        return iPage;
    }

    //新增储物柜
    @Override
    public int addLocker(long lockerId){
        //判断储物柜是否存在
        QueryWrapper<Locker> wrapper=new QueryWrapper<>();
        wrapper.eq("locker_id",lockerId);
        Locker locker = baseMapper.selectOne(wrapper);
        if(locker == null){
            Locker locker1=new Locker();
            locker1.setLockerId(lockerId);
            locker1.setLockerState(1);
            baseMapper.insert(locker1);
            return 0;
        }
        return 1;
    }

    //添加会员储物柜
    @Override
    public int addLockerByMemberId(LockerQueryVo lockerQueryVo){
        //判断参数是否齐全
        if(lockerQueryVo.getMemberPhone()==null || lockerQueryVo.getMemberName() == null
        || lockerQueryVo.getLockerId() == 0){
            return 5;
        }
        //判断该储物柜是否有人所有(查询储物柜状态)
        if(baseMapper.selectById(lockerQueryVo.getLockerId()).getLockerState()==0){
            return 6;
        }
        //查询会员情况（是否拉黑，是否存在）
        //通过电话和姓名查询会员
        QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("member_phone", lockerQueryVo.getMemberPhone());
        wrapper1.eq("member_name", lockerQueryVo.getMemberName());
        Member member1 = memberMapper.selectOne(wrapper1);
        //判断是否黑名单
        if(member1 != null){
            if(member1.getMemberState()==1){
                return 0;
            }
        }
        //通过电话查会员
        QueryWrapper<Member> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("member_phone", lockerQueryVo.getMemberPhone());
        Member member2 = memberMapper.selectOne(wrapper2);
        //通过名字查电话
        QueryWrapper<Member> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("member_name", lockerQueryVo.getMemberName());
        List<Member> member3 = memberMapper.selectList(wrapper3);
        if (member1 != null) {
            //会员存在
            //添加储物柜
            //当前时间基础上加7天
            Date date=new Date();
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DATE ,7);
            lockerQueryVo.setMemberId(member1.getMemberId());
            lockerQueryVo.setCreateTime(date);
            lockerQueryVo.setEndTime(rightNow.getTime());
            baseMapper.addMemberLocker(lockerQueryVo);
            //修改储物柜状态
            UpdateWrapper<Locker> wrapper=new UpdateWrapper<>();
            wrapper.set("locker_state",0);
            wrapper.eq("locker_id",lockerQueryVo.getLockerId());
            baseMapper.update(null,wrapper);
            return 1;
        }
        if (member2 == null && member3.size() == 0) {
            //会员不存在
            return 2;
        }else if(member2 != null && member3.size() !=0){
            //会员不存在
            return 2;
        }else if(member2 == null) {
            //电话不存在
            return 3;
        }else if (member3.size() == 0) {
            //姓名不存在
            return 4;
        }
        return 5;

    }

    //删除会员储物柜
    @Override
    public boolean deleteLockerByMemberId(long memberId, long lockerId){
        //删除关系表记录
        if (baseMapper.deleteLockerByMemberId(memberId, lockerId)>0){
            //修改储物柜状态
            UpdateWrapper<Locker> wrapper=new UpdateWrapper<>();
            wrapper.set("locker_state",1);
            wrapper.eq("locker_id",lockerId);
            baseMapper.update(null,wrapper);
            return true;
        }
        return false;
    }

    //删除储物柜
    @Override
    public int deleteLocker(long lockerId){
        //查询该储物柜是否拥有会员
        LockerQueryVo lockerQueryVo = baseMapper.selectMemberLocker(lockerId);
        if(lockerQueryVo!=null){
            return 0;
        }else {
            if(baseMapper.deleteById(lockerId)>0){
                return 1;
            }
        }
        return 2;
    }
    //修改储物柜
    @Override
    public boolean updateLocker(LockerQueryVo lockerQueryVo){
        //判断储物柜状态
        if(lockerQueryVo.getLockerState().equals("1")){
            lockerQueryVo.setLockerState("2");
        }else if(lockerQueryVo.getLockerState().equals("2")){
            lockerQueryVo.setLockerState("1");
        }else if(lockerQueryVo.getLockerState().equals("0")){
            return false;
        }
           //修改状态
           UpdateWrapper<Locker> wrapper=new UpdateWrapper<>();
           wrapper.set("locker_state",lockerQueryVo.getLockerState());
           wrapper.eq("locker_id",lockerQueryVo.getLockerId());
           if(baseMapper.update(null,wrapper)>0){
               return true;
           }
        return false;
    }

}
