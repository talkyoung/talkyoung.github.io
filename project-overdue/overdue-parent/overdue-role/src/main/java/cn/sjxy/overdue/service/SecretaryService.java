package cn.sjxy.overdue.service;
import cn.sjxy.overdue.pojo.Profession;
import cn.sjxy.overdue.pojo.Secretary;
import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.pojo.Teacher;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.pojo.entity.StuProcess;

import java.util.List;
/**
 * 鏈嶅姟灞傛帴鍙�
 * @author Administrator
 *
 */
public interface SecretaryService {

	/**
	 * 分配任务
	 * @param teacherId
	 * @param couId
	 * @param studentId
	 */
	public void assignTask(Integer teacherId,Integer couId,Integer studentId);
	/**
	 * 根据courseId查找所有未过该课程的学生
	 * @param courseId
	 * @return
	 */
	public List<Student> findStudent(Integer courseId);


	/**
	 * 杩斿洖鍏ㄩ儴鍒楄〃
	 * @return
	 */
	public List<Secretary> findAll();
	
	
	/**
	 * 杩斿洖鍒嗛〉鍒楄〃
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 澧炲姞
	*/
	public void add(Secretary secretary);
	
	
	/**
	 * 淇敼
	 */
	public void update(Secretary secretary);
	

	/**
	 * 鏍规嵁ID鑾峰彇瀹炰綋
	 * @param id
	 * @return
	 */
	public Secretary findOne(Integer id);
	
	
	/**
	 * 鎵归噺鍒犻櫎
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 鍒嗛〉
	 * @param pageNum 褰撳墠椤� 鐮�
	 * @param pageSize 姣忛〉璁板綍鏁�
	 * @return
	 */
	public PageResult findPage(Secretary secretary, int pageNum, int pageSize);
	
	/**
	 * 根据姓名进行查询
	 * @param secretaryName
	 * @return
	 */
	public List<Secretary> findOneByName(String secretaryName);

    public List<StuProcess> findStuProcess();
}
