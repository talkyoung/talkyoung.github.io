package cn.sjxy.overdue.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    @Autowired
    SecretaryMapper secretaryMapper;
    @org.junit.Test
    public void test1(){
        System.out.println(secretaryMapper);
    }
}
