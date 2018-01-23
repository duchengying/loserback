package com.du.controll;

import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.entry.StudentUser;
import com.du.service.LoseService;
import com.du.service.LoserService;
import com.du.service.StudentUserService;
import com.du.tool.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */


/*
* 相关请求使用复用
* */
@Controller
@RequestMapping("manager")
public class ManagerControll {


    @Autowired
    StudentUserService studentUserService;

    @Autowired
    LoseService loseService;
    @Autowired
    LoserService loserService;
    /*用户管理*/

        /*修改*/
        @ResponseBody
        @RequestMapping("repair_user")
        public String repair_user(StudentUser studentUser){
            if(studentUser.getUserName()==""||studentUser.getUserName()==null){
                System.out.println("为空");
                return "空值";
            }
            boolean ss=studentUserService.repair_message(studentUser);
            if(ss){
                return "true";
            }else {
                System.out.print("修改失败：Manager_controll");
                return "false";
            }

        }
        /* 删除

        * 可以接收多个id值
        *删除失败的id将返回到前端
        * */
        @ResponseBody
        @RequestMapping("delete_user")
        public ArrayList<String> delete_user(String... id){
           ArrayList<String> ss= studentUserService.delete(id);
           return ss;
        }
        /*添加
        * 单个添加
        *
        * */
        @ResponseBody
        @RequestMapping("add_user")
        public String add_user(StudentUser studentUser){
            boolean ss=studentUserService.addUser(studentUser);
            if(ss){
                return "true";
            }else {
                System.out.print("添加失败：Manager_controll");
                return "false";
            }
        }
        /*查询所有用户
        * 自动查找所有的信息
        * 进行分页处理
        * */
        @RequestMapping("select_alluser")
        @ResponseBody
        public PagedResult<StudentUser> select_alluser(Integer pageNumber, Integer pageSize){
            try{
                PagedResult<StudentUser> studentUserPagedResult=studentUserService.select_AllUser_Page(pageNumber, pageSize);
                return studentUserPagedResult;
            }catch (Exception e){
                return null;
            }


        }

    /*失物管理 */


        /*
        * 查询所有的失物信息
        * */

        @ResponseBody
        @RequestMapping("select_alllose")
        public PagedResult<LoseGood> select_alllose(Integer pageNumber, Integer pageSize){
            try {
                PagedResult<LoseGood> pageResult = loseService.all_lose(pageNumber, pageSize);
                return pageResult;
            } catch (Exception e) {
                return null;
            }
        }
        /*修改失物信息*/
        @ResponseBody
        @RequestMapping("repair_lose")
        public String repair_lose(LoseGood loseGood){
             int i=loseService.repair_loseGoodById(loseGood);
            if(i>0){
                return "true";
            }else {
                System.out.print("修改失败：Manager_controll");
                return "false";
            }

        }

        /*根据id删除失物信息*/
        @ResponseBody
        @RequestMapping("delete_lose")
        public ArrayList<Integer> delete_lose(int... id){
           ArrayList<Integer> error=loseService.delete_loseGoodById(id);
           return  error;
        }

        /*添加失物信息*/
        @ResponseBody
        @RequestMapping("add_lose")
        public String add_lose(LoseGood loseGood){
           int i= loseService.add_loseGood(loseGood);
           if(i<=0){
               return "false";
           }else {
               return "true";
           }
        }


    /*拾物管理*/

         /*
        * 查询所有的拾物信息
        * 分页
        * */
        @ResponseBody
        @RequestMapping("select_alllose")
        public PagedResult<LoserGood> select_allloser(Integer pageNumber, Integer pageSize){
            try {
                PagedResult<LoserGood> pageResult = loserService.all_loser(pageNumber, pageSize);
                return pageResult;
            } catch (Exception e) {
                return null;
            }
        }
        /*修改拾物信息*/
        @ResponseBody
        @RequestMapping("repair_loser")
        public String repair_loser(LoserGood losergood){
            int i=loserService.repair_loserGoodById(losergood);
            if(i<=0){
                return "false";
            }else{
                return "true";
            }
        }
        /*删除拾物信息 by:id*/
        @ResponseBody
        @RequestMapping("delete_loser")
        public ArrayList<Integer> delete_loser(int... id){
            ArrayList<Integer> error=loserService.delete_loserGoodById(id);
            return  error;
        }
        /*添加拾物信息*/
        @ResponseBody
        @RequestMapping("add_loser")
        public String add_loser(LoserGood loserGood){
            int i=loserService.add_loseGood(loserGood);
            if(i<=0){
                return "false";
            }else{
                return "true";
            }

        }
    /*审核管理 */

    /*审核*/
        @ResponseBody
        @RequestMapping("repair_check")
        public ArrayList<Integer> repair_check(String type,int... id){
            ArrayList<Integer> error;
            if(type=="拾物"){
              error =  loserService.checked(id);
              return  error;
            }else if(type=="失物"){
                error=loseService.checked(id);
                return  error;
            }else {
                return null;
            }
        }
    /*查询所有已经审核的信息*/
        @ResponseBody
        @RequestMapping("select_checked")
        public PagedResult<?> select_checked(String type,Integer pageNumber, Integer pageSize){
            if(type=="拾物"){
                try {
                    PagedResult<LoserGood> pageResult = loserService.all_loser(pageNumber, pageSize);
                    return pageResult;
                } catch (Exception e) {
                    return null;
                }
            }else if(type=="失物"){
                try {
                    PagedResult<LoseGood> pageResult = loseService.all_lose(pageNumber, pageSize);
                    return pageResult;
                } catch (Exception e) {
                    return null;
                }
            }else {
                return null;
            }
        }

    /*查询所有未审核的信息*/

    @ResponseBody
    @RequestMapping("select_check")
    public PagedResult<?> select_check(String type,Integer pageNumber, Integer pageSize){
        if(type=="拾物"){
            try {
                PagedResult<LoserGood> pageResult = loserService.selectcheck(pageNumber, pageSize);
                return pageResult;
            } catch (Exception e) {
                return null;
            }
        }else if(type=="失物"){
            try {
                PagedResult<LoseGood> pageResult = loseService.selectcheck(pageNumber, pageSize);
                return pageResult;
            } catch (Exception e) {
                return null;
            }
        }else {
            return null;
        }
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
    * 目前做系统邮件
    * */
    @ResponseBody
    @RequestMapping("email")
    public void send_email(String title,String msg,String time,String managernum){
        //将该信息保存在数据表email_M中

    }

    /*
    * manager的搜索功能
    * */

}
