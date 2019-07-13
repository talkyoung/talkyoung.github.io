package cn.sjxy.overdue.teacher.controller;

import cn.sjxy.overdue.pojo.File;
import cn.sjxy.overdue.pojo.Picture;
import cn.sjxy.overdue.pojo.Video;
import cn.sjxy.overdue.teacher.FastDFSClient;
import cn.sjxy.overdue.teacher.service.GetTeaIdService;
import cn.sjxy.overdue.teacher.service.ToPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.sjxy.overdue.pojo.entity.Result;

import java.util.Date;

@RestController
public class UploadController {
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址

    @Autowired
    ToPojoService toPojoService;
    @Autowired
    GetTeaIdService getTeaIdService;

    @RequestMapping("/upload")
//    public Result upload(@RequestParam(value = "file1") MultipartFile file, @RequestParam(value = "videoDetail") String videoDetail,@RequestParam(value = "courseId") Integer courseId, Model model) {
    public Result upload(MultipartFile file,String videoDetail,Integer courseId) {

        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient
                    = new FastDFSClient("classpath:fdfs_client.conf");

            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);

            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = "http://192.168.25.133/" + path;

            //获取当前教师的ID
            Integer teaId = getTeaIdService.getTeaId();
            if (!"mp4".equals(extName)) {
                File file1 = new File();
                file1.setfName(url);
                file1.settId(teaId);
                file1.setfUptime(new Date());
                file1.setfRealname(originalFilename);
                file1.setcId(courseId);
                toPojoService.toFile(file1);
                System.out.println(originalFilename + "originalFilename");
            }
            //创建一个pic实体，保存url和teaId到数据库中
            /*Picture picture = new Picture();
            picture.setpName(url);
            picture.settId(teaId);
            toPojoService.toPic(picture);
            */
            System.out.println(extName + "文件的扩展名");

            //创建video实体，保存url和teaId
            if ("mp4".equals(extName)) {
                Video video = new Video();
                video.setvName(url);
                video.settId(teaId);
                video.setvDetail(videoDetail);
                video.setvUptime(new Date());
                video.setcId(courseId);
                toPojoService.toVideo(video);
            }
//            model.addAttribute("msg","上传成功");
            return new Result(true,"上传成功");
        } catch (Exception e) {
            e.printStackTrace();
//            model.addAttribute("msg","上传失败");
            return new Result(false,"上传失败");
        }
    }
}
