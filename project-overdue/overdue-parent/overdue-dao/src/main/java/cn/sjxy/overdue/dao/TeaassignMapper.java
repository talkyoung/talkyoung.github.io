package cn.sjxy.overdue.dao;

import cn.sjxy.overdue.pojo.Teaassign;
import cn.sjxy.overdue.pojo.TeaassignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaassignMapper {
    int countByExample(TeaassignExample example);

    int deleteByExample(TeaassignExample example);

    int deleteByPrimaryKey(Integer assId);

    int insert(Teaassign record);

    int insertSelective(Teaassign record);

    List<Teaassign> selectByExample(TeaassignExample example);

    Teaassign selectByPrimaryKey(Integer assId);

    int updateByExampleSelective(@Param("record") Teaassign record, @Param("example") TeaassignExample example);

    int updateByExample(@Param("record") Teaassign record, @Param("example") TeaassignExample example);

    int updateByPrimaryKeySelective(Teaassign record);

    int updateByPrimaryKey(Teaassign record);
}