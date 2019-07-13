package cn.sjxy.overdue.student.listener;

import cn.sjxy.overdue.dao.StudentMapper;
import cn.sjxy.overdue.dao.StudyprocessMapper;
import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.pojo.StudentExample;
import cn.sjxy.overdue.pojo.Studyprocess;
import cn.sjxy.overdue.pojo.StudyprocessExample;
import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.L;

public class MySessionListener implements HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {
    WebApplicationContext applicationContext = null;

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        StudyprocessMapper studyprocessMapper = (StudyprocessMapper) applicationContext.getBean("studyprocessMapper");
        //获取向会话域中新添加的属性名称
        String attrName = httpSessionBindingEvent.getName();
        //获取向会话域中添加的名称对象的值
        Object attrValue = httpSessionBindingEvent.getValue();
        if ("SPRING_SECURITY_CONTEXT".equals(attrName)) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andStuNameEqualTo(name);
            List<Student> students = studentMapper.selectByExample(studentExample);
            Integer stuId = students.get(0).getStuId();
            //在监控表查询学生记录
            StudyprocessExample studyprocessExample = new StudyprocessExample();
            StudyprocessExample.Criteria criteria1 = studyprocessExample.createCriteria();
            criteria1.andStuIdEqualTo(stuId);
            List<Studyprocess> studyprocesses = studyprocessMapper.selectByExample(studyprocessExample);
            if (studyprocesses.size() == 0) {
                Studyprocess studyprocess = new Studyprocess();
                studyprocess.setStuId(stuId);
                studyprocess.setStuName(name);
                studyprocess.setStuLogintime(new Date());
                studyprocessMapper.insert(studyprocess);
            } else {
                Studyprocess studyprocess = studyprocesses.get(0);
                studyprocess.setStuLogintime(new Date());
                studyprocess.setStuLogouttime(null);
                studyprocessMapper.updateByPrimaryKey(studyprocess);
            }
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        StudyprocessMapper studyprocessMapper = (StudyprocessMapper) applicationContext.getBean("studyprocessMapper");
        //获取从会话域中要移除的属性名称
        String attrName = httpSessionBindingEvent.getName();
        //获取从会话域中移除的名称对象的值
        Object attrValue = httpSessionBindingEvent.getValue();
        if ("SPRING_SECURITY_CONTEXT".equals(attrName)) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andStuNameEqualTo(name);
            List<Student> students = studentMapper.selectByExample(studentExample);
            Integer stuId = students.get(0).getStuId();
            //在监控表查询学生记录
            StudyprocessExample studyprocessExample = new StudyprocessExample();
            StudyprocessExample.Criteria criteria1 = studyprocessExample.createCriteria();
            criteria1.andStuIdEqualTo(stuId);
            List<Studyprocess> studyprocesses = studyprocessMapper.selectByExample(studyprocessExample);
            Studyprocess studyprocess = studyprocesses.get(0);
            Long accumTime = 0l;
            Date outTime = new Date();
            studyprocess.setStuLogouttime(outTime);
            Date inTime = studyprocess.getStuLogintime();
            accumTime = outTime.getTime() - inTime.getTime();
            String accumStudytime = studyprocess.getAccumStudytime();
            Long finalAccumTime = 0l;
            if (accumStudytime == null || accumStudytime.length() == 0) {
                finalAccumTime = accumTime;
            }else{
                finalAccumTime = accumTime + Long.valueOf(accumStudytime);
            }
            studyprocess.setAccumStudytime(String.valueOf(finalAccumTime));
            studyprocessMapper.updateByPrimaryKey(studyprocess);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        //获取从会话域中要被重新赋值的属性名称
        String attrName = httpSessionBindingEvent.getName();
        //获取从会话域中对应存在的名称被替换前的值
        Object attrValue = httpSessionBindingEvent.getValue();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
