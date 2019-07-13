package cn.sjxy.overdue.service;

import cn.sjxy.overdue.dao.*;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.SecretaryExample.Criteria;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.StuProcess;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 鏈嶅姟瀹炵幇灞�
 *
 * @author Administrator
 */
@Service
public class SecretaryServiceImpl implements SecretaryService {

    @Autowired
    private SecretaryMapper secretaryMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ProfessionMapper professionMapper;
    @Autowired
    TeaassignMapper teaassignMapper;
    @Autowired
    StudyprocessMapper studyprocessMapper;
    @Autowired
    CourseMapper courseMapper;

    /**
     * 分配任务
     *
     * @param teacherId
     * @param couId
     * @param studentId
     */
    @Override
    public void assignTask(Integer teacherId, Integer couId, Integer studentId) {
        Teaassign teaassign = new Teaassign();
        teaassign.setTeaId(teacherId);
        teaassign.setCouId(couId);
        teaassign.setStuId(studentId);
        teaassignMapper.insert(teaassign);
        //将任课教师添加到学生表的任课教师字段中
        Student student = studentMapper.selectByPrimaryKey(studentId);
        String stuTeacherId = student.getStuTeacherId();
        if (stuTeacherId == null || stuTeacherId.equals("null")) {
            student.setStuTeacherId(String.valueOf(teacherId));
        } else {
            Student student1 = studentMapper.selectByPrimaryKey(studentId);
            String stuTeacherId1 = student1.getStuTeacherId();
            String[] split = stuTeacherId1.split(",");
            List<String> list = Arrays.asList(split);
            for (String s : list) {
                if (Integer.valueOf(s) == teacherId) {
                    return;
                }

            }
            String s = stuTeacherId + "," + String.valueOf(teacherId);
            student.setStuTeacherId(s);
        }
        studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 根据courseId查找所有未过该课程的学生
     *
     * @param courseId
     * @return
     */
    @Override
    public List<Student> findStudent(Integer courseId) {
        List<Student> students = studentMapper.selectByExample(null);
        List<Student> students1 = new ArrayList<Student>();
        for (Student s : students) {

            String substring = s.getStuCourseId().substring(1, s.getStuCourseId().length() - 1);
            String[] split = substring.split(",");
            List<String> list = Arrays.asList(split);
            for (String ss : list) {
                if (courseId == Integer.valueOf(ss)) {
                    TeaassignExample teaassignExample = new TeaassignExample();
                    TeaassignExample.Criteria criteria = teaassignExample.createCriteria();
                    criteria.andStuIdEqualTo(s.getStuId()).andCouIdEqualTo(courseId);
                    List<Teaassign> teaassigns = teaassignMapper.selectByExample(teaassignExample);
                    if (teaassigns.size() != 0) {
                        continue;
                    }
                    String stuProfessionId = s.getStuProfessionId();
                    Profession profession = professionMapper.selectByPrimaryKey(Integer.valueOf(stuProfessionId));
                    s.setStuProfessionId(profession.getProName());
                    students1.add(s);
                }
            }
        }
        return students1;
    }


    /**
     * 鏌ヨ鍏ㄩ儴
     */
    @Override
    public List<Secretary> findAll() {
        return secretaryMapper.selectByExample(null);
    }

    /**
     * 鎸夊垎椤垫煡璇�
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Secretary> page = (Page<Secretary>) secretaryMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 澧炲姞
     */
    @Override
    public void add(Secretary secretary) {
        secretaryMapper.insert(secretary);
    }


    /**
     * 淇敼
     */
    @Override
    public void update(Secretary secretary) {
        secretaryMapper.updateByPrimaryKey(secretary);
    }

    /**
     * 鏍规嵁ID鑾峰彇瀹炰綋
     *
     * @param id
     * @return
     */
    @Override
    public Secretary findOne(Integer id) {
        return secretaryMapper.selectByPrimaryKey(id);
    }

    /**
     * 鎵归噺鍒犻櫎
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            secretaryMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(Secretary secretary, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SecretaryExample example = new SecretaryExample();
        SecretaryExample.Criteria criteria = example.createCriteria();

        if (secretary != null) {
            if (secretary.getSecName() != null && secretary.getSecName().length() > 0) {
                criteria.andSecNameLike("%" + secretary.getSecName() + "%");
            }
            if (secretary.getSecPassword() != null && secretary.getSecPassword().length() > 0) {
                criteria.andSecPasswordLike("%" + secretary.getSecPassword() + "%");
            }

        }

        Page<Secretary> page = (Page<Secretary>) secretaryMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Secretary> findOneByName(String secretaryName) {
//			System.out.println("cn.sjxy.overdue.service.impl.SecretaryServiceImpl.findOneByName(String)");
//			System.out.println(secretaryName);
        SecretaryExample example = new SecretaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andSecNameEqualTo(secretaryName);
//			System.out.println("after criteria");
//			System.out.println(secretaryMapper.selectByExample(example));
//			System.out.println("dadadadadada");
        return secretaryMapper.selectByExample(example);
    }

    @Override
    public List<StuProcess> findStuProcess() {
        List<Studyprocess> studyprocesses = studyprocessMapper.selectByExample(null);
        List<StuProcess> stuProcessList = new ArrayList<StuProcess>();
        for (Studyprocess studyprocess : studyprocesses) {
            StuProcess stuProcess = new StuProcess();
            Integer stuId = studyprocess.getStuId();
            Student student = studentMapper.selectByPrimaryKey(stuId);

            String stuCourseId = student.getStuCourseId();
            String substring = stuCourseId.substring(1, stuCourseId.length() - 1);
            String[] split = substring.split(",");
            List<String> list = Arrays.asList(split);
            List<String> listCou = new ArrayList<String>();
            for (String s : list) {
                Course course = courseMapper.selectByPrimaryKey(Integer.valueOf(s));
                String couName = course.getCouName();
                listCou.add(couName);
            }
            String substring1 = listCou.toString().substring(1, listCou.toString().length() - 1);
            student.setStuCourseId(substring1);

            String stuTeacherId = student.getStuTeacherId();
            List<String> tempList1 = new ArrayList<String>();
            if (stuTeacherId != null) {
                String[] split1 = stuTeacherId.split(",");
                List<String> list1 = Arrays.asList(split1);
                for (String sss : list1) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.valueOf(sss));
                    if (teacher != null) {
                        tempList1.add(teacher.getTeaName());
                    }
                }
                String substring2 = tempList1.toString().substring(1, tempList1.toString().length() - 1);
                student.setStuTeacherId(substring2);
            }
            String accumStudytime = studyprocess.getAccumStudytime();
            if (accumStudytime != null && !accumStudytime.equals("")) {
                String s = formatTime(Long.valueOf(accumStudytime));
                System.out.println(s + "学习时间");
                studyprocess.setAccumStudytime(s);
            }else {
                studyprocess.setAccumStudytime("尚未学习！");
            }
            studyprocess.getStuLogouttime();
            stuProcess.setStudent(student);
            stuProcess.setStudyprocess(studyprocess);
            stuProcessList.add(stuProcess);
        }
        return stuProcessList;
    }

    /*
     * 毫秒转化时分秒毫秒
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }
        return sb.toString();
    }
}
