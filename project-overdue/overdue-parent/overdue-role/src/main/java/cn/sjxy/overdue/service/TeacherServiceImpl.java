package cn.sjxy.overdue.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.sjxy.overdue.dao.CourseMapper;
import cn.sjxy.overdue.dao.StudentMapper;
import cn.sjxy.overdue.dao.TeaassignMapper;
import cn.sjxy.overdue.dao.TeacherMapper;
import cn.sjxy.overdue.pojo.*;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.service.TeacherService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private TeaassignMapper teaassignMapper;

	@Autowired
	private StudentMapper studentMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<Teacher> findAll() {
		return teacherMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Teacher> page=   (Page<Teacher>) teacherMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Teacher teacher) {
		teacherMapper.insert(teacher);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Teacher teacher){
		teacherMapper.updateByPrimaryKey(teacher);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Teacher findOne(Integer id){
		return teacherMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			teacherMapper.deleteByPrimaryKey(id);
		}		
	}
	

		@Override
	public PageResult findPage(Teacher teacher, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TeacherExample example=new TeacherExample();
			TeacherExample.Criteria criteria = example.createCriteria();

			if(teacher!=null){
						if(teacher.getTeaName()!=null && teacher.getTeaName().length()>0){
				criteria.andTeaNameLike("%"+teacher.getTeaName()+"%");
			}
			if(teacher.getTeaPassword()!=null && teacher.getTeaPassword().length()>0){
				criteria.andTeaPasswordLike("%"+teacher.getTeaPassword()+"%");
			}
			if(teacher.getTeaPhone()!=null && teacher.getTeaPhone().length()>0){
				criteria.andTeaPhoneLike("%"+teacher.getTeaPhone()+"%");
			}

		}
			//单纯的让前端显示界面正确
			List<Teacher> teacherList = teacherMapper.selectByExample(example);
			for(Teacher teacher1 :teacherList){
				String teaCourse = teacher1.getTeaCourse();
				String[] split = teaCourse.split(",");
				List<String> list = Arrays.asList(split);
				List<String> list1 = new ArrayList<String>();
				for(String s:list){
					Course course = courseMapper.selectByPrimaryKey(Integer.valueOf(s));
					list1.add(course.getCouName());
				}
				String s = list1.toString();
				String substring = s.substring(1, s.length() - 1);
				teacher1.setTeaCourse(substring);

				TeaassignExample teaassignExample = new TeaassignExample();
				TeaassignExample.Criteria criteria1 = teaassignExample.createCriteria();
				criteria1.andTeaIdEqualTo(teacher1.getTeaId());
				List<Teaassign> teaassigns = teaassignMapper.selectByExample(teaassignExample);
				List<String> list2 = new ArrayList<String>();
				if(teaassigns.size() != 0){
					for (Teaassign teaassign:teaassigns){
						Integer stuId = teaassign.getStuId();
						Student student = studentMapper.selectByPrimaryKey(stuId);
						list2.add(student.getStuName());
					}
				}
				String s1 = list2.toString();
				String substring1 = s1.substring(1, s1.length() - 1);
				teacher1.setAssignStudent(substring1);
			}

			Page<Teacher> page= (Page<Teacher>) teacherList;
		return new PageResult(page.getTotal(), page.getResult());
	}
}
