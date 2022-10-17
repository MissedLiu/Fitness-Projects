package com.trkj.vo.queryTqw;

import com.trkj.vo.query.PageVo2;
import lombok.Data;

/**
 * @title: 会员查询条件Vo
 * @author 15087
 * @date: 2022/10/14 13:55
*/
@Data
public class MemberSelectQueryVo extends PageVo2 {
    //会员id
    private Long memberId;
    //会员姓名
    private String memberName;
    //会员电话
    private String memberPhone;
}
