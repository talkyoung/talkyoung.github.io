package cn.sjxy.overdue.teacher.service;

import cn.sjxy.overdue.dao.FileMapper;
import cn.sjxy.overdue.dao.PictureMapper;
import cn.sjxy.overdue.dao.VideoMapper;
import cn.sjxy.overdue.pojo.File;
import cn.sjxy.overdue.pojo.Picture;
import cn.sjxy.overdue.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToPojoService {
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    FileMapper fileMapper;

    public int toPic(Picture picture) {
        return pictureMapper.insert(picture);
    }

    public void toVideo(Video video) {
        videoMapper.insert(video);
    }

    public void toFile(File file) {
        fileMapper.insert(file);
    }
}
