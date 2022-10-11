package com.trkj.service.implTqw;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.MemberConsult;
import com.trkj.vo.queryTqw.MemberConsultQueryVo;

/**
*
*/
public interface MemberConsultService extends IService<MemberConsult> {

    //分页查询
    IPage<MemberConsultQueryVo> selectMemberConsultList(MemberConsultQueryVo memberConsultQueryVo);
    //新增咨询记录
    int addMmeberConsult(MemberConsult memberConsult);
    //删除记录
    Boolean deletecounsult(Long consultId);
}
