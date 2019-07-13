package cn.sjxy.overdue.controller;

import cn.sjxy.overdue.dao.SecretaryMapper;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.method.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapperTest {
    @Test
    public void test1() {
        String s = "[1,2,3]";
        String substring = s.substring(1, s.length()-1);
        String[] split = substring.split(",");
        List<String> list = Arrays.asList(split);
        String s1 = list.toString();
        System.out.println(s1);
    }
}
