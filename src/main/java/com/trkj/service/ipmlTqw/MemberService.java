package com.trkj.service.ipmlTqw;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.entity.tqw.Member;
import com.trkj.vo.queryTqw.MemberQueryVo;
import com.trkj.vo.queryTqw.PtMealAndEmpQueryVo;

import java.util.List;

/*
*
*会员类
*
*/
public interface MemberService extends IService<Member> {
/************************所有会员*************************/
    /*
     *
     *通过电话查询会员信息OK
     *
     */
    Member findMemberByMemberPhone(String memberPhone);
    /*
     *
     *新增会员ok
     *
     */
    boolean addMember(Member member);
    /*
    *
    *通过电话删除会员ok
    *
    */
    boolean delMemberByMemberId(long memberId);
    /*
    *
    *根据电话修改会员
    *
    */
    boolean updataMemberByMemberPhone(Member member);


  /************************普通会员*********************************/
    /*
    *
    *通过套餐类型查询普通会员套餐
    *
    */
    List<MemberQueryVo> findCommentMember(String membertype);


    /*
     *
     *通过套餐类型,电话查普通会员套餐
     *
     */
    List<MemberQueryVo> findCommentMemberByPhone(String mealType,String memberPhone);


    /*
    *
    *新增普通会员
    *
    */
    int addCommonMember(MemberQueryVo memberQueryVo);


    /*
    *
    *删除普通会员
    *
    */
    boolean delCommonMemberById(long mmId);


/*******************私教会员***********************8/
     /*
     *
     *通过套餐类型查询私教会员
     *
     */
    List<MemberQueryVo> findPtMember(String memberType);


    /**
     * 通过电话,套餐类型查询私教
     *
     */
    List<MemberQueryVo> findPtMemberByPhone(String mealType,String memberPhone);


    /*
     *
     *新增私教会员
     *
     */
    int addPtMember(MemberQueryVo memberQueryVo);


    /*
     *
     *通过套餐办理编号删除私教会员
     *
     */
    boolean delPtMemberById(long mmId);


    /*
    *
    *根据所选项目表套餐办理编号查询教练，套餐信息
    *
    */
    PtMealAndEmpQueryVo selectPtMealAndEmpByMmId(long mmId);

/*****************团操会员**********************/
    /*
     *
     *通过套餐类型查询团操会员
     *
     */
    List<MemberQueryVo> findTeamMember(String memberType);
    /**
     * 通过电话,套餐类型查询私教
     *
     */
    List<MemberQueryVo> findTeamMemberByPhone(String mealType,String memberPhone);
    /*
     *
     *新增团操会员
     *
     */
    int addTeamMember(MemberQueryVo memberQueryVo);
    /*
     *
     *根据所选项目表套餐办理编号查询教练，套餐信息（团操）
     *
     */
    PtMealAndEmpQueryVo selectTeamMealAndEmpByMmId(long mmId);

}
