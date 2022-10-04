package com.trkj.entity.ouyang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 报损报溢表
 * @TableName changenum
 */
@TableName(value ="changenum")
@Data
public class Changenum implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 物品编号
     */
    private Long shoppingId;

    /**
     * 报损数
     */
    private Long changeLose;

    /**
     * 报溢数
     */
    private Long changeMore;

    /**
     * 创建时间
     */
    private Date createTime;

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
        Changenum other = (Changenum) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShoppingId() == null ? other.getShoppingId() == null : this.getShoppingId().equals(other.getShoppingId()))
            && (this.getChangeLose() == null ? other.getChangeLose() == null : this.getChangeLose().equals(other.getChangeLose()))
            && (this.getChangeMore() == null ? other.getChangeMore() == null : this.getChangeMore().equals(other.getChangeMore()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShoppingId() == null) ? 0 : getShoppingId().hashCode());
        result = prime * result + ((getChangeLose() == null) ? 0 : getChangeLose().hashCode());
        result = prime * result + ((getChangeMore() == null) ? 0 : getChangeMore().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shoppingId=").append(shoppingId);
        sb.append(", changeLose=").append(changeLose);
        sb.append(", changeMore=").append(changeMore);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}