package cn.sjxy.overdue.service;

import cn.sjxy.overdue.pojo.Secretary;
import cn.sjxy.overdue.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailServiceImpl implements UserDetailsService {
    @Autowired
    StudentService studentServiceImpl;

    public void setStudentServiceImpl(StudentService studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        List<Student> studentList = studentServiceImpl.findOneByName(username);
        Student student= studentList.get(0);

        System.out.println(student);
        if (student != null) {
            System.out.println("student not null");
            return new User(username, student.getStuPassword(), grantedAuths);
        } else {
            return null;
        }
    }
}
