package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.vo.queryTqw.MemberQueryVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CommonMemberService {
    /*
     *
     *通过套餐类型查询普通会员套餐
     *
     */
    IPage<MemberQueryVo> findCommentMember(MemberQueryVo memberQueryVo);

    /*
     *
     *新增普通会员
     *
     */
    int addCommonMember(MemberQueryVo memberQueryVo);


    /*
     *
     *删除普通会员套餐
     *
     */
    boolean delCommonMemberById(long mmId);

    /*
    *
    *续费
    *
    */
    int renewCommonMember(MemberQueryVo memberQueryVo);
}
