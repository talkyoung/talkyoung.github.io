package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Course  implements Serializable {
    private Integer couId;

    private String teaId;

    private String couName;

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId == null ? null : teaId.trim();
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName == null ? null : couName.trim();
    }
}