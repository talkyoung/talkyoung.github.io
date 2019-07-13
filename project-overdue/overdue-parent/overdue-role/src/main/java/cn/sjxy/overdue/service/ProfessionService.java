package cn.sjxy.overdue.service;
import cn.sjxy.overdue.pojo.Profession;
import cn.sjxy.overdue.pojo.entity.PageResult;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProfessionService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Profession> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Profession profession);
	
	
	/**
	 * 修改
	 */
	public void update(Profession profession);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Profession findOne(Integer id);
	
	
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
	public PageResult findPage(Profession profession, int pageNum, int pageSize);
	
}
