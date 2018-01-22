package com.du.service;



import com.du.dao.ManagerMapper;
import com.du.dao.StudentUserMapper;

import com.du.entry.Manager;
import com.du.entry.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dcy on 2017/12/22.
 */
@Service
public class LoginService {
    @Autowired
    private StudentUserMapper studentUserMapper;
    @Autowired
     private ManagerMapper managerMapper;

    public String  login(String num,String pwd,String check){
        if(check.equals("true")){

            Manager manager=managerMapper.selectByPrimaryKey(num);
            if(manager.getWorkerName()!=null&&manager.getWorkerPwd().equals(pwd)){

                return manager.getWorkerName();
            }else{
                return "登录失败";
            }
        }else {
            StudentUser studentUser=studentUserMapper.selectByPrimaryKey(num);
            if(studentUser.getStudentNum()!=null&&studentUser.getPassword().equals(pwd)){
                return studentUser.getUserName();
            }else{
                return "登录失败";
            }
        }

    }
}
