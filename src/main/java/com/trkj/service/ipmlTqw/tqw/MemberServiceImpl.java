package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ChooseprojectnameMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.*;
import com.trkj.service.ipmlTqw.MemberService;
import com.trkj.vo.queryLiucz.TeamMemerberNumVo;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Resource
    private MemberMealMapper memberMealMapper;
    @Resource
    private ChooseprojectnameMapper chooseprojectnameMapper;

    /*
     *
     *查询会员信息无分页
     *
     */
    @Override
    public List<Member> listAllNoPage(Member member) {
        return baseMapper.listAllNoPage(member);
    }

    /*
     *
     *查询会员信息
     *
     */
    public IPage<Member> findAllMemberByState(MemberQueryVo memberQueryVo ){
        Page<Member> page=new Page<>(memberQueryVo.getPageNo(),memberQueryVo.getPageSize());
        IPage<Member> memberAll = baseMapper.findMemberAll(page, memberQueryVo);
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

    /*
    *
    *新增会员ok
    *
    */
    @Override
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

    //通过会员id删除会员ok
    @Override
    public boolean delMemberByMemberId(long memberId){
        QueryWrapper<Member> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_id",memberId);
        //根据会员编号查询会员办理套餐表信息《list》
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id",memberId);
        List<MemberMeal> list=memberMealMapper.selectList(wrapper);
        if(list.size()==0){
            //会员办理套餐无信息
            int a=baseMapper.delete(wrapper1);
            if(a>0){
                return true;
            }
        }else {
            //套餐是否为普通套餐
            for(int i=0;i<list.size();i++){
                if(list.get(i).getMealType().equals("普通")){
                    //删套餐
                    QueryWrapper<MemberMeal> wrapper2=new QueryWrapper<>();
                    wrapper2.eq("mm_id",list.get(i).getMmId());
                    memberMealMapper.delete(wrapper2);
                }else {
                    //删项目
                    QueryWrapper<ChooseProject> wrapper3=new QueryWrapper<>();
                    wrapper3.eq("mm_id",list.get(i).getMmId());
                    chooseprojectnameMapper.delete(wrapper3);
                    //删套餐
                    QueryWrapper<MemberMeal> wrapper2=new QueryWrapper<>();
                    wrapper2.eq("mm_id",list.get(i).getMmId());
                    memberMealMapper.delete(wrapper2);
                }
            }
            int a=baseMapper.delete(wrapper1);
            if(a>0){
                return true;
            }
        }
        System.out.println(list);
        return false;
    }


    /*
     *
     *根据电话修改会员
     *
     */
    @Override
    public int updataMemberByMemberPhone(Member member) {
        //通过电话查询会员
        QueryWrapper<Member> wrapper=new QueryWrapper<>();
        wrapper.eq("member_phone",member.getMemberPhone());
        Member member1 =baseMapper.selectOne(wrapper);
        //判断电话是否被修改
        if(member1!=null){
            //电话未修改
            //判断是否由正式会员改为体验会员
            if(member1.getMemberType()==1 && member.getMemberType()==0){
                return 0;
            }
            //判断该修改后的电话所属会员是不是此会员
            if(member1.getMemberId() == member.getMemberId()){
                //修改会员信息
                UpdateWrapper<Member> wrapper1=new UpdateWrapper<>();
                wrapper1.eq("member_id",member.getMemberId());
                if(baseMapper.update(member,wrapper1)>0){
                    return 1;
                }
            }else {
                return 2;
            }
        }else {
            //电话被修改
            UpdateWrapper<Member> wrapper1=new UpdateWrapper<>();
            wrapper1.eq("member_id",member.getMemberId());
            if(baseMapper.update(member,wrapper1)>0){
                return 1;
            }
        }
        return 3;
    }



}
