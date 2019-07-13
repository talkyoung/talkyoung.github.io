package cn.sjxy.overdue.controller;

import java.util.*;

import cn.sjxy.overdue.dao.ProfessionMapper;
import cn.sjxy.overdue.dao.StudyprocessMapper;
import cn.sjxy.overdue.dao.TeacherMapper;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.StuProcess;
import cn.sjxy.overdue.service.StudentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
import cn.sjxy.overdue.service.SecretaryService;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    @Autowired
    ProfessionMapper professionMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping("/findStuProcess")
    public String findStuProcess(){
        List<StuProcess> stuProcess = secretaryService.findStuProcess();
        for (StuProcess stuProcess1 :stuProcess){
            System.out.println(stuProcess1);
        }
        String s = JSONObject.toJSONStringWithDateFormat(stuProcess, "yyyy-MM-dd HH-mm-ss");
        return s;
    }
    //分配任务拉
    @RequestMapping("/assignTask")
    public Result assignTask(Integer teacherId,Integer couId,Integer studentId){
        try{
            secretaryService.assignTask(teacherId,couId,studentId);
            return new Result(true,"分配任务成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"分配任务失败");
        }
    }
    //根据courseId查找学生
    @RequestMapping("/findStudent")
    public String findStudent(Integer courseId){
        List<Student> student = secretaryService.findStudent(courseId);
        String s = JSON.toJSONString(student);
        return s;
    }


//    @RequestMapping("/findAllProf")
//    public String findAllProf(Integer courseId) {
//        List<Integer> idList = new ArrayList<Integer>();
//        List<Profession> profession = secretaryService.findProfession(courseId);
//        if (profession.size() == 0) {
//            return null;
//        }
//        for (Profession profession1 : profession) {
//            idList.add(profession1.getProId());
//        }
//        for (Integer i : idList) {
//            TeacherExample teacherExample = new TeacherExample();
//            TeacherExample.Criteria criteria = teacherExample.createCriteria();
//            criteria.andTeaCourseEqualTo(courseId).andTeaTaskProfEqualTo(i);
//            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
//            if (teacherList.size() != 0) {
//                Profession profession1 = professionMapper.selectByPrimaryKey(i);
//                profession.remove(profession1);
//            }
//        }
//
//        if (profession.size() == 0) {
//            return null;
//        }
//        String s = JSON.toJSONString(profession);
//        return s;
//    }

    /**
     * 根据cid查找所有教师
     */
    @RequestMapping("/showTeacher")
    public String showTeacher(String cId) {
        List<Teacher> teacherList = teacherMapper.selectByExample(null);
        List<Teacher> teacherList1 = new ArrayList<Teacher>();
        for (Teacher tea :teacherList){
            String[] split = tea.getTeaCourse().split(",");
            List<String> list = Arrays.asList(split);
            for (String s :list){
                if(cId.equals(s)){
                    teacherList1.add(tea);
                }
            }
        }
        String s = JSON.toJSONString(teacherList1);
        return s;
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<Secretary> findAll() {
        return secretaryService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return secretaryService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param secretary
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Secretary secretary) {
        try {
            secretaryService.add(secretary);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param secretary
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Secretary secretary) {
        try {
            secretaryService.update(secretary);
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
    public Secretary findOne(Integer id) {
        return secretaryService.findOne(id);
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
            secretaryService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param secretary
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Secretary secretary, int page, int rows) {
        return secretaryService.findPage(secretary, page, rows);
    }

}
