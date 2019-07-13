package cn.sjxy.overdue.service;
import java.util.List;

import cn.sjxy.overdue.dao.ProfessionMapper;
import cn.sjxy.overdue.pojo.Profession;
import cn.sjxy.overdue.pojo.ProfessionExample;
import cn.sjxy.overdue.pojo.entity.PageResult;
import cn.sjxy.overdue.service.ProfessionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {

	@Autowired
	private ProfessionMapper professionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Profession> findAll() {
		return professionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Profession> page=   (Page<Profession>) professionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Profession profession) {
		professionMapper.insert(profession);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Profession profession){
		professionMapper.updateByPrimaryKey(profession);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Profession findOne(Integer id){
		return professionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			professionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Profession profession, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ProfessionExample example=new ProfessionExample();
		ProfessionExample.Criteria criteria = example.createCriteria();
		
		if(profession!=null){			
						if(profession.getProName()!=null && profession.getProName().length()>0){
				criteria.andProNameLike("%"+profession.getProName()+"%");
			}
	
		}
		
		Page<Profession> page= (Page<Profession>)professionMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
