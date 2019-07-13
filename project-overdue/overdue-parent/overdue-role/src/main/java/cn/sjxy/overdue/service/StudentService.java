package cn.sjxy.overdue.service;
import cn.sjxy.overdue.pojo.Student;
import cn.sjxy.overdue.pojo.entity.PageResult;

import java.util.List;
/**
 * 鏈嶅姟灞傛帴鍙�
 * @author Administrator
 *
 */
public interface StudentService {

	/**
	 * 杩斿洖鍏ㄩ儴鍒楄〃
	 * @return
	 */
	public List<Student> findAll();
	
	
	/**
	 * 杩斿洖鍒嗛〉鍒楄〃
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 澧炲姞
	*/
	public void add(Student student);
	
	
	/**
	 * 淇敼
	 */
	public void update(Student student);
	

	/**
	 * 鏍规嵁ID鑾峰彇瀹炰綋
	 * @param id
	 * @return
	 */
	public Student findOne(Integer id);
	
	
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
	public PageResult findPage(Student student, int pageNum, int pageSize);


	public List<Student> findOneByName(String username);
	
}
