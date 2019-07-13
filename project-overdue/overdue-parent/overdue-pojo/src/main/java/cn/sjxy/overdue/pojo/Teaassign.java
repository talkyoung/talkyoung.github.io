package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Teaassign implements Serializable {
    private Integer assId;

    private Integer stuId;

    private Integer couId;

    private Integer teaId;

    public Integer getAssId() {
        return assId;
    }

    public void setAssId(Integer assId) {
        this.assId = assId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }
}