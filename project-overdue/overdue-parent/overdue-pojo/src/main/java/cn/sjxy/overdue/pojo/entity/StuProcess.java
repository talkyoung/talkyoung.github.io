package cn.sjxy.overdue.pojo.entity;

import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.pojo.Studyprocess;

import java.io.Serializable;

public class StuProcess implements Serializable {
    private Studyprocess studyprocess;
    private Student student;
    public StuProcess() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Studyprocess getStudyprocess() {
        return studyprocess;
    }
    public void setStudyprocess(Studyprocess studyprocess) {
        this.studyprocess = studyprocess;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "StuProcess [studyprocess=" + studyprocess + "]";
    }

}
