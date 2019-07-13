package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer teaId;

    private String teaName;

    private String teaPassword;

    private String teaCourse;

    private String teaPhone;

    private String assignStudent;

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword == null ? null : teaPassword.trim();
    }

    public String getTeaCourse() {
        return teaCourse;
    }

    public void setTeaCourse(String teaCourse) {
        this.teaCourse = teaCourse == null ? null : teaCourse.trim();
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone == null ? null : teaPhone.trim();
    }

    public String getAssignStudent() {
        return assignStudent;
    }

    public void setAssignStudent(String assignStudent) {
        this.assignStudent = assignStudent == null ? null : assignStudent.trim();
    }
    @Override
    public String toString() {
        return "Teacher [teaId=" + teaId + ", teaName=" + teaName + ", teaPassword=" + teaPassword + ", teaCourse="
                + teaCourse + ", teaPhone=" + teaPhone + ", assignStudent=" + assignStudent + "]";
    }
}