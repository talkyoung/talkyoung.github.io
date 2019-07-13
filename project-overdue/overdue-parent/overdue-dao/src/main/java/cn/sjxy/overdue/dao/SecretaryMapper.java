package cn.sjxy.overdue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sjxy.overdue.pojo.Secretary;
import cn.sjxy.overdue.pojo.SecretaryExample;
@Repository
public interface SecretaryMapper {
    int countByExample(SecretaryExample example);

    int deleteByExample(SecretaryExample example);

    int deleteByPrimaryKey(Integer secId);

    int insert(Secretary record);

    int insertSelective(Secretary record);

    List<Secretary> selectByExample(SecretaryExample example);

    Secretary selectByPrimaryKey(Integer secId);

    int updateByExampleSelective(@Param("record") Secretary record, @Param("example") SecretaryExample example);

    int updateByExample(@Param("record") Secretary record, @Param("example") SecretaryExample example);

    int updateByPrimaryKeySelective(Secretary record);

    int updateByPrimaryKey(Secretary record);
}