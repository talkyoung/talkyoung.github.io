package cn.sjxy.overdue.controller;

import cn.sjxy.overdue.dao.TeacherMapper;
import cn.sjxy.overdue.pojo.Teacher;
import cn.sjxy.overdue.pojo.entity.Result;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teacherExcel")
public class TeacherExcelController {
    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping("/importTea")
    public Result importTea(MultipartFile file) throws IOException {
        FileInputStream fis = null;
        String fileRealName = file.getOriginalFilename();//获得原始文件名;
        int pointIndex = fileRealName.lastIndexOf(".");//点号的位置
        String fileSuffix = fileRealName.substring(pointIndex);//截取文件后缀
        String fileNewName = String.valueOf(System.currentTimeMillis());//文件new名称时间戳
        String saveFileName = fileNewName.concat(fileSuffix);//文件存取名
        File f = new File(saveFileName);
        file.transferTo(f);
        try {
            //C:\Users\hp\Desktop
            fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            HSSFWorkbook hwk = new HSSFWorkbook(fis);
            HSSFSheet sheet = hwk.getSheetAt(0);
            List<Teacher> teacherList = new ArrayList<Teacher>();
            //遍历表格中所有的行 sheet.getLastCellNum 是获取最后一个不为空的行是第几个。
            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                if (sheet.getRow(i) == null) {
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                Teacher teacher = new Teacher();
                //遍历表格中所有的单元格 sheet.getRow(i).getLastCellNum() 是获取最后一个不为空的列是第几个。

                for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
                    if (sheet.getRow(i).getCell(j) == null) {
                        continue;
                    }
                    if (j == 0) {
                        teacher.setTeaName(sheet.getRow(i).getCell(j).getStringCellValue());
                    } else if (j == 1) {
                        teacher.setTeaPassword(sheet.getRow(i).getCell(j).getStringCellValue());
                    } else if (j == 2) {
                        teacher.setTeaCourse(sheet.getRow(i).getCell(j).getStringCellValue());
                    } else if (j == 3) {
                        sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        teacher.setTeaPhone(sheet.getRow(i).getCell(j).getStringCellValue());
                    }
                    sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                }
                teacherList.add(teacher);
            }
            for (Teacher teacher : teacherList) {
                teacherMapper.insert(teacher);
            }
            return new Result(true, "导入成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, "导入失败");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
