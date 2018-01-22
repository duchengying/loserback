package com.du.controll;

import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.entry.StudentUser;
import com.du.service.StudentUserService;
import com.du.tool.AutoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */
@Controller
@RequestMapping("student_user")
public class StudentUserControll {
    @Autowired
    AutoSearch autoSearch;

    @Autowired
    StudentUserService studentUserService;
    /*自动加载最近的10个*/
    @CrossOrigin
    @RequestMapping("auto_lose")
    @ResponseBody
    public ArrayList<LoseGood> auto_lose(String start, String end){
        ArrayList<LoseGood> auto_lose= studentUserService.auto_lose(Integer.parseInt(start),Integer.parseInt(end));
        //System.out.print(auto_lose.get(0).getLoseName());
        return auto_lose;
    }
    @ResponseBody
    @RequestMapping("auto_loser")
    public  ArrayList<LoserGood> auto_loser(String start, String end){
        ArrayList<LoserGood> auto_loser= studentUserService.auto_loser(Integer.parseInt(start),Integer.parseInt(end));
        //System.out.print(auto_lose.get(0).getLoseName());
        return auto_loser;
    }
    @ResponseBody
        @RequestMapping("student_myself_message")
            public StudentUser student_myself_message(String num){
                StudentUser studentUser=studentUserService.student_myself_message(num);
                if(studentUser==null){
                    System.out.print("结果为空");
                    return null;
                }else {
            return  studentUser;
        }

    }
    @ResponseBody
    @RequestMapping("repair_message")
    public String   repair_message(StudentUser studentUser){
        if(studentUser.getUserName()==""){
            System.out.println("为空");
        }if(studentUser.getUserName()==null){
            System.out.println("为null");
        }
        boolean ss=studentUserService.repair_message(studentUser);
        if(ss){
            return "true";
        }else {
            System.out.print("修改失败：controll");
            return "false";
        }

    }
    @ResponseBody
    @RequestMapping("repair_pwd")
    public boolean  repair_pwd(String pwd,String studentnum){
        boolean ss=studentUserService.repair_pwd(pwd,studentnum);
        return ss;

    }
    /*@ResponseBody
    @RequestMapping("claimed")
    public void claimed(){

    }*/

    @ResponseBody
    @RequestMapping("search")
    public ArrayList<?> search(String lose_type,String goods_type,String time,String local,String key){

     ArrayList<?> arrayList=autoSearch.search(lose_type, goods_type, time, local, key);


    return arrayList;
    }

/*用户的留言*/
    @ResponseBody
    @RequestMapping("advise")
    public String advise(String usernum,String msg){
        /*首先验证num 的正确性，其次msg是否为空 最后进行存储*/
        StudentUser studentUser=studentUserService.selectByNum(usernum);
        if(studentUser!=null&&msg!=null&&msg!=""){
           boolean b= studentUserService.addAdvise(usernum, msg);
           if(b==true){
               return "提交成功";
           }else {
               return "提交失败";
           }

        }else {
            return "提交失败";
        }


    }
    /*发送邮件*/
    @ResponseBody
    @RequestMapping("send_email")
    public String sendEmail(/*邮件实体*/){
        /*调用同用的方法*/
        return "";
    }
    @ResponseBody
    @RequestMapping("get_email")
    public String getEmail(/*邮件实体*/){
        /*调用同用的方法*/
        return "";
    }

}
