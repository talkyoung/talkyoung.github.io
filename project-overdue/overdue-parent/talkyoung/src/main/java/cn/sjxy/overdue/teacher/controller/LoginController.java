package cn.sjxy.overdue.teacher.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/name")
    @ResponseBody
    public String name(){
        String name=SecurityContextHolder.getContext()
                .getAuthentication().getName();
        Map<String, String> map=new HashMap<String, String>();
        map.put("loginName", name);
        String result = JSON.toJSONString(map); 
        return result;
    }
    @RequestMapping("/login1")
    public String login1() {
    	return "index";
    }
}