package cn.sjxy.overdue.student.controller;

import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
import cn.sjxy.overdue.pojo.entity.TeaAndCou;
import cn.sjxy.overdue.student.log.StudentLog;
import cn.sjxy.overdue.student.service.StudentServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.ECMAException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    /**
     * 查找课程和教师
     */
    @RequestMapping("/findTeaAndCou")
    public String findTeaAndCou() {
        Integer stuId = studentService.getStuId();
        List<TeaAndCou> teaAndCou = studentService.findTeaAndCou(stuId);
        String s = JSON.toJSONString(teaAndCou);
        return s;
    }

    /**
     * 查找所有文件
     */
    @RequestMapping("/showFile")
    public String showFile(Integer tId,Integer courseId) {
        List<File> allFile = studentService.findAllFile(tId,courseId);
        return JSONObject.toJSONStringWithDateFormat(allFile, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 根据comId删除留言
     *
     * @param comId
     * @return
     */
    @RequestMapping("/deleteReply")
    @StudentLog(module = "StudentController", action = "学生删除留言")
    public Result deleteReply(Integer comId) {
        try {
            studentService.deleteReply(comId);
            return new Result(true, "删除留言成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除留言失败");
        }
    }

    /**
     * 提交student上传的留言
     * comJudge用于判断是学生留言还是教师留言。方便前端判断格式 谁回复谁
     *
     * @param content
     * @return
     */
    @RequestMapping("/sendComment")
    @StudentLog(module = "StudentController", action = "学生进行留言回复")
    public Result sendComment(String content, Integer teaId) {
        try {
            String stuName = SecurityContextHolder.getContext()
                    .getAuthentication().getName();
            String teaName = studentService.getTeaName(teaId);
            String str = new String(content.getBytes("ISO8859_1"), "utf-8");
            Integer stuId = studentService.getStuId();
            Comments comments = new Comments();
            comments.setComContent(str);
            comments.setComStuid(stuId);
            comments.setComTeaid(teaId);
            comments.setComDate(new Date());
            comments.setComJudge("1");
            comments.setCouTeaname(teaName);
            comments.setComStuname(stuName);
            studentService.sendContent(comments);
            return new Result(true, "留言成功");
        } catch (Exception e) {
            return new Result(true, "留言失败");
        }
    }

    /**
     * 分页进行查询评论
     */
    @RequestMapping("/findComByPage")
    public String findComByPage(int page, int rows) {
        Integer stuId = studentService.getStuId();
        String s1 = JSONObject.toJSONStringWithDateFormat(studentService.findComByPage(page, rows, stuId), "yyyy-MM-dd HH:mm:ss");
        return s1;
    }

    /**
     * 根据当前登陆学生id查找comments内容给前端
     */
    @RequestMapping("/showComments")
    public String showComments() {
        Integer stuId = studentService.getStuId();
        List<Comments> comments = studentService.showComments(stuId);
        String s1 = JSONObject.toJSONStringWithDateFormat(comments, "yyyy-MM-dd HH:mm:ss");
        return s1;
    }

    /**
     * 将学生姓名返回给前台
     *
     * @return
     */
    @RequestMapping("/getStuName")
    public String getStuName() {
        return SecurityContextHolder.getContext()
                .getAuthentication().getName();
    }

    /**
     * 根据教师id查询该教师的视频资料
     */
    @RequestMapping("/showVideo")
    @StudentLog(module = "StudentController", action = "学生查看视频资料进行学习")
    public String showVideo(Integer tId,Integer courseId) {
        List<Video> videos = studentService.showVideo(tId,courseId);
        return JSONObject.toJSONStringWithDateFormat(videos, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 根据课程id显示所有的教师
     */
    @RequestMapping("/showTeacher")
    public Result showTeacher(String cId) {
        Integer stuId = studentService.getStuId();
        String s = studentService.showTeacher(cId, stuId);
        if (s == null) {
            return new Result(false, "任务尚未分配");
        }
        return new Result(true, s);
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAllCourse")
    public String findAllCourse() {
        String allCourse = studentService.findAllCourse(studentService.getStuId());
        String substring = allCourse.substring(1, allCourse.length() - 1);
        String[] split = substring.split(",");
        List<Course> courses = new ArrayList<>();
        for (String s : split) {
            Course oneCourse = studentService.findOneCourse(Integer.valueOf(s));
            courses.add(oneCourse);
        }
        String s = JSON.toJSONString(courses);
        return s;
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return studentService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param student
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Student student) {
        try {
            studentService.add(student);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param student
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Student student) {
        try {
            studentService.update(student);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Student findOne(Integer id) {
        return studentService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Integer[] ids) {
        try {
            studentService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param student
     * @param page
     * @param rows
     * @return @RequestBody
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Student student, int page, int rows) {
        return studentService.findPage(student, page, rows);
    }


    @RequestMapping("/findAll")
    public String findAll() {
        List<Student> studentList = new ArrayList<Student>();
        studentList = studentService.findAll();
        return "student/hello";
    }
}
