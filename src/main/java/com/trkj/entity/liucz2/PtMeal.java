package com.trkj.entity.liucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 私教会员套餐表
 * @TableName pt_meal
 */
@TableName(value ="pt_meal")
@Data
public class PtMeal implements Serializable {
    /**
     * 私教套餐编号
     */
    @TableId(type = IdType.AUTO)
    private Long ptId;

    /**
     * 
     */
    private String ptTime;

    /**
     * 套餐生效时间
     */
    private Date ptDate;

    /**
     * 套餐价格
     */
    private Long ptPrice;

    /**
     * 是否禁用(0-禁用,1-使用)
     */
    private Integer ptIs;

    /**
     * 套餐名
     */
    private String ptName;

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
        PtMeal other = (PtMeal) that;
        return (this.getPtId() == null ? other.getPtId() == null : this.getPtId().equals(other.getPtId()))
            && (this.getPtTime() == null ? other.getPtTime() == null : this.getPtTime().equals(other.getPtTime()))
            && (this.getPtDate() == null ? other.getPtDate() == null : this.getPtDate().equals(other.getPtDate()))
            && (this.getPtPrice() == null ? other.getPtPrice() == null : this.getPtPrice().equals(other.getPtPrice()))
            && (this.getPtIs() == null ? other.getPtIs() == null : this.getPtIs().equals(other.getPtIs()))
            && (this.getPtName() == null ? other.getPtName() == null : this.getPtName().equals(other.getPtName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPtId() == null) ? 0 : getPtId().hashCode());
        result = prime * result + ((getPtTime() == null) ? 0 : getPtTime().hashCode());
        result = prime * result + ((getPtDate() == null) ? 0 : getPtDate().hashCode());
        result = prime * result + ((getPtPrice() == null) ? 0 : getPtPrice().hashCode());
        result = prime * result + ((getPtIs() == null) ? 0 : getPtIs().hashCode());
        result = prime * result + ((getPtName() == null) ? 0 : getPtName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ptId=").append(ptId);
        sb.append(", ptTime=").append(ptTime);
        sb.append(", ptDate=").append(ptDate);
        sb.append(", ptPrice=").append(ptPrice);
        sb.append(", ptIs=").append(ptIs);
        sb.append(", ptName=").append(ptName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}