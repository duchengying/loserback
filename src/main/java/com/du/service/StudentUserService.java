package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoserGoodMapper;
import com.du.dao.StudentUserMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.entry.Manager;
import com.du.entry.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    /*添加留言信息*/
    public boolean addAdvise(String num,String msg){
        return true;
    }
}
