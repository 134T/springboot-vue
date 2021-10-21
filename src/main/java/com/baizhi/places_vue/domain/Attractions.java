package com.baizhi.places_vue.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName attractions
 */
@TableName(value ="attractions")
@Data
public class Attractions implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "picpath")
    private String picpath;

    /**
     * 
     */
    @TableField(value = "hottime")
    @JsonFormat(pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date hottime;

    /**
     * 
     */
    @TableField(value = "hotticket")
    private Double hotticket;

    /**
     * 
     */
    @TableField(value = "dimticket")
    private Double dimticket;

    /**
     * 
     */
    @TableField(value = "placedes")
    private String placedes;

    /**
     * 
     */
    @TableField(value = "proviceid")
    private Integer proviceid;

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
        Attractions other = (Attractions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPicpath() == null ? other.getPicpath() == null : this.getPicpath().equals(other.getPicpath()))
            && (this.getHottime() == null ? other.getHottime() == null : this.getHottime().equals(other.getHottime()))
            && (this.getHotticket() == null ? other.getHotticket() == null : this.getHotticket().equals(other.getHotticket()))
            && (this.getDimticket() == null ? other.getDimticket() == null : this.getDimticket().equals(other.getDimticket()))
            && (this.getPlacedes() == null ? other.getPlacedes() == null : this.getPlacedes().equals(other.getPlacedes()))
            && (this.getProviceid() == null ? other.getProviceid() == null : this.getProviceid().equals(other.getProviceid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPicpath() == null) ? 0 : getPicpath().hashCode());
        result = prime * result + ((getHottime() == null) ? 0 : getHottime().hashCode());
        result = prime * result + ((getHotticket() == null) ? 0 : getHotticket().hashCode());
        result = prime * result + ((getDimticket() == null) ? 0 : getDimticket().hashCode());
        result = prime * result + ((getPlacedes() == null) ? 0 : getPlacedes().hashCode());
        result = prime * result + ((getProviceid() == null) ? 0 : getProviceid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", picpath=").append(picpath);
        sb.append(", hottime=").append(hottime);
        sb.append(", hotticket=").append(hotticket);
        sb.append(", dimticket=").append(dimticket);
        sb.append(", placedes=").append(placedes);
        sb.append(", proviceid=").append(proviceid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}