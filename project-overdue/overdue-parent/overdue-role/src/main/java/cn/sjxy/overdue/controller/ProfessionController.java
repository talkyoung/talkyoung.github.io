package cn.sjxy.overdue.controller;


import cn.sjxy.overdue.pojo.Profession;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.Result;
import cn.sjxy.overdue.service.ProfessionService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {

	@Reference
	private ProfessionService professionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Profession> findAll(){
		return professionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return professionService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param profession
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Profession profession){
		try {
			professionService.add(profession);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param profession
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Profession profession){
		try {
			professionService.update(profession);
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
	public Profession findOne(Integer id){
		return professionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			professionService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param profession
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Profession profession, int page, int rows  ){
		return professionService.findPage(profession, page, rows);		
	}
	
}
