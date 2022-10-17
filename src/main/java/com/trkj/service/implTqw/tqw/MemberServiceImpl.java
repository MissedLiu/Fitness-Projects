package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ChooseProjectNameMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.*;
import com.trkj.service.implTqw.MemberService;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.MemberSelectQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Resource
    private MemberMealMapper memberMealMapper;
    @Resource
    private ChooseProjectNameMapper chooseProjectNameMapper;

    /*
     *
     *查询会员信息无分页
     *
     */
    @Override
    public List<Member> listAllNoPage(Member member) {
        return baseMapper.listAllNoPage(member);
    }


    /**
     * @title:  查询会员信息列表（分页）
     * @param: MemberSelectQueryVo
     * @return: Ipage<Member>
     * @author 15087
     * @date: 2022/10/14 14:02
    */
    public IPage<Member> findAllMember(MemberSelectQueryVo memberSelectQueryVo){
        Page<Member> page=new Page<>(memberSelectQueryVo.getPageNo(),memberSelectQueryVo.getPageSize());
        IPage<Member> memberAll = baseMapper.findMemberList(page, memberSelectQueryVo);
        return memberAll;
    }


    /*
     *
     *查询会员状态为0的信息
     *
     */
    public List<Member> findMemberByState(long memberstate){
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_state",memberstate);
        return baseMapper.selectList(wrapper);
    }

    /**
     * @title:  新增会员
     * @param: member
     * @return:  boolean
     * @author 15087
     * @date: 2022/10/14 16:04
    */
    @Override
    @Transactional
    public boolean addMember(Member member) {
        //通过电话查询会员是否存在
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",member.getMemberPhone());
        if(baseMapper.selectOne(wrapper) == null){
            member.setMemberState(0);
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());
            baseMapper.insert(member);
            return true;
        }
        return false;
    }

    /**
     * @title:  通过会员id删除会员
     * @param: memberId
     * @return:  boolean
     * @author 15087
     * @date: 2022/10/14 16:49
    */
    @Override
    @Transactional
    public boolean removeMember(long memberId){
        //构建删除会员条件
        QueryWrapper<Member> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId);
        //构建查询套餐条件
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id",memberId);
        //根据会员编号查询会员办理套餐表信息
        List<MemberMeal> list=memberMealMapper.selectList(wrapper);
        //删除会员套餐数据
        int memberMeal = memberMealMapper.delete(wrapper);
        //删除会员所选项目数据
        int chooseProject = chooseProjectNameMapper.deleteChooseProject(list);
        //删除会员
        int member = baseMapper.delete(wrapper1);
        if(memberMeal>=0&&chooseProject>=0&&member>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  修改会员
     * @param: Member
     * @return:  int
     * @author 15087
     * @date: 2022/10/14 16:55
    */
    @Override
    @Transactional
    public int updataMemberByMemberPhone(Member member) {
        //构造会员查询条件
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",member.getMemberPhone());
        //通过电话查询会员
        Member member1 =baseMapper.selectOne(wrapper);
        //判断是否查询到会员
        if(member1!=null){
            //查到该会员
            //判断是否由正式会员改为体验会员
            if(member1.getMemberType()==1 && member.getMemberType()==0){
                return 0;
            }
            //判断该电话所属会员是不是此会员
            if(member1.getMemberId() == member.getMemberId()){
                //会员id相同，电话为修改
                //修改会员信息
                UpdateWrapper<Member> wrapper1=new UpdateWrapper<>();
                wrapper1.eq("member_id",member.getMemberId());
                if(baseMapper.update(member,wrapper1)>0){
                    return 1;
                }
            }else {
                //会员id不同，电话已修改
                return 2;
            }
        }else {
            //未查到该会员（电话已修改且与其他会员不相同）
            UpdateWrapper<Member> wrapper1=new UpdateWrapper<>();
            wrapper1.eq("member_id",member.getMemberId());
            if(baseMapper.update(member,wrapper1)>0){
                return 1;
            }
        }
        return 3;
    }

    /**
     * @title:  通过会员id查询所有套餐
     * @param: Long
     * @return:  List<MemberQueryVo>
     * @author 15087
     * @date: 2022/10/14 20:12
     */
    @Override
    public List<MemberQueryVo> findMemberMealByMemberId(Long memberId) {
        //查询三种套餐信息
        List<MemberQueryVo> list4 = new ArrayList<>();
        list4.addAll(baseMapper.selectCommon(memberId));
        list4.addAll(baseMapper.selectPt(memberId));
        list4.addAll(baseMapper.selectTeam(memberId));
        return list4;
    }

}
