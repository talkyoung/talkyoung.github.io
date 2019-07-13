package cn.sjxy.overdue.student.service;

import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.TeaAndCou;

import java.util.List;

/**
 * @author Administrator
 */
public interface StudentService {
    /**
     * 查找一门课程
     */
    public Course findOneCourse(Integer cId);

    /**
     * 查找文件
     */
    public List<File> findAllFile(Integer tId,Integer courseId);

    /**
     * 删除留言
     */
    public void deleteReply(Integer comId);

    /**
     * 上传回复内容
     */
    public void sendContent(Comments comments);

    /**
     * 分页查询所有评论
     */
    public PageResult findComByPage(int page, int rows, int stuId);

    /**
     * 根据当前登陆学生id查找comments内容给前端
     */
    public List<Comments> showComments(Integer sId);

    /**
     * 根据教师id查询该教师的视频资料
     */
    public List<Video> showVideo(Integer tId,Integer courseId);

    /**
     * 根据课程id查询所有任课教师
     */
    public String showTeacher(String cId, Integer sId);

    /**
     * 查找当前登陆学生的id
     */
    public Integer getStuId();

    /**
     * 查找当前登陆学生的所有课程
     */
    public String findAllCourse(Integer stuId);

    /**
     * 杩斿洖鍏ㄩ儴鍒楄〃
     *
     * @return
     */
    public List<Student> findAll();


    /**
     * 杩斿洖鍒嗛〉鍒楄〃
     *
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 澧炲姞
     */
    public void add(Student student);


    /**
     * 淇敼
     */
    public void update(Student student);


    /**
     * 鏍规嵁ID鑾峰彇瀹炰綋
     *
     * @param id
     * @return
     */
    public Student findOne(Integer id);


    /**
     * 鎵归噺鍒犻櫎
     *
     * @param ids
     */
    public void delete(Integer[] ids);

    /**
     * 鍒嗛〉
     *
     * @param pageNum  褰撳墠椤� 鐮�
     * @param pageSize 姣忛〉璁板綍鏁�
     * @return
     */
    public PageResult findPage(Student student, int pageNum, int pageSize);


    public List<Student> findOneByName(String username);

    public List<TeaAndCou> findTeaAndCou(Integer stuId);

    public String getTeaName(Integer teaId);
}
