package com.trkj.service.ipmlTqw.tqw;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.MemberConsultMapper;
import com.trkj.dao.tqw.MemberMapper;
import com.trkj.dao.tqw.ProspectMapper;
import com.trkj.entity.tqw.Member;
import com.trkj.entity.tqw.MemberConsult;
import com.trkj.entity.tqw.Prospect;
import com.trkj.service.ipmlTqw.MemberConsultService;
import com.trkj.vo.queryTqw.MemberConsultQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
*
*/
@Service
@Transactional
public class MemberConsultServiceImpl extends ServiceImpl<MemberConsultMapper, MemberConsult>
implements MemberConsultService {
    @Autowired
    private ProspectMapper prospectMapper;
    @Autowired
    private MemberMapper memberMapper;

    //分页查询列表
    @Override
    public IPage<MemberConsultQueryVo> selectMemberConsultList(MemberConsultQueryVo memberConsultQueryVo) {
        Page<MemberConsultQueryVo> page=new Page<MemberConsultQueryVo>(memberConsultQueryVo.getPageNo(),memberConsultQueryVo.getPageSize());
        IPage<MemberConsultQueryVo> iPage=baseMapper.selectMemberConsultList(page,memberConsultQueryVo);
        return iPage;
    }

    //新增咨询记录
    @Override
    public int addMmeberConsult( MemberConsult memberConsult) {
        //新增咨询记录
        memberConsult.setConsultTime(new Date());
        baseMapper.insert(memberConsult);
        //判断是否是会员
        QueryWrapper<Member> wrapper1=new QueryWrapper<>();
        wrapper1.eq("member_phone",memberConsult.getConsultPhone());
        if(memberMapper.selectOne(wrapper1)!=null){
            return 2;
        }
        //根据电话查询潜在用户表是否有记录
        QueryWrapper<Prospect> wrapper=new QueryWrapper<>();
        wrapper.eq("prospect_phone",memberConsult.getConsultPhone());
        if(prospectMapper.selectOne(wrapper)!=null){
            return 0;
        }else {
            //新增潜在用户
            Prospect prospect=new Prospect();
            prospect.setProspectName(memberConsult.getConsultName());
            prospect.setProspectSex(String.valueOf(memberConsult.getConsultSex()==0 ? '女':'男'));
            prospect.setProspectPhone(memberConsult.getConsultPhone());
            prospect.setProspectAge(memberConsult.getConsultAge());
            prospect.setType("普通意向");
            prospect.setProspectAddress("未知");
            prospect.setProspectIs((byte) 0);
            prospectMapper.insert(prospect);
            return 1;
        }
    }
}
