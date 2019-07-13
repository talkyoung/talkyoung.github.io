package cn.sjxy.overdue.dao;

import cn.sjxy.overdue.pojo.Picture;
import cn.sjxy.overdue.pojo.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    int countByExample(PictureExample example);

    int deleteByExample(PictureExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    Picture selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}