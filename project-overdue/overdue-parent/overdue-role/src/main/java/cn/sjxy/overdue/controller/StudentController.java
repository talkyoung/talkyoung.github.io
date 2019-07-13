package cn.sjxy.overdue.controller;

import java.util.ArrayList;
import java.util.List;

import cn.sjxy.overdue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){
		return studentService.findPage(page, rows);
	}

	/**
	 * 增加
	 * @param student
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Student student){
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
	 * @param student
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Student student){
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
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Student findOne(Integer id){
		return studentService.findOne(id);
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
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
	 * @param student
	 * @param page
	 * @param rows
	 * @return	@RequestBody  	 
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Student student,int page, int rows  ){
		return studentService.findPage(student,page, rows);
	}


	@RequestMapping("/findAll")
	public String findAll() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentService.findAll();
		for(Student stu:studentList) {
		}
		return "student/hello";
	}
	@RequestMapping("/toLeftJsp")
	public String toLeftJsp(){
		return "student/student_left";
	}
	@RequestMapping("/toMainJsp")
	public String toMainJsp(){
		return "/student/student_main";
	}
	@RequestMapping("/toRightJsp")
	public String toRightJsp(){
		return "student/student_right";
	}
}
