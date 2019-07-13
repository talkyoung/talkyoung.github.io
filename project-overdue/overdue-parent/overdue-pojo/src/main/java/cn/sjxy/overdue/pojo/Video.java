package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private Integer vId;

    private String vName;

    private Integer tId;

    private String vDetail;

    private Integer cId;

    private Date vUptime;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getvDetail() {
        return vDetail;
    }

    public void setvDetail(String vDetail) {
        this.vDetail = vDetail == null ? null : vDetail.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Date getvUptime() {
        return vUptime;
    }

    public void setvUptime(Date vUptime) {
        this.vUptime = vUptime;
    }
    @Override
    public String toString() {
        return "Video [vId=" + vId + ", vName=" + vName + ", tId=" + tId + ", vDetail=" + vDetail + ", cId=" + cId
                + ", vUptime=" + vUptime + "]";
    }
}