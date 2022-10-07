package com.trkj.service.ipmlTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.MemberConsult;
import com.trkj.utils.Result;
import com.trkj.vo.queryTqw.MemberConsultQueryVo;

/**
*
*/
public interface MemberConsultService extends IService<MemberConsult> {

    //分页查询
    IPage<MemberConsultQueryVo> selectMemberConsultList(MemberConsultQueryVo memberConsultQueryVo);
    //新增咨询记录
    int addMmeberConsult(MemberConsult memberConsult);
}
