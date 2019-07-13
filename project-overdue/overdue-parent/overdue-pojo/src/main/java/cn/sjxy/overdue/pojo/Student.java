package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stuId;

    private String stuName;

    private String stuPassword;

    private String stuCourseId;

    private String stuTeacherId;

    private Integer stuStatus;

    private String stuPhone;

    private String stuProfessionId;

    private String stuDepartmentId;

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

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword == null ? null : stuPassword.trim();
    }

    public String getStuCourseId() {
        return stuCourseId;
    }

    public void setStuCourseId(String stuCourseId) {
        this.stuCourseId = stuCourseId == null ? null : stuCourseId.trim();
    }

    public String getStuTeacherId() {
        return stuTeacherId;
    }

    public void setStuTeacherId(String stuTeacherId) {
        this.stuTeacherId = stuTeacherId == null ? null : stuTeacherId.trim();
    }

    public Integer getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(Integer stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuProfessionId() {
        return stuProfessionId;
    }

    public void setStuProfessionId(String stuProfessionId) {
        this.stuProfessionId = stuProfessionId == null ? null : stuProfessionId.trim();
    }

    public String getStuDepartmentId() {
        return stuDepartmentId;
    }

    public void setStuDepartmentId(String stuDepartmentId) {
        this.stuDepartmentId = stuDepartmentId == null ? null : stuDepartmentId.trim();
    }

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuPassword=" + stuPassword + ", stuCourseId="
                + stuCourseId + ", stuTeacherId=" + stuTeacherId + ", stuStatus=" + stuStatus + ", stuPhone=" + stuPhone
                + ", stuProfessionId=" + stuProfessionId + ", stuDepartmentId=" + stuDepartmentId + "]";
    }
}