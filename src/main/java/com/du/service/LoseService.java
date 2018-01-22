package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoseGoodsCopyMapper;
import com.du.dao.LoserGoodMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoseGoodsCopy;
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
    public int delete_loseGoodById(int id){
        int s=loseGoodMapper.deleteByPrimaryKey(id);
        return  s;
    }
public int add_loseGood(LoseGood loseGood){
        int s= loseGoodMapper.insert(loseGood);
       return  s;
    }
 /*
    *查询所有的lose信息-一起提交到页面
    * */

    public ArrayList<LoseGood> all_lose(){
        ArrayList<LoseGood> loseGoods=loseGoodMapper.selectAllLose();
        return loseGoods;
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
}
