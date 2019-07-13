package cn.sjxy.overdue.student.service;
/**
 * @author talkyoung
 * @version 1.0
 */

import cn.sjxy.overdue.pojo.Secretary;
import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.student.log.StudentLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@Override
	@StudentLog(module = "loadUserByUsername",action = "学生登陆")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String name = null;
		try {
			name = new String(username.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
		List<Student> studentList = studentService.findOneByName(name);
		if (studentList != null) {
            Student student = studentList.get(0);
			return new User(name, student.getStuPassword(), grantedAuths);
		} else {
			return null;
		}
		
	}
}
