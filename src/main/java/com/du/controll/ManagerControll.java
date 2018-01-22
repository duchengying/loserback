package com.du.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dcy on 2017/12/22.
 */


/*
* 相关请求使用复用
* */
@Controller
@RequestMapping("manager")
public class ManagerControll {

    /*用户管理*/
    @ResponseBody
    @RequestMapping("repair_user")
    public void repair_user(){

    }
    @ResponseBody
    @RequestMapping("delete_user")
    public void delete_user(){

    }
    @ResponseBody
    @RequestMapping("add_user")
    public void add_user(){

    }
    /*失物管理
    * 自动查找所有的信息
    * */
    @RequestMapping("auto_lose")
    @ResponseBody
    public void auto_lose(){

    }
    @ResponseBody
    @RequestMapping("repair_lose")
    public void repair_lose(){

    }
    @ResponseBody
    @RequestMapping("delete_lose")
    public void delete_lose(){

    }
    @ResponseBody
    @RequestMapping("add_lose")
    public void add_lose(){

    }
     /*拾物管理
    * 自动查找所有的信息
    * */
     @RequestMapping("auto_loser")
     @ResponseBody
     public void auto_loser(){

     }
    @ResponseBody
    @RequestMapping("repair_loser")
    public void repair_loser(){

    }
    @ResponseBody
    @RequestMapping("delete_loser")
    public void delete_loser(){

    }
    @ResponseBody
    @RequestMapping("add_loser")
    public void add_loser(){

    }
    /*审核管理
    *
    *
    * */
    @ResponseBody
    @RequestMapping("repair_check")
    public void repair_check(){

    }
    /*发布信息管理
    *
    * 在已经审核的列表中在选择发布信息
    * */

    @ResponseBody
    @RequestMapping("take_out")
    public void take_out(){

    }
    /*邮件系统
    *
    * 目前计划有：
    * 发生邮件，接收邮件，删除邮件
    *
    * 发生邮件：指定发送人的账号即可发送
    *
    * */

}
