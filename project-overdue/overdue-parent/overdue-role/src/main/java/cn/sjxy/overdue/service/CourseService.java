package cn.sjxy.overdue.service;
import java.util.List;

import cn.sjxy.overdue.pojo.Course;
import cn.sjxy.overdue.pojo.entity.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CourseService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Course> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Course course);
	
	
	/**
	 * 修改
	 */
	public void update(Course course);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Course findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Course course, int pageNum, int pageSize);
	
}
