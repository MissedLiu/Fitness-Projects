package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.liucz2.InterviewMapper;
import com.trkj.entity.liucz2.Interview;

import com.trkj.service.implLiucz2.InterviewService;
import com.trkj.vo.query.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview>
    implements InterviewService {
    @Resource
    private InterviewMapper interviewMapper;
    /**
     * @description:
     * 分页并且动态查询
     * @author: Liucz
     * @date: 2022/10/9 8:55
     * @param:
     * @return:
     **/
    @Override
    public IPage<Interview> findAllByEmpId(PageVo pageVo) {
        Page<Interview> page=new Page<>(pageVo.getPageNo(),pageVo.getPageSize());
        IPage<Interview> allByEmpIdInterviewIPage = interviewMapper.findAllByEmpIdInterviewIPage(page, pageVo);
        return allByEmpIdInterviewIPage;
    }
}




