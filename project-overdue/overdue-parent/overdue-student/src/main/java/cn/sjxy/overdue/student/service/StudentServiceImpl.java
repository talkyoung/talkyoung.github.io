package cn.sjxy.overdue.student.service;

import cn.sjxy.overdue.dao.*;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.StudentExample.Criteria;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.TeaAndCou;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private TeaassignMapper teaassignMapper;

    /**
     * 查找一门课程
     *
     * @param cId
     */
    @Override
    public Course findOneCourse(Integer cId) {
        return courseMapper.selectByPrimaryKey(cId);
    }

    /**
     * 查找文件
     *
     * @param tId
     */
    @Override
    public List<File> findAllFile(Integer tId,Integer courseId) {
        FileExample fileExample = new FileExample();
        FileExample.Criteria criteria = fileExample.createCriteria();
        criteria.andTIdEqualTo(tId).andCIdEqualTo(courseId);
        List<File> files = fileMapper.selectByExample(fileExample);
        return files;
    }

    /**
     * 删除留言
     *
     * @param comId
     */
    @Override
    public void deleteReply(Integer comId) {
        commentsMapper.deleteByPrimaryKey(comId);
    }

    /**
     * 上传回复内容
     */
    @Override
    public void sendContent(Comments comments) {
        commentsMapper.insert(comments);
    }

    /**
     * 分页查询comments
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult findComByPage(int page, int rows, int stuId) {
        PageHelper.startPage(page, rows);
        Page<Comments> commentsPage = (Page<Comments>) showComments(stuId);
        return new PageResult(commentsPage.getTotal(), commentsPage.getResult());
    }

    /**
     * 根据当前登陆学生id查找comments内容给前端
     */
    @Override
    public List<Comments> showComments(Integer sId) {
        CommentsExample commentsExample = new CommentsExample();
        CommentsExample.Criteria criteria = commentsExample.createCriteria();
        criteria.andComStuidEqualTo(sId);
        List<Comments> comments = commentsMapper.selectByExample(commentsExample);
        return comments;
    }

    /**
     * 根据教师id查询该教师的视频资料
     */
    @Override
    public List<Video> showVideo(Integer id,Integer courseId) {
        VideoExample videoExample = new VideoExample();
        VideoExample.Criteria criteria = videoExample.createCriteria();
        criteria.andTIdEqualTo(id).andCIdEqualTo(courseId);
        List<Video> videos = videoMapper.selectByExample(videoExample);
        return videos;
    }

    /**
     * 根据课程id查询所有任课教师
     */
    @Override
    public String showTeacher(String cId, Integer sId) {
        Integer courseId = Integer.valueOf(cId);
        TeaassignExample teaassignExample = new TeaassignExample();
        TeaassignExample.Criteria criteria = teaassignExample.createCriteria();
        criteria.andCouIdEqualTo(courseId).andStuIdEqualTo(sId);
        List<Teaassign> teaassigns = teaassignMapper.selectByExample(teaassignExample);
        if (teaassigns.size() != 0) {
            Teaassign teaassign = teaassigns.get(0);
            Integer teaId = teaassign.getTeaId();
            final Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
            return JSON.toJSONString(teacher);
        }
        return null;
//        Integer id = Integer.valueOf(cId);
//
//        Student student = studentMapper.selectByPrimaryKey(sId);
//        Integer stuProfessionId = student.getStuProfessionId();
//
//        TeacherExample teacherExample = new TeacherExample();
//        TeacherExample.Criteria criteria = teacherExample.createCriteria();
//        criteria.andTeaCourseEqualTo(id).andTeaTaskProfEqualTo(stuProfessionId);
//        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
//        System.out.println(teacherList+"卧槽你妈个头的");
//        if (teacherList.size() == 0) {
//            return null;
//        }
//        String s = null;
//        if (teacherList.size() != 0) {
//            s = JSON.toJSONString(teacherList.get(0));
//        }
//        return s;
    }

    /**
     * 查找当前登陆学生的id
     */
    @Override
    public Integer getStuId() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        StudentExample studentExample = new StudentExample();
        Criteria criteria = studentExample.createCriteria();
        criteria.andStuNameEqualTo(name);
        return studentMapper.selectByExample(studentExample).get(0).getStuId();
    }

    /**
     * 查询该学生的所有课程
     *
     * @return
     */
    @Override
    public String findAllCourse(Integer stuId) {
        Student student = studentMapper.selectByPrimaryKey(stuId);
        return student.getStuCourseId();
    }

    /**
     * 鏌ヨ鍏ㄩ儴
     */
    @Override
    public List<Student> findAll() {
        return studentMapper.selectByExample(null);
    }

    /**
     * 鎸夊垎椤垫煡璇�
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Student> page = (Page<Student>) studentMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 澧炲姞
     */
    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }


    /**
     * 淇敼
     */
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 鏍规嵁ID鑾峰彇瀹炰綋
     *
     * @param id
     * @return
     */
    @Override
    public Student findOne(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
     * 鎵归噺鍒犻櫎
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            studentMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(Student student, int pageNum, int pageSize) {
//		System.out.println("stu ser findpage");
        PageHelper.startPage(pageNum, pageSize);
//		System.out.println("startpage after");
        StudentExample example = new StudentExample();
        Criteria criteria = example.createCriteria();

        if (student != null) {
            if (student.getStuName() != null && student.getStuName().length() > 0) {
                criteria.andStuNameLike("%" + student.getStuName() + "%");
            }
            if (student.getStuPassword() != null && student.getStuPassword().length() > 0) {
                criteria.andStuPasswordLike("%" + student.getStuPassword() + "%");
            }
            if (student.getStuPhone() != null && student.getStuPhone().length() > 0) {
                criteria.andStuPhoneLike("%" + student.getStuPhone() + "%");
            }
        }
//		System.out.println("select before");
        Page<Student> page = (Page<Student>) studentMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Student> findOneByName(String username) {
        StudentExample example = new StudentExample();
        Criteria criteria = example.createCriteria();
        criteria.andStuNameEqualTo(username);
        return studentMapper.selectByExample(example);
    }

    /**
     * 将教师和课程保存到一个集合显示
     *
     * @param stuId
     * @return
     */
    @Override
    public List<TeaAndCou> findTeaAndCou(Integer stuId) {
        Student student = studentMapper.selectByPrimaryKey(stuId);
        String stuCourseId = student.getStuCourseId();
        String substring = stuCourseId.substring(1, stuCourseId.length() - 1);
        String[] split = substring.split(",");
        List<String> list = Arrays.asList(split);
        //保存tea和cou的信息
        List<TeaAndCou> teaAndCousList = new ArrayList<>();
        for (String courseId : list) {
            TeaAndCou teaAndCou = new TeaAndCou();
            TeaassignExample teaassignExample = new TeaassignExample();
            TeaassignExample.Criteria criteria = teaassignExample.createCriteria();
            Integer cId = Integer.valueOf(courseId);
            Course course = courseMapper.selectByPrimaryKey(cId);
            String couName = course.getCouName();
            criteria.andStuIdEqualTo(stuId).andCouIdEqualTo(cId);
            //根据stuId和couId进行查询teacherAssign记录，如果存在分配记录就添加tea信息到teaandcou
            List<Teaassign> teaassigns = teaassignMapper.selectByExample(teaassignExample);
            if (teaassigns.size() != 0) {
                Integer teaId = teaassigns.get(0).getTeaId();
                teaAndCou.setTeacherId(teaId);
                Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
                String teaName = teacher.getTeaName();
                teaAndCou.setTeacherName(teaName);
            }
            teaAndCou.setCourseId(cId);
            teaAndCou.setCourseName(couName);
            teaAndCousList.add(teaAndCou);
        }
        return teaAndCousList;
    }

    @Override
    public String getTeaName(Integer teaId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
        return teacher.getTeaName();
    }
}
