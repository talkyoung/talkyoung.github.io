package cn.sjxy.overdue.controller;
import java.util.List;

import cn.sjxy.overdue.pojo.Department;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
import cn.sjxy.overdue.service.DepartmentService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Reference
	private DepartmentService departmentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Department> findAll(){
		return departmentService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return departmentService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param department
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Department department){
		try {
			departmentService.add(department);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param department
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Department department){
		try {
			departmentService.update(department);
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
	public Department findOne(Integer id){
		return departmentService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			departmentService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param department
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Department department, int page, int rows  ){
		return departmentService.findPage(department, page, rows);		
	}
	
}
