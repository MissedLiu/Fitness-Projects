package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 私教项目类型表
 * @TableName pt_project
 */
@TableName(value ="pt_projectname")
@Data
public class PtProject implements Serializable {
    /**
     * 项目编号
     */
    @TableId(type = IdType.AUTO)
    private Long ptpId;

    /**
     * 项目名称(减脂或塑形.)
     */
    private String ptpName;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Integer ptpIs;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PtProject other = (PtProject) that;
        return (this.getPtpId() == null ? other.getPtpId() == null : this.getPtpId().equals(other.getPtpId()))
            && (this.getPtpName() == null ? other.getPtpName() == null : this.getPtpName().equals(other.getPtpName()))
            && (this.getPtpIs() == null ? other.getPtpIs() == null : this.getPtpIs().equals(other.getPtpIs()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPtpId() == null) ? 0 : getPtpId().hashCode());
        result = prime * result + ((getPtpName() == null) ? 0 : getPtpName().hashCode());
        result = prime * result + ((getPtpIs() == null) ? 0 : getPtpIs().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ptpId=").append(ptpId);
        sb.append(", ptpName=").append(ptpName);
        sb.append(", ptpIs=").append(ptpIs);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}