package cn.sjxy.overdue.service;
import java.util.List;

import cn.sjxy.overdue.dao.DepartmentMapper;
import cn.sjxy.overdue.pojo.Department;
import cn.sjxy.overdue.pojo.DepartmentExample;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Department> findAll() {
		return departmentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Department> page=   (Page<Department>) departmentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Department department) {
		departmentMapper.insert(department);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Department department){
		departmentMapper.updateByPrimaryKey(department);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Department findOne(Integer id){
		return departmentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			departmentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Department department, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		DepartmentExample example=new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		
		if(department!=null){			
						if(department.getDeptName()!=null && department.getDeptName().length()>0){
				criteria.andDeptNameLike("%"+department.getDeptName()+"%");
			}
	
		}
		
		Page<Department> page= (Page<Department>)departmentMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
