package com.trkj.vo.queryTqw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.vo.query.PageVo;
import com.trkj.vo.query.PageVo2;
import lombok.Data;

import java.util.Date;

@Data
public class ProspectAndCallbackQueryVo extends PageVo2 {
    /**
     *
     */
    private Long prospectId;

    /**
     *
     */
    private String prospectName;

    /**
     *
     */
    private String prospectPhone;

    /**
     *
     */
    private String prospectAddress;

    /**
     *
     */
    private String prospectSex;

    /**
     *
     */
    private Integer prospectAge;

    /**
     * （普通意向客户，重点意向客户，无意向）
     */
    private String type;

    /**
     * 是否分配(0-无分配
     ,1-已分配)
     */
    private Byte prospectIs;
    /**
     * 内容
     */
    private String callbackContent;

    /**
     * 时间
     */
    private Date columnTime;
    /*
     *
     *员工id
     *
     */
    private Long empId;
}
