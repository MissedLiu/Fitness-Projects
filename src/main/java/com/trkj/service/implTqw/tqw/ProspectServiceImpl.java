package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.AllotProspectMapper;
import com.trkj.dao.tqw.ProspectMapper;
import com.trkj.entity.tqw.AllotProspect;
import com.trkj.entity.tqw.Prospect;
import com.trkj.service.implTqw.ProspectService;
import com.trkj.vo.queryTqw.ProspectQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
*/
@Service
@Transactional
public class ProspectServiceImpl extends ServiceImpl<ProspectMapper, Prospect>
implements ProspectService {

    @Autowired
    private AllotProspectMapper allotProspectMapper;
    //通过分配状态查询潜在用户
    @Override
    public List<Prospect> findProspectByProspectIs(long pros) {
        QueryWrapper<Prospect> wrapper=new QueryWrapper<>();
        wrapper.eq("prospect_is",pros);
        return baseMapper.selectList(wrapper);
    }

    //分页查询潜在用户
    @Override
    public IPage<ProspectQueryVo> findProspectList(ProspectQueryVo prospectQueryVo) {
        Page<ProspectQueryVo> page=new Page<>(prospectQueryVo.getPageNo(),prospectQueryVo.getPageSize());
        IPage<ProspectQueryVo> iPage=baseMapper.selectProspectList(page,prospectQueryVo);
        return iPage;
    }



    //新增潜在用户
    @Override
    public boolean addProspect(Prospect prospect) {

        //查询潜在用户列表是否有数据
        QueryWrapper<Prospect> wrapper=new QueryWrapper<>();
        wrapper.eq("prospect_name",prospect.getProspectName())
                .eq("prospect_Phone",prospect.getProspectPhone());
        Prospect prospect1=baseMapper.selectOne(wrapper);
        if(prospect1!=null){
            //有数据
            //存在潜在用户表中，无意向
            UpdateWrapper<Prospect> wrapper1=new UpdateWrapper<>();
            wrapper1.set("type",prospect.getType()).eq("prospect_id",prospect1.getProspectId());
            baseMapper.update(null,wrapper1);
            return true;
        }else {
            if(baseMapper.insert(prospect)>0){
                return true;
            }
        }
        return false;
    }

    //删除潜在用户
    @Override
    public boolean deleteProspect(Long prospectId) {
        //查询该潜在用户的状态
        if(baseMapper.selectById(prospectId).getType().equals("无意向")){
            //删除潜在用户和客服的分配关系
            QueryWrapper<AllotProspect> wrapper=new QueryWrapper<>();
            wrapper.eq("prospect_id",prospectId);
            //删除潜在用户
            QueryWrapper<Prospect> wrapper2=new QueryWrapper<>();
            wrapper2.eq("prospect_id",prospectId);
            if(baseMapper.delete(wrapper2)>0&&allotProspectMapper.delete(wrapper)>=0){
                return true;
            }
        }
        return false;
    }

    //修改潜在用户
    @Override
    public boolean updProspecr(Prospect prospect) {
        //通过电话查询会员
        QueryWrapper<Prospect> wrapper=new QueryWrapper<>();
        wrapper.eq("prospect_phone",prospect.getProspectPhone());
        Prospect prospect1 =baseMapper.selectOne(wrapper);
        if(prospect1 != null) {
            //电话未修改
            if (prospect1.getProspectId() == prospect.getProspectId()) {
                //电话未被使用
                //修改会员信息
                UpdateWrapper<Prospect> wrapper1 = new UpdateWrapper<>();
                wrapper1.eq("prospect_id", prospect1.getProspectId());
                if (baseMapper.update(prospect, wrapper1) > 0) {
                    return true;
                }
            } else {
                return false;
            }
        }else {
            //电话被修改
            UpdateWrapper<Prospect> wrapper1=new UpdateWrapper<>();
            wrapper1.eq("prospect_id",prospect.getProspectId());
            if(baseMapper.update(prospect,wrapper1)>0){
                return true;
            }
        }
        return false;
    }
    //通过id修改潜在用户状态
    @Override
    public boolean updProspectById(Prospect prospect) {
        UpdateWrapper<Prospect> wrapper=new UpdateWrapper<>();
        wrapper.set("type",prospect.getType()).eq("prospect_id",prospect.getProspectId());
        if(baseMapper.update(null,wrapper)>0){
            return true;
        }
        return false;
    }
}
