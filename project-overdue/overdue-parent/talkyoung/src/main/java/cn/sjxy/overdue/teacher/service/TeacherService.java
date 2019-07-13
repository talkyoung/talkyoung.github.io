package cn.sjxy.overdue.teacher.service;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.AssignDetail;
import cn.sjxy.overdue.pojo.entity.PageResult;
import org.springframework.expression.spel.ast.Assign;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface TeacherService {
    /**
     * 查找当前教师的任务分配详细信息
     * @param teaId
     * @return
     */
    public List<AssignDetail> findAssignDetail(Integer teaId);

    /**
     * 查找所有的文件
     * @param tId 教师id
     * @return
     */
    public List<File> findAllFile(Integer tId);
    /**
     * 删除留言
     */
    public void deleteReply(Integer comId);
    /**
     * 提交留言
     */
    public void sendComment(Comments comments);
    /**
     * 根据teaID进行查询所有的教师comments
     */
    public List<Comments> findComByTeaId(Integer teaId);

    /**
     * 分页进行查询
     */
    public PageResult findComByPage(int page, int rows, int teaId);

    /**
     * 删除多条video
     */
    public void deleteMultiVideo(Integer[] ids);


    /**
     * 返回全部列表
     *
     * @return
     */
    public List<Teacher> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(Teacher teacher);


    /**
     * 修改
     */
    public void update(Teacher teacher);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public Teacher findOne(Integer id);


    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Integer[] ids);

//    /**
//     * 分页
//     *
//     * @param pageNum  当前页 码
//     * @param pageSize 每页记录数
//     * @return
//     */
//    public PageResult findPage(Teacher teacher, int pageNum, int pageSize);

    public List<Teacher> findByName(String name);

    /**
     * 根据courseId查询视频
     * @param courseId
     * @return
     */
    public List<Video> findVideoByCouId(Integer courseId,Integer teaId);

    /**
     * 根据couId查询文件
     * @param courseId
     * @param teaId
     * @return
     */
    public List<File> findFileByCouId(Integer courseId, Integer teaId);

    public void deleteMultiFile(Integer[] ids);
}
