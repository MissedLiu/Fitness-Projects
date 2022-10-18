package com.trkj.service.implTqw.tqw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.PtCoachMapper;
import com.trkj.entity.tqw.PtCoach;
import com.trkj.service.implTqw.PtCoachService;
import com.trkj.vo.queryTqw.EmpAndPtMealQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PtCoachServiceImpl extends ServiceImpl<PtCoachMapper, PtCoach>
implements PtCoachService {

    /**
     * @title:  新增私教套餐教练关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:12
    */
    @Override
    @Transactional
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

    /**
     * @title:  通过员工id查询私教关系表数据
     * @param: null
     * @return:
     * @author 15087
     * @date: 2022/10/18 9:12
    */
    @Override
    public List<PtCoach> findPtAndEmpByEmpId(Long empId) {
        QueryWrapper<PtCoach> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empId);
        return baseMapper.selectList(wrapper);
    }
}
