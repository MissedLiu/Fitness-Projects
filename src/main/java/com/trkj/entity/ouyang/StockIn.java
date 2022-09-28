package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物品入库表
 * @TableName stock_in
 */
@TableName(value ="stock_in")
@Data
public class StockIn implements Serializable {
    /**
     * 入库编号
     */
    @TableId
    private Long inId;

    /**
     * 物品编号
     */
    private Long poId;

    /**
     * 物品名称
     */
    private String inName;

    /**
     * 物品数量
     */
    private Long inNum;

    /**
     * 入库时间
     */
    private Date inTime;

    /**
     * 物品类型
     */
    private String inType;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 是否入库(0-否,1-是)
     */
    private Integer inIs;

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
        StockIn other = (StockIn) that;
        return (this.getInId() == null ? other.getInId() == null : this.getInId().equals(other.getInId()))
            && (this.getPoId() == null ? other.getPoId() == null : this.getPoId().equals(other.getPoId()))
            && (this.getInName() == null ? other.getInName() == null : this.getInName().equals(other.getInName()))
            && (this.getInNum() == null ? other.getInNum() == null : this.getInNum().equals(other.getInNum()))
            && (this.getInTime() == null ? other.getInTime() == null : this.getInTime().equals(other.getInTime()))
            && (this.getInType() == null ? other.getInType() == null : this.getInType().equals(other.getInType()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getInIs() == null ? other.getInIs() == null : this.getInIs().equals(other.getInIs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInId() == null) ? 0 : getInId().hashCode());
        result = prime * result + ((getPoId() == null) ? 0 : getPoId().hashCode());
        result = prime * result + ((getInName() == null) ? 0 : getInName().hashCode());
        result = prime * result + ((getInNum() == null) ? 0 : getInNum().hashCode());
        result = prime * result + ((getInTime() == null) ? 0 : getInTime().hashCode());
        result = prime * result + ((getInType() == null) ? 0 : getInType().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getInIs() == null) ? 0 : getInIs().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inId=").append(inId);
        sb.append(", poId=").append(poId);
        sb.append(", inName=").append(inName);
        sb.append(", inNum=").append(inNum);
        sb.append(", inTime=").append(inTime);
        sb.append(", inType=").append(inType);
        sb.append(", brand=").append(brand);
        sb.append(", inIs=").append(inIs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}