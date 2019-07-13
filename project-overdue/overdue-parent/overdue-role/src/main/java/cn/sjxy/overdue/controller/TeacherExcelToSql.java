package cn.sjxy.overdue.controller;

import cn.sjxy.overdue.dao.TeacherMapper;
import cn.sjxy.overdue.pojo.Teacher;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherExcelToSql {
//    @Autowired
//    TeacherMapper teacherMapper;
//    public static void main(String[] args) {
//        System.out.println("hello");
//        FileInputStream fis = null;
//        try {
//            //C:\Users\hp\Desktop
//            fis = new FileInputStream("c:/Users/hp/Desktop/studentList.xls");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            HSSFWorkbook hwk = new HSSFWorkbook(fis);
//            HSSFSheet sheet = hwk.getSheetAt(0);
//            List<Teacher> teacherList = new ArrayList<Teacher>();
//            //遍历表格中所有的行 sheet.getLastCellNum 是获取最后一个不为空的行是第几个。
//            for (int i = 0; i < sheet.getLastRowNum(); i++) {
//                if (sheet.getRow(i) == null) {
//                    continue;
//                }
//                Teacher teacher = new Teacher();
//                //遍历表格中所有的单元格 sheet.getRow(i).getLastCellNum() 是获取最后一个不为空的列是第几个。
//
//                for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
//                    if (sheet.getRow(i).getCell(j) == null) {
//                        continue;
//                    }
////                    sheet.getRow(i).getCell(j).getStringCellValue()
////                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                    if(j == 0){
//                        teacher.setTeaName(sheet.getRow(i).getCell(j).getStringCellValue());
//                    }else if(j == 1){
//                        teacher.setTeaName(sheet.getRow(i).getCell(j).getStringCellValue());
//                    }else if(j == 2){
//                        sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
//                        teacher.setTeaCourse(Integer.valueOf(sheet.getRow(i).getCell(j).getStringCellValue()));
//                    }else if(j == 3){
//                        sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
//                        teacher.setTeaPhone(sheet.getRow(i).getCell(j).getStringCellValue());
//                    }
//                    sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
//                    System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +" ");
//                }
//                teacherList.add(teacher);
//                System.out.println();
//            }
//            System.out.println(teacherList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void insert(List<Teacher> list){
//        for(Teacher teacher:list){
//            teacherMapper.insert(teacher);
//        }
//    }
}
