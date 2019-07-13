package cn.sjxy.overdue.service;

import cn.sjxy.overdue.dao.CourseMapper;
import cn.sjxy.overdue.pojo.Course;
import cn.sjxy.overdue.pojo.CourseExample;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.service.CourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Course> findAll() {
		return courseMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Course> page=   (Page<Course>) courseMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Course course) {
		courseMapper.insert(course);
	}


	/**
	 * 修改
	 */
	@Override
	public void update(Course course){
		courseMapper.updateByPrimaryKey(course);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Course findOne(Integer id){
		return courseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			courseMapper.deleteByPrimaryKey(id);
		}
	}


		@Override
	public PageResult findPage(Course course, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		CourseExample example=new CourseExample();
			final CourseExample.Criteria criteria = example.createCriteria();

			if(course!=null){
						if(course.getCouName()!=null && course.getCouName().length()>0){
				criteria.andCouNameLike("%"+course.getCouName()+"%");
			}

		}

		Page<Course> page= (Page<Course>)courseMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
