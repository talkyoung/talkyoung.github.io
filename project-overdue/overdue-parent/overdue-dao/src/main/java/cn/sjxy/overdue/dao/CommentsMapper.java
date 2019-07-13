package cn.sjxy.overdue.dao;

import cn.sjxy.overdue.pojo.Comments;
import cn.sjxy.overdue.pojo.CommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsMapper {
    int countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(Integer comId);

    int insert(Comments record);

    int insertSelective(Comments record);

    List<Comments> selectByExample(CommentsExample example);

    Comments selectByPrimaryKey(Integer comId);

    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}