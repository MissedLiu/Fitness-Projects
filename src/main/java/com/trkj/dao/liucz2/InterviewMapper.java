package com.trkj.dao.liucz2;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.liucz2.Interview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.vo.query.PageVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.trkj.entity.liucz2.Interview
 */
public interface InterviewMapper extends BaseMapper<Interview> {
    /**
     * @description:
     * 根据教练编号查询所有并且分页
     * @author: Liucz
     * @date: 2022/10/9 8:44
     * @param:
     * @return:
     **/
    IPage<Interview> findAllByEmpIdInterviewIPage(Page<Interview> page , @Param("query")PageVo pageVo);
 }




