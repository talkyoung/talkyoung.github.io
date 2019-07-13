package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.Date;

public class Studyprocess implements Serializable {
    private Integer stuProId;

    private Integer stuId;

    private String stuName;

    private Date stuLogintime;

    private Date stuLogouttime;

    private String accumStudytime;

    public Integer getStuProId() {
        return stuProId;
    }

    public void setStuProId(Integer stuProId) {
        this.stuProId = stuProId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Date getStuLogintime() {
        return stuLogintime;
    }

    public void setStuLogintime(Date stuLogintime) {
        this.stuLogintime = stuLogintime;
    }

    public Date getStuLogouttime() {
        return stuLogouttime;
    }

    public void setStuLogouttime(Date stuLogouttime) {
        this.stuLogouttime = stuLogouttime;
    }

    public String getAccumStudytime() {
        return accumStudytime;
    }

    public void setAccumStudytime(String accumStudytime) {
        this.accumStudytime = accumStudytime == null ? null : accumStudytime.trim();
    }
}