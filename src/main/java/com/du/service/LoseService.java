package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoseGoodsCopyMapper;
import com.du.dao.LoserGoodMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoseGoodsCopy;
import com.du.entry.LoserGood;
import com.du.tool.BeanUtil;
import com.du.tool.PagedResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */
@Service
public class LoseService {
    @Autowired
    private LoseGoodMapper loseGoodMapper;

    @Autowired
    private LoseGoodsCopyMapper loseGoodsCopy;


    /*
    * lose页面的自动查找该账号的失物信息
    * */
        public ArrayList<LoseGood> selectAutoLoseGoodByNum(String num){
            ArrayList<LoseGood> loseGoods= loseGoodMapper.selectAutoLoseGoodByNum(num);
            if(loseGoods.isEmpty()){
                System.out.println("没有查询结果");
            }
            return  loseGoods;
        }

    /*根据id修改失物信息*/
        public int repair_loseGoodById(LoseGood loseGood){
           int i= loseGoodMapper.updateByPrimaryKeySelective(loseGood);
           if(i<=0){
               System.out.println("修改失败");
           }
           return  i;
        }

    /*根据id删除失物信息*/

        public ArrayList<Integer> delete_loseGoodById(int... id){
            ArrayList<Integer> error=new ArrayList<>();
            for(int d:id){
                int s=loseGoodMapper.deleteByPrimaryKey(d);
                if(s<=0){
                    error.add(d);
                }
            }

            return  error;
        }

        public int delete_loseGoodById(int id){

                int s=loseGoodMapper.deleteByPrimaryKey(id);

            return  s;
        }

    /*
    * 根据其他来删除失物信息
    * */


    /*
    * 添加失物信息
    * */
        public int add_loseGood(LoseGood loseGood){
                int s= loseGoodMapper.insert(loseGood);
               return  s;
        }
 /*
    *查询所有的lose信息-一起提交到页面
    * 分页处理
    * */

        public PagedResult<LoseGood> all_lose(Integer pageNo, Integer pageSize ) {
            pageNo = pageNo == null?1:pageNo;
            pageSize = pageSize == null?10:pageSize;
            PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
            return BeanUtil.toPagedResult(loseGoodMapper.selectAllLose());
        }
    /*
    * 用来测试id为int的情况
    * *//*
    /*public int repair_loseGoodById(LoseGoodsCopy loseGood){
        int i= loseGoodsCopy.updateByPrimaryKeySelective(loseGood);
        if(i<=0){
            System.out.println("修改失败");
        }
        return  i;
    }*/
/*审核*/
    public  ArrayList<Integer> checked(int... id){
        ArrayList<Integer> error=new ArrayList<>();
        for(int d:id){
            int i=loseGoodMapper.checked(d);
            if(i<=0){
                error.add(i);
            }
        }
        return  error;
    }
    /*查询已审核的信息*/
    public  PagedResult<LoseGood> selectchecked(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loseGoodMapper.select_checked());
    }
    /*查询未审核的信息*/
    public  PagedResult<LoseGood> selectcheck(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loseGoodMapper.select_check());
    }
}
