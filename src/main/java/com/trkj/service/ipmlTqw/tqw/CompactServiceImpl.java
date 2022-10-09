package com.trkj.service.ipmlTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.CompactMapper;
import com.trkj.dao.tqw.MemberMealMapper;
import com.trkj.entity.tqw.Compact;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberMeal;
import com.trkj.service.ipmlTqw.CompactService;
import com.trkj.vo.queryTqw.CompactAndMemberQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
*
*/
@Service
public class CompactServiceImpl extends ServiceImpl<CompactMapper, Compact>
implements CompactService {
    @Autowired
    private MemberMealMapper memberMealMapper;

    //分页查询
    @Override
    public IPage<CompactAndMemberQueryVo> findCompactList(CompactAndMemberQueryVo compactAndMemberQueryVo) {
        Page<CompactAndMemberQueryVo> page=new Page<>(compactAndMemberQueryVo.getPageNo(),compactAndMemberQueryVo.getPageSize());
        IPage<CompactAndMemberQueryVo> iPage=baseMapper.selectCompactList(page,compactAndMemberQueryVo);
        return iPage;
    }

    //查询会员下办了套餐却没有签订合同的套餐
    @Override
    public List<MemberMeal> findMemberMeal(Member member) {
        //查询该会员办理的套餐
        QueryWrapper<MemberMeal> wrapper=new QueryWrapper<>();
        wrapper.eq("member_id", member.getMemberId());
        wrapper.eq("meal_type","私教").or().eq("meal_type","团操");
        List<MemberMeal> list = memberMealMapper.selectList(wrapper);
        //通过套餐id查询合同表中是否有数据
        List<MemberMeal> list1=new LinkedList<>();
        for (int i=0;i<list.size();i++){
            QueryWrapper<Compact> wrapper1=new QueryWrapper<>();
            wrapper1.eq("mm_id",list.get(i).getMmId());
            //未签订合同
            if(baseMapper.selectOne(wrapper1)==null){
                list1.add(list.get(i));
            }
        }
        return list1;
    }

    //添加合同数据
    @Override
    public boolean addCompact(Compact compact) {
        if(baseMapper.insert(compact)>0){
            return true;
        }
        return false;
    }
    //删除记录
    @Override
    public boolean delDetial(Long compactId) {
        QueryWrapper<Compact> wrapper=new QueryWrapper<>();
        wrapper.eq("compact_id", compactId);
        int i = baseMapper.delete(wrapper);
        if(i>0){
            return true;
        }
        return false;
    }
}
