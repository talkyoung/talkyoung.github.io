package cn.sjxy.overdue.teacher.service;

import cn.sjxy.overdue.dao.TeacherMapper;
import cn.sjxy.overdue.pojo.Teacher;
import cn.sjxy.overdue.pojo.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTeaIdService {
    @Autowired
    TeacherMapper teacherMapper;

    public Integer getTeaId() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeaNameEqualTo(name);
        return teacherMapper.selectByExample(teacherExample).get(0).getTeaId();
    }

}
