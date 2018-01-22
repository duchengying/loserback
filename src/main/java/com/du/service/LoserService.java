package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoserGoodMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */
@Service
public class LoserService {
    @Autowired
    private LoserGoodMapper loserGoodMapper;


    /*
    * loser页面的自动查找该账号的失物信息
    * */
    public ArrayList<LoserGood> selectAutoLoserGoodByNum(String num){
        ArrayList<LoserGood> loserGoods= loserGoodMapper.selectAutoLoserGoodByNum(num);
        if(loserGoods.isEmpty()){
            System.out.println("没有查询结果");
        }

        return  loserGoods;
    }
    /*根据id修改失物信息*/
    public int repair_loserGoodById(LoserGood loserGood){
        int i= loserGoodMapper.updateByPrimaryKeySelective(loserGood);
        if(i<=0){
            System.out.println("修改失败");
        }
        return  i;
    }
    public int delete_loserGoodById(int id){
        int s=loserGoodMapper.deleteByPrimaryKey(id);
        return  s;
    }
    /*
    * 添加单个的拾物信息
    * */
    public int add_loseGood( LoserGood loserGood){
        int s= loserGoodMapper.insert(loserGood);
        return  s;
    }

    /*
    *查询所有的loser信息-一起提交到页面
    * */

    public ArrayList<LoserGood> all_loser(){
      ArrayList<LoserGood> loserGoods=  loserGoodMapper.selectAllLoser();
        System.out.println("loser   service");
        return loserGoods;
    }
}
