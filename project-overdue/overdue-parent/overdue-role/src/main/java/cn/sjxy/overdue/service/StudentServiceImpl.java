package cn.sjxy.overdue.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.sjxy.overdue.dao.*;
import cn.sjxy.overdue.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.sjxy.overdue.pojo.StudentExample.Criteria;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ProfessionMapper professionMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

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
        PageHelper.startPage(pageNum, pageSize);
        StudentExample example = new StudentExample();
        Criteria criteria = example.createCriteria();
        //因为数据库中student的courseId使用数组显示的courseId
        //想让前端按照名称显示出来，只能在后端进行一些修改拉
        List<Student> students = studentMapper.selectByExample(example);
        for (Student s : students) {
            String stuCourseId = s.getStuCourseId();
            String substring = stuCourseId.substring(1, stuCourseId.length() - 1);
            String[] split = substring.split(",");
            List<String> list = Arrays.asList(split);
            List<String> tempList = new ArrayList<String>();
            for (String ss : list) {
                Course course = courseMapper.selectByPrimaryKey(Integer.valueOf(ss));
                tempList.add(course.getCouName());
            }

            String stuTeacherId = s.getStuTeacherId();
            List<String> tempList1 = new ArrayList<String>();
            if (stuTeacherId != null) {
                String[] split1 = stuTeacherId.split(",");
                List<String> list1 = Arrays.asList(split1);
                for (String sss : list1) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.valueOf(sss));
                    if (teacher != null){
                        tempList1.add(teacher.getTeaName());
                    }
                }
                String substring2 = tempList1.toString().substring(1, tempList1.toString().length() - 1);
                s.setStuTeacherId(substring2);
            }

            String stuProfessionId = s.getStuProfessionId();
            Profession profession = professionMapper.selectByPrimaryKey(Integer.valueOf(stuProfessionId));

            String stuDepartmentId = s.getStuDepartmentId();
            Department department = departmentMapper.selectByPrimaryKey(Integer.valueOf(stuDepartmentId));
            String substring1 = tempList.toString().substring(1, tempList.toString().length() - 1);
            s.setStuCourseId(substring1);
            s.setStuProfessionId(profession.getProName());
            s.setStuDepartmentId(department.getDeptName());
        }
        Page<Student> page = (Page<Student>) students;
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Student> findOneByName(String username) {
        StudentExample example = new StudentExample();
        Criteria criteria = example.createCriteria();
        criteria.andStuNameEqualTo(username);
        return studentMapper.selectByExample(example);
    }
}
