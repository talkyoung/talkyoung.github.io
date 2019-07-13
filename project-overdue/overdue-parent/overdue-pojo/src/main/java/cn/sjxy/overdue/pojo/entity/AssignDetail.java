package cn.sjxy.overdue.pojo.entity;

import cn.sjxy.overdue.pojo.Student;

import java.io.Serializable;
import java.util.List;

public class AssignDetail implements Serializable {
    private Integer couId;
    private String couName;
    private List<Student> students;
    public AssignDetail() {
        super();
        // TODO Auto-generated constructor stub
    }
    public AssignDetail(Integer couId, String couName, List<Student> students) {
        super();
        this.couId = couId;
        this.couName = couName;
        this.students = students;
    }
    public Integer getCouId() {
        return couId;
    }
    public void setCouId(Integer couId) {
        this.couId = couId;
    }
    public String getCouName() {
        return couName;
    }
    public void setCouName(String couName) {
        this.couName = couName;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "AssignDetail [couId=" + couId + ", couName=" + couName + "students +" + students + "]";
    }

}
