package cn.sjxy.overdue.pojo.entity;

import java.io.Serializable;

public class TeaAndCou implements Serializable {
    private Integer CourseId;
    private String CourseName;
    private Integer TeacherId;
    private String TeacherName;
    public TeaAndCou() {
        super();
        // TODO Auto-generated constructor stub
    }
    public TeaAndCou(Integer courseId, String courseName, Integer teacherId, String teacherName) {
        super();
        CourseId = courseId;
        CourseName = courseName;
        TeacherId = teacherId;
        TeacherName = teacherName;
    }
    public Integer getCourseId() {
        return CourseId;
    }
    public void setCourseId(Integer courseId) {
        CourseId = courseId;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
    public Integer getTeacherId() {
        return TeacherId;
    }
    public void setTeacherId(Integer teacherId) {
        TeacherId = teacherId;
    }
    public String getTeacherName() {
        return TeacherName;
    }
    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
    @Override
    public String toString() {
        return "TeaAndCou [CourseId=" + CourseId + ", CourseName=" + CourseName + ", TeacherId=" + TeacherId
                + ", TeacherName=" + TeacherName + "]";
    }


}
