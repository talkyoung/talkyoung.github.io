package cn.sjxy.overdue.teacher.controller;

import cn.sjxy.overdue.dao.FileMapper;
import cn.sjxy.overdue.dao.StudentMapper;
import cn.sjxy.overdue.dao.VideoMapper;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.AssignDetail;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
import cn.sjxy.overdue.teacher.log.TeacherLog;
import cn.sjxy.overdue.teacher.service.GetTeaIdService;
import cn.sjxy.overdue.teacher.service.TeacherService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    GetTeaIdService getTeaIdService;
    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 根据courseId查询文件
     * @param courseId
     * @return
     */
    @RequestMapping("/findFileByCouId")
    public String findFileByCouId(Integer courseId){
        Integer teaId = getTeaIdService.getTeaId();
        List<File> fileByCouId = teacherService.findFileByCouId(courseId, teaId);
        String s = JSONObject.toJSONStringWithDateFormat(fileByCouId,"yyyy-MM-dd HH:mm:ss");
        return s;
    }
    /**
     * 根据courseId查询视频
     * @param courseId
     * @return
     */
    @RequestMapping("/findVideoByCouId")
    public String findVideoByCouId(Integer courseId){
        Integer teaId = getTeaIdService.getTeaId();
        List<Video> videoByCouId = teacherService.findVideoByCouId(courseId, teaId);
        String s = JSONObject.toJSONStringWithDateFormat(videoByCouId,"yyyy-MM-dd HH:mm:ss");
        return s;
    }
    /**
     * 查找当前教师的任务分配详细信息
     * @return
     */
    @RequestMapping("/findAssignDetail")
    public String findAssignDetail(){
        Integer teaId = getTeaIdService.getTeaId();
        List<AssignDetail> assignDetail = teacherService.findAssignDetail(teaId);
        if (assignDetail.size()==0){
            return null;
        }
        String s = JSON.toJSONString(assignDetail);
        return s;
    }
    @RequestMapping("/findAllFile")
    public String findAllFile() {
        List<File> allFile = teacherService.findAllFile(getTeaIdService.getTeaId());
        String s1 = JSONObject.toJSONStringWithDateFormat(allFile, "yyyy-MM-dd HH:mm:ss");
//        String s = JSON.toJSONString(allFile);
        return s1;
    }

    /**
     * 删除留言
     */
    @RequestMapping("/deleteReply")
    @TeacherLog(module = "deleteReply", action = "教师删除留言")
    public Result deleteReply(Integer comId) {
        try {
            teacherService.deleteReply(comId);
            return new Result(true, "留言删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "留言删除失败");

        }
    }

    /**
     * 保存教师的留言回复
     */
    @RequestMapping("/sendComment")
    @TeacherLog(module = "sendComment", action = "教师回复留言")
    public Result sendComment(String textContent, Integer stuId) {
        try {
            String str = new String(textContent.getBytes("ISO8859_1"), "utf-8");
            Comments comments = new Comments();
            comments.setComContent(str);
            comments.setComJudge("2");
            comments.setComTeaid(getTeaIdService.getTeaId());
            comments.setComDate(new Date());
            comments.setComStuid(stuId);
            comments.setCouTeaname(SecurityContextHolder.getContext()
                    .getAuthentication().getName());
            comments.setComStuname(studentMapper.selectByPrimaryKey(stuId).getStuName());
            teacherService.sendComment(comments);
            return new Result(true, "留言回复成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "留言回复失败");

        }
    }

    /**
     * 根据分页进行查询
     */
    @RequestMapping("findComByPage")
    public String findComByPage(int page, int rows) {
        PageResult comByPage = teacherService.findComByPage(page, rows, getTeaIdService.getTeaId());
        String s1 = JSONObject.toJSONStringWithDateFormat(comByPage, "yyyy-MM-dd HH:mm:ss");
        return s1;
    }

    /**
     * 返回当前登陆教师姓名
     */
    @RequestMapping("/findTeaName")
    public String findTeaName() {
        return SecurityContextHolder.getContext()
                .getAuthentication().getName();
    }

    /**
     * 一次删除多个video
     */
    @RequestMapping("/deleteMultiVideo")
    @TeacherLog(module = "deleteMultiVideo", action = "教师删除多个视频资源")
    public Result deleteMultiVideo(Integer[] ids) {
        try {
            teacherService.deleteMultiVideo(ids);
            return new Result(true, "删除多条记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除多条记录失败");
        }
    }
    /**
     * 一次删除多个file
     */
    @RequestMapping("/deleteMultiFile")
    @TeacherLog(module = "deleteMultiFile", action = "教师删除多个视频资源")
    public Result deleteMultiFile(Integer[] ids) {
        try {
            teacherService.deleteMultiFile(ids);
            return new Result(true, "删除多条记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除多条记录失败");
        }
    }
    /**
     * 根据videoId删除单个video
     */
    @RequestMapping("/deleteVideoById")
    @TeacherLog(module = "deleteVideoById", action = "教师删除留言一个视频")
    public Result deleteVideoById(Integer vId) {
        try {
            VideoExample videoExample = new VideoExample();
            VideoExample.Criteria criteria = videoExample.createCriteria();
            criteria.andVIdEqualTo(vId);
            videoMapper.deleteByExample(videoExample);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    /**
     * 根据videoId删除单个video
     */
    @RequestMapping("/deleteFileById")
    @TeacherLog(module = "deleteFileById", action = "教师删除留言一个文件")
    public Result deleteFileById(Integer fId) {
        try {
            fileMapper.deleteByPrimaryKey(fId);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 根据教师的Id查询该教师所拥有的视频
     * 返回Json吧，方便前端遍历
     */
    @RequestMapping("/findAllVideo")
    public String findAllVideo() {
        //获得当前教师的Id
        Integer teaId = getTeaIdService.getTeaId();
        //System.out.println("findAllVideo（）中TeaId"+teaId);
        //根据teaId进行查找所有的video实体
        VideoExample videoExample = new VideoExample();
        VideoExample.Criteria criteria = videoExample.createCriteria();
        criteria.andTIdEqualTo(teaId);
        List<Video> videos = videoMapper.selectByExample(videoExample);
        //System.out.println(videos+"直接打印查询后的list集合");
        Map<String, List<Video>> map = new HashMap();
        map.put("videoList", videos);
        String s1 = JSONObject.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
//        String videoList = JSON.toJSONString(map);
        return s1;
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return teacherService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param teacher
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Teacher teacher) {
        try {
            teacherService.add(teacher);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param teacher
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Teacher teacher) {
        try {
            teacherService.update(teacher);
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
    public Teacher findOne(Integer id) {
        return teacherService.findOne(id);
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
            teacherService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
//    /**
//     * 查询+分页
//     *
//     * @param teacher
//     * @param page
//     * @param rows
//     * @return
//     */
//    @RequestMapping("/search")
//    public PageResult search(@RequestBody Teacher teacher, int page, int rows) {
//        return teacherService.findPage(teacher, page, rows);
//    }
}
