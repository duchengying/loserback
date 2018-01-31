package com.du.controll;

import com.du.entry.Emaile_M;
import com.du.entry.LoseGood;
import com.du.service.Email_MService;
import com.du.service.StudentUserService;
import com.du.service.Testservice;
import com.du.tool.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by dcy on 2017/12/21.
 */
/*
* 目前测试单使用Controller，如果要用RequestMapping作用在类上，
* 则需要在配置中添加spring.mvc.view.prefix=/，表示访问的是Static中的静态资源
* 如果只作用在方法上，则不需要
*
* 总结：test目前的结果，controller类在没用使用模板前，‘/’表示访问static下的资源，
* 例如：/index.html,表示访问static下的index.html，必须加上/，否则访问不到static下。
* */
@Controller
@RequestMapping("test")
public class TestControll {

    @Autowired
    Testservice testservice;
    @Autowired
    StudentUserService studentUserService;

    @RequestMapping("pp")
    public String test() {
        return "/index.html";
    }

    @RequestMapping("qtest")
    public String test2() {
        System.out.print("id+name");

        return "/index2.html";
    }

    @RequestMapping("ss")
    public String test3() {
        return "/html/login.html";
    }

    /*测试分页*/
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    public PagedResult<LoseGood> list(Integer pageNumber, Integer pageSize) {
        String userName=null;
        try {
            PagedResult<LoseGood> pageResult = testservice.queryByPage(userName, pageNumber, pageSize);
            return pageResult;
        } catch (Exception e) {
            return null;
        }
    }
    @RequestMapping("sendemail")
    public void testssa(){
        Emaile_M emaile_m=new Emaile_M(1,"ssss","qw","sffsasdas");

        System.out.println(emaile_m.toString());
        Email_MService email_mService=new Email_MService();
        email_mService.sendemail(emaile_m);

    }

    @RequestMapping("selectAlluser")
    public void selectAllUser(){
            studentUserService.selectAllUser();
    }

    public void proxytest(){
        LoginControll loginControll=new LoginControll();
        loginControll.getClass().getMethods();
        HashSet Hash=new HashSet();
        HashMap hashMap=new HashMap();
    }
}
