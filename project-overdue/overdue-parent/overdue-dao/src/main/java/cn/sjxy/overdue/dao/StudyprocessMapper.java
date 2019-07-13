package cn.sjxy.overdue.dao;

import cn.sjxy.overdue.pojo.Studyprocess;
import cn.sjxy.overdue.pojo.StudyprocessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyprocessMapper {
    int countByExample(StudyprocessExample example);

    int deleteByExample(StudyprocessExample example);

    int deleteByPrimaryKey(Integer stuProId);

    int insert(Studyprocess record);

    int insertSelective(Studyprocess record);

    List<Studyprocess> selectByExample(StudyprocessExample example);

    Studyprocess selectByPrimaryKey(Integer stuProId);

    int updateByExampleSelective(@Param("record") Studyprocess record, @Param("example") StudyprocessExample example);

    int updateByExample(@Param("record") Studyprocess record, @Param("example") StudyprocessExample example);

    int updateByPrimaryKeySelective(Studyprocess record);

    int updateByPrimaryKey(Studyprocess record);
}