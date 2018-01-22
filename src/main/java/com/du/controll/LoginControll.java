package com.du.controll;

import com.du.dao.StudentUserMapper;
import com.du.entry.Login;
import com.du.service.LoginService;
import com.du.tool.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by dcy on 2017/12/21.
 */
@RestController
public class LoginControll {
    @Autowired
   private LoginService loginService;
    @Autowired
    Login login;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Login login(@RequestParam String student_num, @RequestParam String student_pwd,
                        @RequestParam String check, HttpServletResponse response, HttpServletRequest request){
        //这里可以的方法的重载-参数的个数来判断是否是管理员登录
       String ss=loginService.login(student_num,student_pwd,check);
    if(ss!="登录失败"&&ss!=null&&ss!=""){
        String token=jwtTokenUtil.createJWT(student_num);
       /* response.setHeader("Content-Types",token);
        Cookie cokie=new Cookie("token",token);
        response.addCookie(cokie);
        response.setHeader("Accept-Language","zh-cn,zh;q=0.5");*/
        login.setName(ss);
        login.setTime(new Date().toString());
        login.setToken(token);
        login.setNum(student_num);
      /*  System.out.println("测试git");
        System.out.println("测试第二次");*/


    }
     return login;
    }

}
