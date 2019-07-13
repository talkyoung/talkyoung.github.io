package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    private Integer fId;

    private String fName;

    private String fRealname;

    private Date fUptime;

    private Integer tId;

    private Integer cId;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfRealname() {
        return fRealname;
    }

    public void setfRealname(String fRealname) {
        this.fRealname = fRealname == null ? null : fRealname.trim();
    }

    public Date getfUptime() {
        return fUptime;
    }

    public void setfUptime(Date fUptime) {
        this.fUptime = fUptime;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
    @Override
    public String toString() {
        return "File [fId=" + fId + ", fName=" + fName + ", fRealname=" + fRealname + ", fUptime=" + fUptime + ", tId="
                + tId + ", cId=" + cId + "]";
    }
}