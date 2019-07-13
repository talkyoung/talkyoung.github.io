package cn.sjxy.overdue.teacher.service;

import cn.sjxy.overdue.dao.FileMapper;
import cn.sjxy.overdue.pojo.Teacher;
import cn.sjxy.overdue.teacher.log.TeacherLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDetailServiceImpl implements UserDetailsService {
    @Autowired
    TeacherService teacherServiceImpl;

    @Autowired
    FileMapper fileMapper;
    public void setTeacherServiceImpl(TeacherService teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @Override
    @TeacherLog(module = "loadUserByUsername",action ="教师登陆" )
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String name = null;
        try {
            name = new String(username.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
        List<Teacher> teacherList = teacherServiceImpl.findByName(name);
        Teacher teacher = null;
        if (teacherList.size() != 0) {
           teacher = teacherList.get(0);
        }

        if (teacher != null) {
            return new User(name, teacher.getTeaPassword(), grantedAuths);
        } else {
            return null;
        }
    }
}
