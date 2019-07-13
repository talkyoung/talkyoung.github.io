package cn.sjxy.overdue.controller;

import java.util.HashMap;
import java.util.Map;

import cn.sjxy.overdue.service.SecretaryDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    SecretaryDetailServiceImpl secretaryDetailService;

    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        /*String name=SecurityContextHolder.getContext()
                .getAuthentication().getName();
        Map<String, String> map=new HashMap<String, String>();
        map.put("loginName", name);
        String result = JSON.toJSONString(map);
        System.out.println("result--------------------"+result);*/
        String username = secretaryDetailService.getUsername();
        Map<String, String> map=new HashMap<String, String>();
        map.put("loginName", username);
        String result = JSON.toJSONString(map);
        return result;
    }
//    @RequestMapping("/studentLogin")
//    public String toStudentLogin(){
//        return "student_login";
//    }
}