package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.PtCoachMapper;
import com.trkj.entity.tqw.PtCoach;
import com.trkj.service.implTqw.PtCoachService;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class PtCoachServiceImpl extends ServiceImpl<PtCoachMapper, PtCoach>
implements PtCoachService {

    //新增私教套餐教练关系表数据
    @Override
    public boolean addEmpAndPtMeal(EmpAndPtMealQueryVo empAndPtMealQueryVo) {
        //删除原来的
        QueryWrapper<PtCoach> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empAndPtMealQueryVo.getEmpId());
        baseMapper.delete(wrapper);
        //添加新的
        if(baseMapper.insertPtCoachs(empAndPtMealQueryVo.getEmpId(),empAndPtMealQueryVo.getPtMealId())>0){
            return true;
        }
        return false;
    }

    //通过员工id查询私教关系表数据
    @Override
    public List<PtCoach> findPtAndEmpByEmpId(Long empId) {
        QueryWrapper<PtCoach> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empId);
        return baseMapper.selectList(wrapper);
    }
}
