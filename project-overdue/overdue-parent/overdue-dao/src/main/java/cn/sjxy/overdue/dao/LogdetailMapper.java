package cn.sjxy.overdue.dao;

import cn.sjxy.overdue.pojo.Logdetail;
import cn.sjxy.overdue.pojo.LogdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogdetailMapper {
    int countByExample(LogdetailExample example);

    int deleteByExample(LogdetailExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(Logdetail record);

    int insertSelective(Logdetail record);

    List<Logdetail> selectByExample(LogdetailExample example);

    Logdetail selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") Logdetail record, @Param("example") LogdetailExample example);

    int updateByExample(@Param("record") Logdetail record, @Param("example") LogdetailExample example);

    int updateByPrimaryKeySelective(Logdetail record);

    int updateByPrimaryKey(Logdetail record);
}