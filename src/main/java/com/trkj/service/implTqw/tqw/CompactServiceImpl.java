package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.CompactMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.service.implTqw.CompactService;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import com.trkj.vo.queryTqw.CompactQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
*
*/
@Service
public class CompactServiceImpl extends ServiceImpl<CompactMapper, Compact>
implements CompactService {
    @Resource
    private MemberMealMapper memberMealMapper;

    /**
     * @title:  分页查询
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:53
    */
    @Override
    public IPage<Member> findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo) {
        Page<Member> page=new Page<>(compactAndMemberQueryVo.getPageNo(),compactAndMemberQueryVo.getPageSize());
        IPage<Member> iPage=baseMapper.selectCompactList(page,compactAndMemberQueryVo);
        return iPage;
    }

    /**
     * @title:  查询会员下办了套餐却没有签订合同的套餐
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:53
    */
    @Override
    public List<CompactQueryVo> findMemberMeal(Member member) {
        //查询该会员办理的(私教,未到期)套餐
        List<CompactQueryVo> list1 = memberMealMapper.selectMemberPtMeal(member.getMemberId());
        //查询该会员办理的(团操,未到期)套餐
        List<CompactQueryVo> list2 = memberMealMapper.selectMemberTeamMeal(member.getMemberId());
        List<CompactQueryVo> list=new LinkedList<>();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    /**
     * @title:  添加合同数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:54
    */
    @Override
    @Transactional
    public boolean addCompact(Compact compact) {
        if(baseMapper.insert(compact)>0){
            return true;
        }
        return false;
    }
    /**
     * @title:  删除记录
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/17 19:54
    */
    @Override
    @Transactional
    public boolean delDetial(Long compactId) {
        QueryWrapper<Compact> wrapper=new QueryWrapper<>();
        wrapper.eq("compact_id", compactId);
        int i = baseMapper.delete(wrapper);
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * @title:  根据会员id查询已签订的合同
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/19 8:28
    */
    @Override
    public List<CompactQueryVo> findCompact(Long memberId) {
        List<CompactQueryVo> list1 = baseMapper.findPtCompact(memberId);
        List<CompactQueryVo> list2 = baseMapper.findTeamCompact(memberId);
        List<CompactQueryVo> list=new LinkedList<>();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
}
