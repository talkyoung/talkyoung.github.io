package cn.sjxy.overdue.teacher.service;
import cn.sjxy.overdue.dao.*;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.AssignDetail;
import cn.sjxy.overdue.pojo.entity.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private TeaassignMapper teaassignMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 查找当前教师的任务分配详细信息
     *
     * @param teaId
     * @return
     */
    @Override
    public List<AssignDetail> findAssignDetail(Integer teaId) {
        List<AssignDetail> assignDetails = new ArrayList<>();
        //在教师表中查找该教师负责的课程
        Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
        String teaCourse = teacher.getTeaCourse();
        String[] split = teaCourse.split(",");
        List<String> list = Arrays.asList(split);
        if(list.size()==0){
            return null;
        }
        //根据课程查找对应的学生，然后添加到AssignDetail中
        for(String courseId:list){
            AssignDetail assignDetail = new AssignDetail();
            //设置课程id和name
            assignDetail.setCouId(Integer.valueOf(courseId));
            Course course = courseMapper.selectByPrimaryKey(Integer.valueOf(courseId));
            assignDetail.setCouName(course.getCouName());
            //根据courseId和teaId查找对应的学生
            TeaassignExample teaassignExample = new TeaassignExample();
            TeaassignExample.Criteria criteria = teaassignExample.createCriteria();
            criteria.andTeaIdEqualTo(teaId).andCouIdEqualTo(Integer.valueOf(courseId));
            List<Teaassign> teaassigns = teaassignMapper.selectByExample(teaassignExample);
            if (teaassigns.size()==0){
                continue;
            }
            //每个assigndetail保存一个student集合
            List<Student> students = new ArrayList<>();
            for (Teaassign teaassign:teaassigns){
                //将teaasign表中的每一条记录中的学生信息添加到AssignDetail
                Student student = studentMapper.selectByPrimaryKey(teaassign.getStuId());
                students.add(student);
            }
            assignDetail.setStudents(students);
            assignDetails.add(assignDetail);
        }
        return assignDetails;
    }

    /**
     * 查找所有的文件
     *
     * @param tId 教师id
     * @return
     */
    @Override
    public List<File> findAllFile(Integer tId) {
        FileExample fileExample = new FileExample();
        FileExample.Criteria criteria = fileExample.createCriteria();
        criteria.andTIdEqualTo(tId);
        return fileMapper.selectByExample(fileExample);
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
     * 提交教师回复的留言
     */
    @Override
    public void sendComment(Comments comment) {
        commentsMapper.insert(comment);
    }

    /**
     * 根据teaId查询所有comments
     *
     * @param teaId
     * @return
     */
    @Override
    public List<Comments> findComByTeaId(Integer teaId) {
        CommentsExample commentsExample = new CommentsExample();
        CommentsExample.Criteria criteria = commentsExample.createCriteria();
        criteria.andComTeaidEqualTo(teaId);
        List<Comments> comments = commentsMapper.selectByExample(commentsExample);
        return comments;
    }

    /**
     * 分页查询comments
     *
     * @param page
     * @param rows
     * @param teaId
     * @return
     */
    @Override
    public PageResult findComByPage(int page, int rows, int teaId) {
        PageHelper.startPage(page, rows);
        Page<Comments> commentsPage = (Page<Comments>) findComByTeaId(teaId);
        return new PageResult(commentsPage.getTotal(), commentsPage.getResult());
    }

    /**
     * 删除多条video记录
     */
    @Override
    public void deleteMultiVideo(Integer[] ids) {
        for (Integer id : ids) {
            videoMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 查询全部
     */
    @Override
    public List<Teacher> findAll() {
        return teacherMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Teacher> page = (Page<Teacher>) teacherMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Teacher teacher) {
        teacherMapper.insert(teacher);
    }


    /**
     * 修改
     */
    @Override
    public void update(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Teacher findOne(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            teacherMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Teacher> findByName(String name) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeaNameEqualTo(name);
        return teacherMapper.selectByExample(teacherExample);
    }

    /**
     * 根据courseId查询视频
     *
     * @param courseId
     * @return
     */
    @Override
    public List<Video> findVideoByCouId(Integer courseId,Integer teaId) {
        VideoExample videoExample = new VideoExample();
        VideoExample.Criteria criteria = videoExample.createCriteria();
        criteria.andCIdEqualTo(courseId).andTIdEqualTo(teaId);
        List<Video> videos = videoMapper.selectByExample(videoExample);
        return videos;
    }

    /**
     * 根据couId查询文件
     *
     * @param courseId
     * @param teaId
     * @return
     */
    @Override
    public List<File> findFileByCouId(Integer courseId, Integer teaId) {
        FileExample fileExample = new FileExample();
        FileExample.Criteria criteria = fileExample.createCriteria();
        criteria.andCIdEqualTo(courseId).andTIdEqualTo(teaId);
        List<File> files = fileMapper.selectByExample(fileExample);
        return files;
    }

    @Override
    public void deleteMultiFile(Integer[] ids) {
        for (Integer id : ids) {
            fileMapper.deleteByPrimaryKey(id);
        }
    }

//    @Override
//    public PageResult findPage(Teacher teacher, int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//
//        TeacherExample example = new TeacherExample();
//        TeacherExample.Criteria criteria = example.createCriteria();
//
//        if (teacher != null) {
//            if (teacher.getTeaName() != null && teacher.getTeaName().length() > 0) {
//                criteria.andTeaNameLike("%" + teacher.getTeaName() + "%");
//            }
//            if (teacher.getTeaPassword() != null && teacher.getTeaPassword().length() > 0) {
//                criteria.andTeaPasswordLike("%" + teacher.getTeaPassword() + "%");
//            }
//            if (teacher.getTeaPhone() != null && teacher.getTeaPhone().length() > 0) {
//                criteria.andTeaPhoneLike("%" + teacher.getTeaPhone() + "%");
//            }
//            if (teacher.getTeaTaskProf() != null && teacher.getTeaTaskProf().length() > 0) {
//                criteria.andTeaTaskProfLike("%" + teacher.getTeaTaskProf() + "%");
//            }
//
//        }
//
//        Page<Teacher> page = (Page<Teacher>) teacherMapper.selectByExample(example);
//        return new PageResult(page.getTotal(), page.getResult());
//    }
//

}
