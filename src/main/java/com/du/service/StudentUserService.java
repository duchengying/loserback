package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoserGoodMapper;
import com.du.dao.StudentUserMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.entry.Manager;
import com.du.entry.StudentUser;
import com.du.tool.BeanUtil;
import com.du.tool.PagedResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

/**
 * Created by dcy on 2017/12/22.
 */
@Service
public class StudentUserService {
    @Autowired
    LoseGoodMapper loseGoodMapper;
    @Autowired
    LoserGoodMapper loserGoodMapper;
    @Autowired
    StudentUserMapper studentUserMapper;

    public ArrayList<LoseGood> auto_lose(int start,int end){
        System.out.print(start+end);
        if(loseGoodMapper==null){
            System.out.print("adasdasd");
        }
       ArrayList<LoseGood> studentUserMappers= loseGoodMapper.selectAutoLoseGood(start,end);

        return studentUserMappers;
    }


    public ArrayList<LoserGood> auto_loser(int start,int end){
        System.out.print(start+end);
        if(loserGoodMapper==null){
            System.out.print("adasdasd");
        }
        ArrayList<LoserGood> loserGoods =loserGoodMapper.selectAutoLoserGood(start,end);

        return loserGoods;
    }
    public StudentUser student_myself_message(String num){

            StudentUser studentUser=studentUserMapper.selectByPrimaryKey(num);
            if(studentUser.getStudentNum()!=null){

                return studentUser;
            }else{
                System.out.print("没有查询到！");
                return null;
            }

    }
    public boolean repair_message(StudentUser studentUser){

      int i= studentUserMapper.updateByPrimaryKeySelective(studentUser);
        if(i>=0){

            return true;
        }else{
            System.out.print("修改失败");
            return false;
        }

    }
    public boolean repair_pwd(String pwd,String num){

        int i= studentUserMapper.updatePwd(pwd,num);
        if(i>=0){

            return true;
        }else{
            System.out.print("修改失败");
            return false;
        }

    }
    /*查询用户信息*/
    public StudentUser selectByNum(String num){
       StudentUser studentUser= studentUserMapper.selectByPrimaryKey(num);
       if(studentUser==null){
           return null;
       }else {
           return studentUser;
       }
    }

    /*
    * manager:删除用户信息
    * */

    public ArrayList<String> delete(String... id){
        ArrayList<String> error=new ArrayList<String>();
        for(String s:id){
           int i= studentUserMapper.deleteByPrimaryKey(s);
           if(i<=0){
               error.add(s);
           }
        }
        return error;
    }

    /*
    * manager：添加用户
    * */
    /*添加留言信息*/
    public boolean addUser(StudentUser studentUser){

        int i= studentUserMapper.insert(studentUser);
        if(i>=0){
            return true;
        }else{
            System.out.print("修改失败");
            return false;
        }

    }
    /*
    * manager:查询所有的用户信息
    * */
    public PagedResult<StudentUser> select_AllUser_Page(Integer pageNo, Integer pageSize ) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(studentUserMapper.selectAll());
    }
    /*测试储存过程*/
    public void selectAllUser(){
        long t1=System.currentTimeMillis();
        studentUserMapper.selectAll1();
        long t2=System.currentTimeMillis();
        studentUserMapper.selectAll();
        long t3=System.currentTimeMillis();
        System.out.println("函数：");
        System.out.println(t2-t1);
        System.out.println("正常：");
        System.out.println(t3-t2);


    }

    public boolean addAdvise(String num,String msg){
        return true;
    }
}
